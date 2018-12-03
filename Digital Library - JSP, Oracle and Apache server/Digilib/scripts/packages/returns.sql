create or replace package RETURNS
as

function	ADD(	i_referenceno TRANSACTION.TRANSACTIONNO%type,
		i_auduser RETURN.AUDUSER%type)
	return number;

function	REMOVE(	i_documentno RETURN.DOCUMENTNO%type,
		i_itemno ITEM.ITEMNO%type,
		i_auduser RETURN.AUDUSER%type)
	return number;

function	POST(	i_documentno RETURN.DOCUMENTNO%type,
		i_auduser RETURN.AUDUSER%type)
	return number;

end RETURNS;
/

create or replace package body RETURNS
as

function	ADD(	i_referenceno TRANSACTION.TRANSACTIONNO%type,
		i_auduser RETURN.AUDUSER%type)
	return number
as
	l_data TRANSACTION%rowtype;
	l_documentno RETURN.DOCUMENTNO%type;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	TRANSACTION
		where	TRANSACTIONNO = i_referenceno;

		select	DOCUMENTNO
		into	l_documentno
		from	RETURN
		where	MEMBERID = l_data.MEMBERID
		and	STATUS = 1;

		insert into RETURNDETAIL
			(DOCUMENTNO, ITEMNO, COPYNO, DETAILDATE, REFERENCENO, AUDUSER, AUDTIME)
		values	(l_documentno, l_data.ITEMNO, l_data.COPYNO, sysdate, i_referenceno, upper(i_auduser), sysdate);

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when no_data_found then
		insert into RETURN
			(DOCUMENTDATE, MEMBERID, STATUS, AUDUSER, AUDTIME)
		values	(sysdate, l_data.MEMBERID, 1, upper(i_auduser), sysdate);
		return ADD(i_referenceno, i_auduser);
	when others then
		raise_application_error(-20999, 'Loi he thong', true);
end	ADD;

function	REMOVE(	i_documentno RETURN.DOCUMENTNO%type,
		i_itemno ITEM.ITEMNO%type,
		i_auduser RETURN.AUDUSER%type)
	return number
as
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		delete
		from	RETURNDETAIL
		where	DOCUMENTNO = i_documentno
		and	ITEMNO = i_itemno;

		l_result := 1;
	else
		l_result := 0;
	end if;	

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end	REMOVE;

function	POST(	i_documentno RETURN.DOCUMENTNO%type,
		i_auduser RETURN.AUDUSER%type)
	return number
as
	l_data RETURN%rowtype;
	cursor cs_returns (ci_documentno RETURN.DOCUMENTNO%type) is
		select	*
		from	RETURNDETAIL
		where	DOCUMENTNO = ci_documentno;
	cursor cs_waitinglist (ci_itemno ITEM.ITEMNO%type) is
		select	TRANSACTIONNO
		from	WAITINGLIST
		where	ITEMNO = ci_itemno
		order by	PRIORITY desc, TRANSACTIONNO asc;
	l_waiting TRANSACTION.TRANSACTIONNO%type;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	RETURN
		where	DOCUMENTNO = i_documentno
		for	update;

		for cs_return in cs_returns(i_documentno) loop
			insert into TRANSACTION
				(TRANSACTIONTYPE, TRANSACTIONDATE, DUEDATE, MEMBERID, DOCUMENTNO, REFERENCENO, ITEMNO, COPYNO, STATUS, AUDUSER, AUDTIME)
			values	(3, sysdate, sysdate, l_data.MEMBERID, i_documentno, cs_return.REFERENCENO, cs_return.ITEMNO, cs_return.COPYNO, 0, upper(i_auduser), sysdate);

			open cs_waitinglist(cs_return.ITEMNO);
			fetch cs_waitinglist into l_waiting;
			if (cs_waitinglist%found) then
				update	TRANSACTION
				set	COPYNO = cs_return.COPYNO
				where	TRANSACTIONNO = l_waiting;
			else
				update	COPY
				set	STATUS = 1
				where	ITEMNO = cs_return.ITEMNO
				and	COPYNO = cs_return.COPYNO;
			end if;
			update	TRANSACTION
			set	STATUS = 0,
				AUDUSER = upper(i_auduser),
				AUDTIME = sysdate
			where	TRANSACTIONNO = cs_return.REFERENCENO
			or	(	TRANSACTIONTYPE = 2
			and	REFERENCENO = cs_return.REFERENCENO);
			close cs_waitinglist;
		end loop;

		update	RETURN
		set	STATUS = 0,
			POSTEDDATE = sysdate,
			AUDUSER = upper(i_auduser),
			AUDTIME = sysdate
		where	DOCUMENTNO = i_documentno;

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end 	POST;

end RETURNS;
/
create or replace package EXPANSIONS
as

function	ADD(	i_referenceno TRANSACTION.TRANSACTIONNO%type,
		i_auduser EXPANSION.AUDUSER%type)
	return number;

function	REMOVE(	i_documentno EXPANSION.DOCUMENTNO%type,
		i_itemno EXPANSIONDETAIL.ITEMNO%type,
		i_auduser EXPANSION.AUDUSER%type)
	return number;

function	POST(	i_documentno EXPANSION.DOCUMENTNO%type,
		i_auduser EXPANSION.AUDUSER%type)
	return number;

end EXPANSIONS;
/

create or replace package body EXPANSIONS
as

function	ADD(	i_referenceno TRANSACTION.TRANSACTIONNO%type,
		i_auduser EXPANSION.AUDUSER%type)
	return number
as
	l_data TRANSACTION%rowtype;
	l_documentno EXPANSION.DOCUMENTNO%type;
	l_detailscount number;
	l_maxexpansions MEMBERGROUP.MAXEXPANSIONS%type;
	l_result number;
begin
	if (MEMBERS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	TRANSACTION
		where	TRANSACTIONNO = i_referenceno;
		
		select	DOCUMENTNO
		into	l_documentno
		from	EXPANSION
		where	MEMBERID = l_data.MEMBERID
		and	STATUS = 1;

		select	count(*)
		into	l_detailscount
		from	EXPANSIONDETAIL
		where	DOCUMENTNO = l_documentno;

		select	MAXEXPANSIONS
		into	l_maxexpansions
		from	MEMBERVIEW
		where	MEMBERID = l_data.MEMBERID;

		if (l_detailscount > l_maxexpansions) then
			raise_application_error(-20061, 'You can only expansion maximum is 3 times');
		else
			insert into EXPANSIONDETAIL
				(DOCUMENTNO, ITEMNO, COPYNO, DETAILDATE, REFERENCENO, AUDUSER, AUDTIME)
			values	(l_documentno, l_data.ITEMNO, l_data.COPYNO, sysdate, i_referenceno, upper(i_auduser), sysdate);
		end if;

		l_result := 1;
		
	else
		l_result := 0;
	end if;
	
	return (l_result);
exception
	when no_data_found then
		insert into EXPANSION
			(MEMBERID, DOCUMENTDATE, STATUS, AUDUSER, AUDTIME)
		values	(l_data.MEMBERID, sysdate, 1, upper(i_auduser), sysdate);
		return ADD(i_referenceno, i_auduser);
	when others then
		raise_application_error(-20999, 'System Error', true);
end	ADD;

function	REMOVE(	i_documentno EXPANSION.DOCUMENTNO%type,
		i_itemno EXPANSIONDETAIL.ITEMNO%type,
		i_auduser EXPANSION.AUDUSER%type)
	return number
as
	l_result number;
begin
	if (MEMBERS.VALIDATE(i_auduser) = 1) then
		delete
		from	EXPANSIONDETAIL
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
end 	REMOVE;

function	POST(	i_documentno EXPANSION.DOCUMENTNO%type,
		i_auduser EXPANSION.AUDUSER%type)
	return number
as
	l_data EXPANSION%rowtype;
	l_detailscount number;
	l_currentexpansions number;
	l_maxexpansions MEMBERGROUP.MAXEXPANSIONS%type;
	l_expansionduration MEMBERGROUP.EXPANSIONDURATION%type;
	l_curwaitings number;
	cursor cs_expansions (ci_documentno EXPANSION.DOCUMENTNO%type) is
		select	*
		from	EXPANSIONDETAIL
		where	DOCUMENTNO = ci_documentno;
	l_result number;
begin
	if (MEMBERS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	EXPANSION
		where	DOCUMENTNO = i_documentno
		for update;

		select	count(rownum)
		into	l_detailscount
		from	EXPANSIONDETAIL
		where	DOCUMENTNO = i_documentno;

		select	count(rownum)
		into	l_currentexpansions
		from	EXPANSIONLIST
		where	MEMBERID = l_data.MEMBERID;

		select	MAXEXPANSIONS, EXPANSIONDURATION
		into	l_maxexpansions, l_expansionduration
		from	MEMBERVIEW
		where	MEMBERID = l_data.MEMBERID;

		if (l_detailscount + l_currentexpansions > l_maxexpansions) then
			raise_application_error(-20063, 'System dont allow you borrow more than assignment');
		elsif (l_detailscount <= 0) then
			raise_application_error(-20064, 'Borrow card is null');
		else
			for cs_expansion in cs_expansions(i_documentno) loop
				
				select	count(rownum)
				into	l_curwaitings
				from	WAITINGLIST
				where	ITEMNO = cs_expansion.ITEMNO;

				if (l_curwaitings = 0) then
					insert into TRANSACTION
						(TRANSACTIONTYPE, TRANSACTIONDATE, DUEDATE, MEMBERID, DOCUMENTNO, REFERENCENO, ITEMNO, COPYNO, STATUS, AUDUSER, AUDTIME)
					values	(2, sysdate, sysdate+l_expansionduration, l_data.MEMBERID, i_documentno, cs_expansion.REFERENCENO, cs_expansion.ITEMNO, cs_expansion.COPYNO, 1, upper(i_auduser), sysdate);
				end if;

			end loop;

			update	EXPANSION
			set	STATUS = 0,
				POSTEDDATE = sysdate,
				AUDUSER = upper(i_auduser),
				AUDTIME = sysdate
			where	DOCUMENTNO = i_documentno;
		end if;

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when no_data_found then
		raise_application_error(-20062, 'Dont have borrow card');
	when others then
		raise_application_error(-20999, 'System Error', true);
end	POST;

end EXPANSIONS;
/
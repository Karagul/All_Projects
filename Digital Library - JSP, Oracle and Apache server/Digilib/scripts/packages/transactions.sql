create or replace package TRANSACTIONS
as

function	ADD(	i_transactiontype TRANSACTION.TRANSACTIONTYPE%type,
		i_duedate TRANSACTION.DUEDATE%type,
		i_memberid TRANSACTION.MEMBERID%type,
		i_documentno TRANSACTION.DOCUMENTNO%type,
		i_referenceno TRANSACTION.REFERENCENO%type,
		i_itemno TRANSACTION.ITEMNO%type,
		i_copyno TRANSACTION.COPYNO%type := null,
		i_status TRANSACTION.STATUS%type := 1,
		i_auduser TRANSACTION.AUDUSER%type)
	return number;
function MODIFY(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
		i_transactiontype TRANSACTION.TRANSACTIONTYPE%type := null,
		i_transactiondate TRANSACTION.TRANSACTIONDATE%type := null,
		i_duedate TRANSACTION.DUEDATE%type,
		i_memberid TRANSACTION.MEMBERID%type := null,
		i_documentno TRANSACTION.DOCUMENTNO%type := null,
		i_referenceno TRANSACTION.REFERENCENO%type := null,
		i_itemno TRANSACTION.ITEMNO%type := null,
		i_copyno TRANSACTION.COPYNO%type := null,
		i_status TRANSACTION.STATUS%type := null,
		i_auduser TRANSACTION.AUDUSER%type)
	return number;
function	REMOVE(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
		i_auduser TRANSACTION.AUDUSER%type)
	return number;

function	GETTRANSACTIONTYPE(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.TRANSACTIONTYPE%type;
function	GETTRANSACTIONDATE(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.TRANSACTIONDATE%type;
function	GETDUEDATE(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.DUEDATE%type;
function	GETMEMBERID(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.MEMBERID%type;
function	GETDOCUMENTNO(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.DOCUMENTNO%type;
function	GETREFERENCENO(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.REFERENCENO%type;
function	GETITEMNO(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.ITEMNO%type;
function	GETCOPYNO(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.COPYNO%type;
function	GETSTATUS(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.STATUS%type;
function	GETAUDUSER(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.AUDUSER%type;
function	GETAUDTIME(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.AUDTIME%type;

function	GETBOOKINGS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number;
function	GETBOOKINGSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
				i_itemno TRANSACTION.ITEMNO%type := null)
	return number;
function	GETWAITINGS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number;
function	GETWAITINGSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
				i_itemno TRANSACTION.ITEMNO%type := null)
	return number;
function	GETLOANS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number;
function	GETLOANSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number;
function	GETEXPANSIONS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number;
function	GETEXPANSIONSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number;
function	GETRETURNS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number;
function	GETRETURNSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number;

function	SETTRANSACTIONTYPE(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.TRANSACTIONTYPE%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number;
function	SETTRANSACTIONDATE(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.TRANSACTIONDATE%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number;
function	SETDUEDATE(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.DUEDATE%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number;
function	SETMEMBERID(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.MEMBERID%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number;
function	SETDOCUMENTNO(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.DOCUMENTNO%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number;
function	SETREFERENCENO(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.REFERENCENO%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number;
function	SETITEMNO(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.ITEMNO%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number;
function	SETCOPYNO(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.COPYNO%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number;
function	SETSTATUS(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.STATUS%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number;

end TRANSACTIONS;
/

create or replace package body TRANSACTIONS
as

function	ADD(	i_transactiontype TRANSACTION.TRANSACTIONTYPE%type,
		i_duedate TRANSACTION.DUEDATE%type,
		i_memberid TRANSACTION.MEMBERID%type,
		i_documentno TRANSACTION.DOCUMENTNO%type,
		i_referenceno TRANSACTION.REFERENCENO%type,
		i_itemno TRANSACTION.ITEMNO%type,
		i_copyno TRANSACTION.COPYNO%type := null,
		i_status TRANSACTION.STATUS%type := 1,
		i_auduser TRANSACTION.AUDUSER%type)
	return number
as
	l_result number;
	l_validate number;
begin
	if i_transactiontype = 0 or i_transactiontype = 2 then
		l_validate := MEMBERS.VALIDATE(i_auduser);
	else
		l_validate := LIBRARIANS.VALIDATE(i_auduser);
	end if;

	if l_validate = 1 then
		insert into TRANSACTION
			(TRANSACTIONTYPE, TRANSACTIONDATE, DUEDATE, MEMBERID, DOCUMENTNO, REFERENCENO, ITEMNO, COPYNO, STATUS, AUDUSER, AUDTIME)
		values	(i_transactiontype, sysdate, i_duedate, i_memberid, i_documentno, i_referenceno, i_itemno, i_copyno, i_status, i_auduser, sysdate);
	
		l_result := 0;
	else
		l_result := 1;
	end if;

	return (l_result);
exception
	when others then
		return (-1);
end	ADD;

function MODIFY(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
		i_transactiontype TRANSACTION.TRANSACTIONTYPE%type := null,
		i_transactiondate TRANSACTION.TRANSACTIONDATE%type := null,
		i_duedate TRANSACTION.DUEDATE%type,
		i_memberid TRANSACTION.MEMBERID%type := null,
		i_documentno TRANSACTION.DOCUMENTNO%type := null,
		i_referenceno TRANSACTION.REFERENCENO%type := null,
		i_itemno TRANSACTION.ITEMNO%type := null,
		i_copyno TRANSACTION.COPYNO%type := null,
		i_status TRANSACTION.STATUS%type := null,
		i_auduser TRANSACTION.AUDUSER%type)
	return number
as
	l_result number;
	l_data TRANSACTION%rowtype;
begin
	if LIBRARIANS.VALIDATE(i_auduser) = 1 then
		select	*
		into	l_data
		from	TRANSACTION
		where	TRANSACTIONNO = i_transactionno
		for update;	

		if sql%found then
			if i_transactiontype is not null then
				l_data.TRANSACTIONTYPE := i_transactiontype;
			end if;
			if i_transactiondate is not null then
				l_data.TRANSACTIONDATE := i_transactiondate;
			end if;
			if i_duedate is not null then
				l_data.DUEDATE := i_duedate;
			end if;
			if i_memberid is not null then
				l_data.MEMBERID := i_memberid;
			end if;
			if i_documentno is not null then
				l_data.DOCUMENTNO := i_documentno;
			end if;
			if i_referenceno is not null then
				l_data.REFERENCENO := i_referenceno;
			end if;
			if i_itemno is not null then
				l_data.ITEMNO := i_itemno;
			end if;
			if i_copyno is not null then
				l_data.COPYNO := i_copyno;
			end if;
			if i_status is not null then
				l_data.STATUS := i_status;
			end if;

			update	TRANSACTION
			set	TRANSACTIONTYPE = l_data.TRANSACTIONTYPE,
				TRANSACTIONDATE = l_data.TRANSACTIONDATE,
				DUEDATE = l_data.DUEDATE,
				MEMBERID = l_data.MEMBERID,
				DOCUMENTNO = l_data.DOCUMENTNO,
				REFERENCENO = l_data.REFERENCENO,
				ITEMNO = l_data.ITEMNO,
				COPYNO = l_data.COPYNO,
				STATUS = l_data.STATUS,
				AUDUSER = upper(i_auduser),
				AUDTIME = sysdate
			where	TRANSACTIONNO = i_transactionno;

			l_result := 0;
		else
			l_result := 2;
		end if;
	else
		l_result := 1;
	end if;
	
	return (l_result);
exception
	when others then
		return (-1);
end	MODIFY;

function	REMOVE(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
		i_auduser TRANSACTION.AUDUSER%type)
	return number
as
	l_result number;
begin
	if LIBRARIANS.VALIDATE(i_auduser) = 1 then
		delete
		from	TRANSACTION
		where	TRANSACTIONNO = i_transactionno;
	else
		l_result := 1;
	end if;

	return (l_result);
exception
	when others then
		return (-1);
end	REMOVE;

function	GETTRANSACTIONTYPE(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.TRANSACTIONTYPE%type
as
	l_result TRANSACTION.TRANSACTIONTYPE%type;
begin
	select	TRANSACTIONTYPE
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETTRANSACTIONTYPE;

function	GETTRANSACTIONDATE(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.TRANSACTIONDATE%type
as
	l_result TRANSACTION.TRANSACTIONDATE%type;
begin
	select	TRANSACTIONDATE
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETTRANSACTIONDATE;

function	GETDUEDATE(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.DUEDATE%type
as
	l_result TRANSACTION.DUEDATE%type;
begin
	select	DUEDATE
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETDUEDATE;

function	GETMEMBERID(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.MEMBERID%type
as
	l_result TRANSACTION.MEMBERID%type;
begin
	select	MEMBERID
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETMEMBERID;

function	GETDOCUMENTNO(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.DOCUMENTNO%type
as
	l_result TRANSACTION.DOCUMENTNO%type;
begin
	select	DOCUMENTNO
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETDOCUMENTNO;

function	GETREFERENCENO(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.REFERENCENO%type
as
	l_result TRANSACTION.REFERENCENO%type;
begin
	select	REFERENCENO
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETREFERENCENO;

function	GETITEMNO(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.ITEMNO%type
as
	l_result TRANSACTION.ITEMNO%type;
begin
	select	ITEMNO
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETITEMNO;

function	GETCOPYNO(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.COPYNO%type
as
	l_result TRANSACTION.COPYNO%type;
begin
	select	COPYNO
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETCOPYNO;

function	GETSTATUS(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.STATUS%type
as
	l_result TRANSACTION.STATUS%type;
begin
	select	STATUS
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETSTATUS;

function	GETAUDUSER(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.AUDUSER%type
as
	l_result TRANSACTION.AUDUSER%type;
begin
	select	AUDUSER
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETAUDUSER;

function	GETAUDTIME(i_transactionno TRANSACTION.TRANSACTIONNO%type) return TRANSACTION.AUDTIME%type
as
	l_result TRANSACTION.AUDTIME%type;
begin
	select	AUDTIME
	into	l_result
	from	TRANSACTION
	where	TRANSACTIONNO = i_transactionno;

	return (l_result);
exception
	when others then
		return (null);
end	GETAUDTIME;

function	GETBOOKINGS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	BOOKINGLIST
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	BOOKINGLIST
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	BOOKINGLIST
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	BOOKINGLIST;
		end if;
	end if;

	return (l_result);
end	GETBOOKINGS;

function	GETBOOKINGSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
				i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	BOOKINGLISTONLINE
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	BOOKINGLISTONLINE
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	BOOKINGLISTONLINE
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	BOOKINGLISTONLINE;
		end if;
	end if;

	return (l_result);
end	GETBOOKINGSONLINE;

function	GETWAITINGS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	WAITINGLIST
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	WAITINGLIST
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	WAITINGLIST
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	WAITINGLIST;
		end if;
	end if;

	return (l_result);
end	GETWAITINGS;

function	GETWAITINGSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
				i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	WAITINGLISTONLINE
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	WAITINGLISTONLINE
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	WAITINGLISTONLINE
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	WAITINGLISTONLINE;
		end if;
	end if;

	return (l_result);
end	GETWAITINGSONLINE;

function	GETLOANS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	LOANLIST
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	LOANLIST
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	LOANLIST
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	LOANLIST;
		end if;
	end if;

	return (l_result);
end	GETLOANS;

function	GETLOANSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	LOANLISTONLINE
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	LOANLISTONLINE
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	LOANLISTONLINE
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	LOANLISTONLINE;
		end if;
	end if;

	return (l_result);
end	GETLOANSONLINE;

function	GETEXPANSIONS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	EXPANSIONLIST
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	EXPANSIONLIST
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	EXPANSIONLIST
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	EXPANSIONLIST;
		end if;
	end if;

	return (l_result);
end	GETEXPANSIONS;

function	GETEXPANSIONSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
				i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	EXPANSIONLISTONLINE
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	EXPANSIONLISTONLINE
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	EXPANSIONLISTONLINE
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	EXPANSIONLISTONLINE;
		end if;
	end if;

	return (l_result);
end	GETEXPANSIONSONLINE;

function	GETRETURNS(	i_memberid TRANSACTION.MEMBERID%type := null,
			i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	RETURNLIST
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	RETURNLIST
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	RETURNLIST
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	RETURNLIST;
		end if;
	end if;

	return (l_result);
end	GETRETURNS;

function	GETRETURNSONLINE(	i_memberid TRANSACTION.MEMBERID%type := null,
				i_itemno TRANSACTION.ITEMNO%type := null)
	return number
as
	l_result number;
begin
	if i_memberid is not null and i_itemno is not null then
		select	count(*)
		into 	l_result
		from	RETURNLISTONLINE
		where	MEMBERID = i_memberid
		and	ITEMNO = i_itemno;
	else
		if i_memberid is not null then
			select	count(*)
			into	l_result
			from	RETURNLISTONLINE
			where	MEMBERID = i_memberid;
		elsif i_itemno is not null then
			select	count(*)
			into	l_result
			from	RETURNLISTONLINE
			where	ITEMNO = i_itemno;
		else
			select	count(*)
			into	l_result
			from	RETURNLISTONLINE;
		end if;
	end if;

	return (l_result);
end	GETRETURNSONLINE;

function	SETTRANSACTIONTYPE(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.TRANSACTIONTYPE%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number
as
begin
	return MODIFY(i_transactionno, i_value, null, null, null, null, null, null, null, null, i_auduser);
end	SETTRANSACTIONTYPE;

function	SETTRANSACTIONDATE(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.TRANSACTIONDATE%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number
as
begin
	return MODIFY(i_transactionno, null, i_value, null, null, null, null, null, null, null, i_auduser);
end	SETTRANSACTIONDATE;

function	SETDUEDATE(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.DUEDATE%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number
as
begin
	return MODIFY(i_transactionno, null, null, i_value, null, null, null, null, null, null, i_auduser);
end	SETDUEDATE;

function	SETMEMBERID(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.MEMBERID%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number
as
begin
	return MODIFY(i_transactionno, null, null, null, i_value, null, null, null, null, null, i_auduser);
end	SETMEMBERID;

function	SETDOCUMENTNO(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.DOCUMENTNO%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number
as
begin
	return MODIFY(i_transactionno, null, null, null, null, i_value, null, null, null, null, i_auduser);
end	SETDOCUMENTNO;

function	SETREFERENCENO(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.REFERENCENO%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number
as
begin
	return MODIFY(i_transactionno, null, null, null, null, null, i_value, null, null, null, i_auduser);
end	SETREFERENCENO;

function	SETITEMNO(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.ITEMNO%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number
as
begin
	return MODIFY(i_transactionno, null, null, null, null, null, null, i_value, null, null, i_auduser);
end	SETITEMNO;

function	SETCOPYNO(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.COPYNO%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number
as
begin
	return MODIFY(i_transactionno, null, null, null, null, null, null, null, i_value, null, i_auduser);
end	SETCOPYNO;

function	SETSTATUS(	i_transactionno TRANSACTION.TRANSACTIONNO%type,
				i_value TRANSACTION.STATUS%type,
				i_auduser TRANSACTION.AUDUSER%type)
	return number
as
begin
	return MODIFY(i_transactionno, null, null, null, null, null, null, null, null, i_value, i_auduser);
end	SETSTATUS;

end TRANSACTIONS;
/
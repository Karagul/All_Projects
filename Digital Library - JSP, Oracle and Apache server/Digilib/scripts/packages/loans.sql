create or replace package LOANS
as

function	ADD(	i_referenceno TRANSACTION.TRANSACTIONNO%type,
		i_auduser LOAN.AUDUSER%type)
	return number;

function	REMOVE(	i_documentno LOAN.DOCUMENTNO%type,
		i_itemno LOANDETAIL.ITEMNO%type,
		i_auduser LOAN.AUDUSER%type)
	return number;

function	POST(	i_documentno LOAN.DOCUMENTNO%type,
		i_auduser LOAN.AUDUSER%type)
	return number;

end LOANS;
/

create or replace package body LOANS
as

function	ADD(	i_referenceno TRANSACTION.TRANSACTIONNO%type,
		i_auduser LOAN.AUDUSER%type)
	return number
as
	l_data TRANSACTION%rowtype;
	l_documentno LOAN.DOCUMENTNO%type;
	l_detailscount number;
	l_maxloans MEMBERGROUP.MAXLOANS%type;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	TRANSACTION
		where	TRANSACTIONNO = i_referenceno;
		
		select	DOCUMENTNO
		into	l_documentno
		from	LOAN
		where	MEMBERID = l_data.MEMBERID
		and	STATUS = 1;

		select	count(*)
		into	l_detailscount
		from	LOANDETAIL
		where	DOCUMENTNO = l_documentno;

		select	MAXLOANS
		into	l_maxloans
		from	MEMBERVIEW
		where	MEMBERID = l_data.MEMBERID;

		if (l_detailscount > l_maxloans) then
			raise_application_error(-20061, 'System dont allow you register more than assignment');
		else
			insert into LOANDETAIL
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
		insert into LOAN
			(MEMBERID, DOCUMENTDATE, STATUS, AUDUSER, AUDTIME)
		values	(l_data.MEMBERID, sysdate, 1, upper(i_auduser), sysdate);
		return ADD(i_referenceno, i_auduser);
	when others then
		raise_application_error(-20999, 'System Error', true);
end	ADD;

function	REMOVE(	i_documentno LOAN.DOCUMENTNO%type,
		i_itemno LOANDETAIL.ITEMNO%type,
		i_auduser LOAN.AUDUSER%type)
	return number
as
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		delete
		from	LOANDETAIL
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

function	POST(	i_documentno LOAN.DOCUMENTNO%type,
		i_auduser LOAN.AUDUSER%type)
	return number
as
	l_data LOAN%rowtype;
	l_detailscount number;
	l_currentloans number;
	l_maxloans MEMBERGROUP.MAXLOANS%type;
	l_loanduration MEMBERGROUP.LOANDURATION%type;
	cursor cs_loans (ci_documentno LOAN.DOCUMENTNO%type) is
		select	*
		from	LOANDETAIL
		where	DOCUMENTNO = ci_documentno;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	LOAN
		where	DOCUMENTNO = i_documentno
		for update;

		select	count(*)
		into	l_detailscount
		from	LOANDETAIL
		where	DOCUMENTNO = i_documentno;

		select	count(*)
		into	l_currentloans
		from	LOANLIST
		where	MEMBERID = l_data.MEMBERID;

		select	MAXLOANS, LOANDURATION
		into	l_maxloans, l_loanduration
		from	MEMBERVIEW
		where	MEMBERID = l_data.MEMBERID;

		if (l_detailscount + l_currentloans > l_maxloans) then
			raise_application_error(-20063, 'System dont allow you register more than assignment');
		elsif (l_detailscount <= 0) then
			raise_application_error(-20064, 'Loan card is null');
		else
			for cs_loan in cs_loans(i_documentno) loop
				insert into TRANSACTION
					(TRANSACTIONTYPE, TRANSACTIONDATE, DUEDATE, MEMBERID, DOCUMENTNO, REFERENCENO, ITEMNO, COPYNO, STATUS, AUDUSER, AUDTIME)
				values	(1, sysdate, sysdate+l_loanduration, l_data.MEMBERID, i_documentno, cs_loan.REFERENCENO, cs_loan.ITEMNO, cs_loan.COPYNO, 1, upper(i_auduser), sysdate);

				update	TRANSACTION
				set	STATUS = 0
				where	TRANSACTIONNO = cs_loan.REFERENCENO;
			end loop;

			update	LOAN
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
		raise_application_error(-20062, 'Dont have load card');
	when others then
		raise_application_error(-20999, 'System Error', true);
end	POST;

end LOANS;
/
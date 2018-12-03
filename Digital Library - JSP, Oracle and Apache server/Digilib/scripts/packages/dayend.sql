create or replace package DAYEND
as

function	PROCESSBOOKINGOVERDUE(i_auduser LIBRARIAN.LIBRARIANID%type) return number;
function	PROCESSLOANOVERDUE(i_auduser LIBRARIAN.LIBRARIANID%type) return number;

end DAYEND;
/

create or replace package body DAYEND
as

function	PROCESSBOOKINGOVERDUE(i_auduser LIBRARIAN.LIBRARIANID%type) return number
as
	cursor cs_overdues is
		select	*
		from	TRANSACTION
		where	TRANSACTIONNO in
		(
			select	TRANSACTIONNO
			from	TRANSACTIONOVERDUE
		)
		for	update;
	cursor cs_waitinglist (ci_itemno ITEM.ITEMNO%type) is
		select	TRANSACTIONNO
		from	WAITINGLIST
		where	ITEMNO = ci_itemno
		order by	PRIORITY desc, TRANSACTIONNO asc;
	l_waiting TRANSACTION.TRANSACTIONNO%type;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		for cs_overdue in cs_overdues loop
			if (cs_overdue.COPYNO is not null)  then
				open cs_waitinglist(cs_overdue.ITEMNO);
				fetch cs_waitinglist into l_waiting;
				if (cs_waitinglist%found) then
					update	TRANSACTION
					set	COPYNO = cs_overdue.COPYNO
					where	TRANSACTIONNO = l_waiting;
				else
					update	COPY
					set	STATUS = 1
					where	ITEMNO = cs_overdue.ITEMNO
					and	COPYNO = cs_overdue.COPYNO;
				end if;
				close cs_waitinglist;
			end if;

			update	TRANSACTION
			set	STATUS = 0
			where	current of cs_overdues;
		end loop;

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end	PROCESSBOOKINGOVERDUE;

function	PROCESSLOANOVERDUE(i_auduser LIBRARIAN.LIBRARIANID%type) return number
as
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1 ) then
		update	MEMBER
		set	STATUS = 0,
			AUDUSER = upper(i_auduser),
			AUDTIME = sysdate
		where	MEMBERID in
		(	select	MEMBERID
			from	LOANOVERDUELIST
		);

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end	PROCESSLOANOVERDUE;

end DAYEND;
/
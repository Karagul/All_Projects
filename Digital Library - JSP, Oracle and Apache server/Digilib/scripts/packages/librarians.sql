create or replace package LIBRARIANS
as

--Add a new Librarian
function	ADD(	i_librarianid LIBRARIAN.LIBRARIANID%type,
		i_name LIBRARIAN.NAME%type,
		i_password LIBRARIAN.PASSWORD%type,
		i_status LIBRARIAN.STATUS%type := 1,
		i_auduser LIBRARIAN.AUDUSER%type)
	return number;

--Modify information of an existing Librarian
function	MODIFY(	i_librarianid LIBRARIAN.LIBRARIANID%type,
		i_name LIBRARIAN.NAME%type,
		i_password LIBRARIAN.PASSWORD%type,
		i_status LIBRARIAN.STATUS%type,
		i_auduser LIBRARIAN.AUDUSER%type)
	return number;

--Remove existing Librarian
function	REMOVE(	i_librarianid LIBRARIAN.LIBRARIANID%type,
		i_auduser LIBRARIAN.AUDUSER%type)
	return number;

--Validate a Librarian (without Password)
function	VALIDATE(	i_librarianid LIBRARIAN.LIBRARIANID%type)
	return number;

--Validate a Librarian (with Password)
function	VALIDATE(	i_librarianid LIBRARIAN.LIBRARIANID%type,
			i_password LIBRARIAN.PASSWORD%type)
	return number;

end LIBRARIANS;
/

create or replace package body LIBRARIANS
as

--Add a new Librarian
function	ADD(	i_librarianid LIBRARIAN.LIBRARIANID%type,
		i_name LIBRARIAN.NAME%type,
		i_password LIBRARIAN.PASSWORD%type,
		i_status LIBRARIAN.STATUS%type := 1,
		i_auduser LIBRARIAN.AUDUSER%type)
	return number
as
	l_result number;
begin
	if (VALIDATE(i_auduser) = 1) then
		insert into LIBRARIAN
			(LIBRARIANID, NAME, PASSWORD, STATUS, AUDUSER, AUDTIME)
		values	(upper(i_librarianid), i_name, upper(i_password), i_status, upper(i_auduser), sysdate);
		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, sqlerrm);
end	ADD;

--Modify information of an existing Librarian
function	MODIFY(	i_librarianid LIBRARIAN.LIBRARIANID%type,
		i_name LIBRARIAN.NAME%type,
		i_password LIBRARIAN.PASSWORD%type,
		i_status LIBRARIAN.STATUS%type,
		i_auduser LIBRARIAN.AUDUSER%type)
	return number
as
	l_data LIBRARIAN%rowtype;
	l_result number;
begin
	select	*
	into	l_data
	from	LIBRARIAN
	where	upper(LIBRARIANID) = upper(i_librarianid)
	for	update;

	if  (substr(upper(i_auduser), 0, 5) = 'ADMIN' or upper(i_auduser) = upper(i_librarianid)) then
		if (VALIDATE(i_auduser) = 1) then
			if (i_name is not null) then
				l_data.NAME := i_name;
			end if;
			if (i_password is not null) then
				l_data.PASSWORD := i_password;
			end if;
			if (i_status is not null) then
				l_data.STATUS := i_status;
			end if;

			update	LIBRARIAN
			set	NAME = l_data.NAME,
				PASSWORD = upper(l_data.PASSWORD),
				STATUS = l_data.STATUS,
				AUDUSER = upper(i_auduser),
				AUDTIME = sysdate
			where	upper(LIBRARIANID) = upper(i_librarianid);

			l_result := 1;
		else
			l_result := 0;
		end if;		
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, sqlerrm);
end	MODIFY;

--Remove existing Librarian
function	REMOVE(	i_librarianid LIBRARIAN.LIBRARIANID%type,
		i_auduser LIBRARIAN.AUDUSER%type)
	return number
as
	l_status number;
	l_result number;
begin
	if (VALIDATE(i_auduser) = 1) then
		if (upper(i_librarianid) = 'ADMIN') then
			raise_application_error(-20010, 'Cant delete administrator of system');
		else
			select	STATUS
			into	l_status
			from	LIBRARIAN
			where	upper(LIBRARIANID) = upper(i_librarianid);
			if (l_status = 0) then
				delete
				from	LIBRARIAN
				where	upper(LIBRARIANID) = upper(i_librarianid);
				l_result := 1;
			else
				raise_application_error(-20000, 'Dont delete yourself when is activate');
			end if;
		end if;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, sqlerrm);
end	REMOVE;

--Validate a Librarian (without Password)
function	VALIDATE(	i_librarianid LIBRARIAN.LIBRARIANID%type)
	return number
as
	l_result number;
begin
	select	count(*)
	into	l_result
	from	LIBRARIAN
	where	upper(LIBRARIANID) = upper(i_librarianid)
	and	STATUS = 1;

	return (l_result);
end	VALIDATE;

--Validate a Librarian (with Password)
function	VALIDATE(	i_librarianid LIBRARIAN.LIBRARIANID%type,
			i_password LIBRARIAN.PASSWORD%type)
	return number
as
	l_result number;
begin
	select	count(*)
	into	l_result
	from	LIBRARIAN
	where	upper(LIBRARIANID) = upper(i_librarianid)
	and	upper(PASSWORD) like upper(i_password)
	and	STATUS = 1;

	return (l_result);
end	VALIDATE;

end LIBRARIANS;
/
create or replace package REGISTRATIONS
as

--Add new Registration
function	ADD(	i_name REGISTRATION.NAME%type,
		i_gender REGISTRATION.GENDER%type,
		i_birthday REGISTRATION.BIRTHDAY%type,
		i_address REGISTRATION.ADDRESS%type,
		i_phone REGISTRATION.PHONE%type,
		i_fax REGISTRATION.FAX%type,
		i_email REGISTRATION.EMAIL%type,
		i_password REGISTRATION.PASSWORD%type,
		i_picturetype REGISTRATION.PICTURETYPE%type := null,
		i_picture LONG RAW := null)
	return number;

--Remove existing Registration
function	REMOVE(	i_registrationno REGISTRATION.REGISTRATIONNO%type,
		i_auduser LIBRARIAN.LIBRARIANID%type)
	return number;
	
end REGISTRATIONS;
/

create or replace package body REGISTRATIONS
as

--Add new Registration
function	ADD(	i_name REGISTRATION.NAME%type,
		i_gender REGISTRATION.GENDER%type,
		i_birthday REGISTRATION.BIRTHDAY%type,
		i_address REGISTRATION.ADDRESS%type,
		i_phone REGISTRATION.PHONE%type,
		i_fax REGISTRATION.FAX%type,
		i_email REGISTRATION.EMAIL%type,
		i_password REGISTRATION.PASSWORD%type,
		i_picturetype REGISTRATION.PICTURETYPE%type := null,
		i_picture LONG RAW := null)
	return number
as
begin
	insert into REGISTRATION
		(NAME, GENDER, BIRTHDAY, ADDRESS, PHONE, FAX, EMAIL, PASSWORD, PICTURETYPE, PICTURE)
	values	(i_name, i_gender, i_birthday, i_address, i_phone, i_fax, i_email, i_password, i_picturetype, i_picture);

	return (1);
exception
	when others then
		raise_application_error(-20999, sqlerrm);
end	ADD;

--Remove existing Registration
function	REMOVE(	i_registrationno REGISTRATION.REGISTRATIONNO%type,
		i_auduser LIBRARIAN.LIBRARIANID%type)
	return number
as
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		delete
		from	REGISTRATION
		where	REGISTRATIONNO = i_registrationno;
		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, sqlerrm);
end;

end REGISTRATIONS;
/
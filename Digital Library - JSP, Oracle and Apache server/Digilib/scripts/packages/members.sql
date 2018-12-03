create or replace package MEMBERS
as

function	ADD(	i_registrationno REGISTRATION.REGISTRATIONNO%type,
		i_groupid MEMBERGROUP.GROUPID%type,
		i_auduser MEMBER.AUDUSER%type)
	return number;

function	MODIFY(	i_memberid MEMBER.MEMBERID%type,
		i_groupid MEMBER.GROUPID%type := null,
		i_name MEMBER.NAME%type := null,
		i_gender MEMBER.GENDER%type := null,
		i_birthday MEMBER.BIRTHDAY%type := null,
		i_address MEMBER.ADDRESS%type := null,
		i_phone MEMBER.PHONE%type := null,
		i_fax MEMBER.FAX%type := null,
		i_email MEMBER.EMAIL%type := null,
		i_password MEMBER.PASSWORD%type := null,
		i_picturetype MEMBER.PICTURETYPE%type := null,
		i_picture LONG RAW := null,
		i_expiredate MEMBER.EXPIREDATE%type := null,
		i_status MEMBER.STATUS%type := null,
		i_auduser MEMBER.AUDUSER%type)
	return number;

function	REMOVE(	i_memberid MEMBER.MEMBERID%type,
		i_auduser MEMBER.AUDUSER%type)
	return number;

function	VALIDATE(	i_memberid MEMBER.MEMBERID%type)
	return number;

function	VALIDATE(	i_memberid MEMBER.MEMBERID%type,
			i_password MEMBER.PASSWORD%type)
	return number;
end MEMBERS;
/

create or replace package body MEMBERS
as

function	ADD(	i_registrationno REGISTRATION.REGISTRATIONNO%type,
		i_groupid MEMBERGROUP.GROUPID%type,
		i_auduser MEMBER.AUDUSER%type)
	return number
as
	l_data REGISTRATION%rowtype;
	l_groupid MEMBERGROUP.GROUPID%type;
	l_membershipduration MEMBERGROUP.MEMBERSHIPDURATION%type;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	REGISTRATION
		where	REGISTRATIONNO = i_registrationno
		for	update;

		select	GROUPID, MEMBERSHIPDURATION
		into	l_groupid, l_membershipduration
		from	MEMBERGROUP
		where	GROUPID = upper(i_groupid);

		insert into MEMBER
			(GROUPID, NAME, GENDER, BIRTHDAY, ADDRESS, 
			PHONE, FAX, EMAIL, PASSWORD, PICTURETYPE, PICTURE, 
			ISSUEDDATE, EXPIREDATE, STATUS, AUDUSER, AUDTIME)
		values	(l_groupid, l_data.NAME, l_data.GENDER, l_data.BIRTHDAY, l_data.ADDRESS, 
			l_data.PHONE, l_data.FAX, l_data.EMAIL, l_data.PASSWORD, l_data.PICTURETYPE, l_data.PICTURE,
			sysdate, sysdate+l_membershipduration, 2, upper(i_auduser), sysdate);

		delete
		from	REGISTRATION
		where	REGISTRATIONNO = i_registrationno;

		l_result := 1;
	else	
		l_result := 0;
	end if;

	if (l_result = 1) then
		commit;
	else
		rollback;
	end if;
	
	return (l_result);
exception
	when no_data_found then
		rollback;
		raise_application_error(-20040, 'Dont have information of member or member group ');
	when others then
		rollback;
		raise_application_error(-20999, sqlerrm);
end	ADD;

function	MODIFY(	i_memberid MEMBER.MEMBERID%type,
		i_groupid MEMBER.GROUPID%type := null,
		i_name MEMBER.NAME%type := null,
		i_gender MEMBER.GENDER%type := null,
		i_birthday MEMBER.BIRTHDAY%type := null,
		i_address MEMBER.ADDRESS%type := null,
		i_phone MEMBER.PHONE%type := null,
		i_fax MEMBER.FAX%type := null,
		i_email MEMBER.EMAIL%type := null,
		i_password MEMBER.PASSWORD%type := null,
		i_picturetype MEMBER.PICTURETYPE%type := null,
		i_picture LONG RAW := null,
		i_expiredate MEMBER.EXPIREDATE%type := null,
		i_status MEMBER.STATUS%type := null,
		i_auduser MEMBER.AUDUSER%type)
	return number
as
	l_data MEMBER%rowtype;
	l_result number;
begin
	if ((upper(i_memberid) = upper(i_auduser) and MEMBERS.VALIDATE(i_auduser) = 1) or LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	MEMBER
		where	upper(MEMBERID) = upper(i_memberid)
		for update;

		if (i_groupid is not null) then
			l_data.GROUPID := i_groupid;
		end if;
		if (i_name is not null) then
			l_data.NAME := i_name;
		end if;
		if (i_gender is not null) then
			l_data.GENDER := i_gender;
		end if;
		if (i_birthday is not null) then
			l_data.BIRTHDAY := i_birthday;
		end if;
		if (i_address is not null) then
			l_data.ADDRESS := i_address;
		end if;
		if (i_phone is not null) then
			l_data.PHONE := i_phone;
		end if;
		if (i_fax is not null) then
			l_data.FAX := i_fax;
		end if;
		if (i_email is not null) then
			l_data.EMAIL := i_email;
		end if;
		if (i_password is not null) then
			l_data.PASSWORD := upper(i_password);
		end if;
		if (i_picturetype is not null) then
			l_data.PICTURETYPE := i_picturetype;
		end if;
		if (i_picture is not null) then
			l_data.PICTURE := i_picture;
		end if;
		if (i_expiredate is not null) then
			l_data.EXPIREDATE := i_expiredate;
		end if;
		if (i_status is not null) then
			l_data.STATUS := i_status;
		end if;

		update	MEMBER
		set	GROUPID = l_data.GROUPID,
			NAME = l_data.NAME,
			GENDER = l_data.GENDER,
			BIRTHDAY = l_data.BIRTHDAY,
			ADDRESS = l_data.ADDRESS,
			PHONE = l_data.PHONE,
			FAX = l_data.FAX,
			EMAIL = l_data.EMAIL,
			PASSWORD = l_data.PASSWORD,
			PICTURETYPE = l_data.PICTURETYPE,
			PICTURE = l_data.PICTURE,
			EXPIREDATE = l_data.EXPIREDATE,
			STATUS = l_data.STATUS,
			AUDUSER = upper(i_auduser),
			AUDTIME = sysdate
		where	upper(MEMBERID) = upper(i_memberid);
	
		l_result := 1;
	else
		l_result := 0;
	end if;
	
	return (l_result);
exception
	when no_data_found then
		raise_application_error(-20000, 'Dont have member');
	when others then
		raise_application_error(-20999, sqlerrm);
end	MODIFY;

function	REMOVE(	i_memberid MEMBER.MEMBERID%type,
		i_auduser MEMBER.AUDUSER%type)
	return number
as
	l_status MEMBER.STATUS%type;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	STATUS
		into	l_status
		from	MEMBER
		where	upper(MEMBERID) = upper(i_memberid);

		if (l_status = 0) then
			delete
			from	MEMBER
			where	upper(MEMBERID) = upper(i_memberid);
			
			l_result := 1;
		else
			raise_application_error(-20000, 'Dont delete member is activate');
		end if;		
	else
		l_result := 0;
	end if;
	
	return (l_result);
exception
	when others then
		raise_application_error(-20999, sqlerrm);
end	REMOVE;

function	VALIDATE(	i_memberid MEMBER.MEMBERID%type)
	return number
as
	l_result number;
begin
	select	count(*)
	into	l_result
	from	MEMBER
	where	upper(MEMBERID) = upper(i_memberid)
	and	STATUS > 0;

	return (l_result);
end	VALIDATE;

function	VALIDATE(	i_memberid MEMBER.MEMBERID%type,
			i_password MEMBER.PASSWORD%type)
	return number
as
	l_result number;
begin
	select	count(*)
	into	l_result
	from	MEMBER
	where	upper(MEMBERID) = upper(i_memberid)
	and	upper(PASSWORD) like upper(i_password)
	and	STATUS > 0;

	return (l_result);
end	VALIDATE;

end MEMBERS;
/
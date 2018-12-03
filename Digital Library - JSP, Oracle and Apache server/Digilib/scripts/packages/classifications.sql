create or replace package CLASSIFICATIONS
as

function	ADD(	i_ddcid CLASSIFICATION.DDCID%type,
		i_name CLASSIFICATION.NAME%type,
		i_auduser CLASSIFICATION.AUDUSER%type)
	return	number;

function	MODIFY(	i_ddcid CLASSIFICATION.DDCID%type,
		i_name CLASSIFICATION.NAME%type,
		i_auduser CLASSIFICATION.AUDUSER%type)
	return	number;

function 	REMOVE(	i_ddcid CLASSIFICATION.DDCID%type,
		i_auduser CLASSIFICATION.AUDUSER%type)
	return	number;

end CLASSIFICATIONS;
/

create or replace package body CLASSIFICATIONS
as

function	ADD(	i_ddcid CLASSIFICATION.DDCID%type,
		i_name CLASSIFICATION.NAME%type,
		i_auduser CLASSIFICATION.AUDUSER%type)
	return	number
as
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		insert into CLASSIFICATION
			(DDCID, NAME, AUDUSER, AUDTIME)
		values	(i_ddcid, i_name, upper(i_auduser), sysdate);

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'Error System', true);
end	ADD;

function	MODIFY(	i_ddcid CLASSIFICATION.DDCID%type,
		i_name CLASSIFICATION.NAME%type,
		i_auduser CLASSIFICATION.AUDUSER%type)
	return	number
as
	l_data CLASSIFICATION%rowtype;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	CLASSIFICATION
		where	DDCID = i_ddcid;

		if (i_name is not null) then
			l_data.NAME := i_name;
		end if;

		update	CLASSIFICATION
		set	NAME = l_data.NAME,
			AUDUSER = upper(i_auduser),
			AUDTIME = sysdate
		where	DDCID = i_ddcid;

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when no_data_found then
		raise_application_error(-20543, 'Not Existing this classification', false);
	when others then
		raise_application_error(-20999, 'Error System', true);
end	MODIFY;

function 	REMOVE(	i_ddcid CLASSIFICATION.DDCID%type,
		i_auduser CLASSIFICATION.AUDUSER%type)
	return	number
as
	l_current number;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	count(rownum)
		into	l_current
		from	ITEM_CLASSIFICATION
		where	DDCID = i_ddcid;

		if (l_current > 0) then
			raise_application_error(-20234, 'Have Document used this classification', false);
		end if;

		delete
		from	CLASSIFICATION
		where	DDCID = i_ddcid;

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end	REMOVE;

end CLASSIFICATIONS;
/
create or replace package LANGUAGES
as

function	ADD(	i_languageid LANGUAGE.LANGUAGEID%type,
		i_name LANGUAGE.NAME%type,
		i_auduser LANGUAGE.AUDUSER%type)
	return number;
function	FIND(	i_name LANGUAGE.NAME%type)
	return LANGUAGE.LANGUAGEID%type;

function	MODIFY(	i_languageid LANGUAGE.LANGUAGEID%type,
		i_name LANGUAGE.NAME%type := null,
		i_auduser LANGUAGE.AUDUSER%type)
	return number;

function	REMOVE(	i_languageid LANGUAGE.LANGUAGEID%type,
		i_auduser LANGUAGE.AUDUSER%type)
	return number;

end LANGUAGES;
/

create or replace package body LANGUAGES
as

function	ADD(	i_languageid LANGUAGE.LANGUAGEID%type,
		i_name LANGUAGE.NAME%type,
		i_auduser LANGUAGE.AUDUSER%type)
	return number
as
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		insert into LANGUAGE
			(LANGUAGEID, NAME, AUDUSER, AUDTIME)
		values	(upper(i_languageid), i_name, upper(i_auduser), sysdate);
	
		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
end	ADD;

function	FIND(	i_name LANGUAGE.NAME%type)
	return LANGUAGE.LANGUAGEID%type
as
	l_result LANGUAGE.LANGUAGEID%type;
begin
	select	LANGUAGEID
	into	l_result
	from	LANGUAGE
	where	lower(NAME) like lower(i_name)
	and	rownum = 1;

	return (l_result);
end	FIND;

function	MODIFY(	i_languageid LANGUAGE.LANGUAGEID%type,
		i_name LANGUAGE.NAME%type := null,
		i_auduser LANGUAGE.AUDUSER%type)
	return number
as
	l_data LANGUAGE%rowtype;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	LANGUAGE
		where	upper(LANGUAGEID) = upper(i_languageid);

		if (i_name is not null) then
			l_data.NAME := i_name;
		end if;

		update	LANGUAGE
		set	NAME = l_data.NAME,
			AUDUSER = upper(i_auduser),
			AUDTIME = sysdate
		where	upper(LANGUAGEID) = upper(i_languageid);
		
		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end	MODIFY;

function	REMOVE(	i_languageid LANGUAGE.LANGUAGEID%type,
		i_auduser LANGUAGE.AUDUSER%type)
	return number
as
	l_current number;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	count(rownum)
		into	l_current
		from	ITEM_LANGUAGE
		where	upper(LANGUAGEID) = upper(i_languageid);

		if (l_current > 0) then
			raise_application_error(-20248, 'Have this document with this languages');
		end if;

		delete
		from	LANGUAGE
		where	upper(LANGUAGEID) = upper(i_languageid);
		
		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end	REMOVE;

end LANGUAGES;
/
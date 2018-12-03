create or replace package FORMATS
as

function	ADD(	i_formatid FORMAT.FORMATID%type,
		i_name FORMAT.NAME%type,
		i_auduser FORMAT.AUDUSER%type)
	return number;
function	FIND(	i_name FORMAT.NAME%type)
	return FORMAT.FORMATID%type;

function	MODIFY(	i_formatid FORMAT.FORMATID%type,
		i_name FORMAT.NAME%type := null,
		i_auduser FORMAT.AUDUSER%type)
	return number;

function	REMOVE(	i_formatid FORMAT.FORMATID%type,
		i_auduser FORMAT.AUDUSER%type)
	return number;

end FORMATS;
/

create or replace package body FORMATS
as

function	ADD(	i_formatid FORMAT.FORMATID%type,
		i_name FORMAT.NAME%type,
		i_auduser FORMAT.AUDUSER%type)
	return number
as
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		insert into FORMAT
			(FORMATID, NAME, AUDUSER, AUDTIME)
		values	(upper(i_formatid), i_name, upper(i_auduser), sysdate);
	
		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
end	ADD;

function	FIND(	i_name FORMAT.NAME%type)
	return FORMAT.FORMATID%type
as
	l_result FORMAT.FORMATID%type;
begin
	select	FORMATID
	into	l_result
	from	FORMAT
	where	lower(NAME) like lower(i_name)
	and	rownum = 1;

	return (l_result);
end	FIND;

function	MODIFY(	i_formatid FORMAT.FORMATID%type,
		i_name FORMAT.NAME%type := null,
		i_auduser FORMAT.AUDUSER%type)
	return number
as
	l_data FORMAT%rowtype;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	FORMAT
		where	upper(FORMATID) = upper(i_formatid);

		if (i_name is not null) then
			l_data.NAME := i_name;
		end if;

		update	FORMAT
		set	NAME = l_data.NAME,
			AUDUSER = upper(i_auduser),
			AUDTIME = sysdate
		where	upper(FORMATID) = upper(i_formatid);
		
		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when no_data_found then
		raise_application_error(-20999, 'Dont have existing record', true);
	when others then
		raise_application_error(-20999, 'System Error', true);
end	MODIFY;

function	REMOVE(	i_formatid FORMAT.FORMATID%type,
		i_auduser FORMAT.AUDUSER%type)
	return number
as
	l_current number;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	count(rownum)
		into	l_current
		from	ITEM_FORMAT
		where	upper(FORMATID) = upper(i_formatid);

		if (l_current > 0) then
			raise_application_error(-20549, 'Have document with this format');
		end if;
		
		delete
		from	FORMAT
		where	upper(FORMATID) = upper(i_formatid);

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end	REMOVE;

end FORMATS;
/
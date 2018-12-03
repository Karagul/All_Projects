create or replace package NAMES
as

function	ADD(	i_name NAME.NAME%type,
		i_location NAME.LOCATION%type,
		i_auduser NAME.AUDUSER%type)
	return number;

function	FIND(	i_name NAME.NAME%type)
	return	NAME.NAMEID%type;

end NAMES;
/

create or replace package body NAMES
as

function	ADD(	i_name NAME.NAME%type,
		i_location NAME.LOCATION%type,
		i_auduser NAME.AUDUSER%type)
	return number
as
	l_nameid NAME.NAMEID%type;
	l_current number;
	l_result NAME.NAMEID%type;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	SQ_NAMEID.currval
		into	l_nameid
		from	dual;

		select	count(rownum)
		into	l_current
		from	NAME
		where	NAMEID = l_nameid;

		if (l_current > 0) then
			select	SQ_NAMEID.nextval
			into	l_nameid
			from	dual;
		end if;
	
		insert into NAME
			(NAMEID, NAME, LOCATION, AUDUSER, AUDTIME)
		values	(l_nameid, i_name, i_location, upper(i_auduser), sysdate);

		l_result := l_nameid;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		if (sqlcode = -8002) then
			select	SQ_NAMEID.nextval
			into	l_current
			from	dual;

			return ADD(i_name, i_location, i_auduser);
		else
			raise_application_error(-20999, 'System Error', true);
		end if;
end	ADD;

function	FIND(	i_name NAME.NAME%type)
	return	NAME.NAMEID%type
as
	l_result NAME.NAMEID%type;
begin
	select	NAMEID
	into	l_result
	from	NAME
	where	lower(NAME) like lower(i_name);

	return (l_result);
exception
	when others then
		return (null);
end	FIND;

end NAMES;
/

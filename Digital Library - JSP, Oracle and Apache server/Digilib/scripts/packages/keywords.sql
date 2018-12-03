create or replace package KEYWORDS
as

function	ADD(	i_keyword KEYWORD.KEYWORD%type,
		i_auduser KEYWORD.AUDUSER%type)
	return KEYWORD.KEYWORDID%type;

function	FIND(	i_keyword KEYWORD.KEYWORD%type)
	return KEYWORD.KEYWORDID%type;

end KEYWORDS;
/

create or replace package body KEYWORDS
as

function	ADD(	i_keyword KEYWORD.KEYWORD%type,
		i_auduser KEYWORD.AUDUSER%type)
	return KEYWORD.KEYWORDID%type
as
	l_keywordid number;
	l_current number;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	SQ_KEYWORDID.currval
		into	l_keywordid
		from	dual;
	
		select	count(rownum)
		into	l_current
		from	KEYWORD
		where	KEYWORDID = l_keywordid;

		if (l_current is not null and l_current > 0) then
			select 	SQ_KEYWORDID.nextval
			into	l_keywordid 
			from 	dual;
		end if;

		insert into KEYWORD
			(KEYWORDID, KEYWORD, AUDUSER, AUDTIME)
		values	(l_keywordid, i_keyword, upper(i_auduser), sysdate);

		l_result := l_keywordid;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		if (sqlcode = -8002) then
			select	SQ_KEYWORDID.nextval
			into	l_keywordid 
			from	dual;
			
			return (ADD(i_keyword, i_auduser));
		end if;
		raise_application_error(-20999, 'System Error', true);
end	ADD;

function	FIND(	i_keyword KEYWORD.KEYWORD%type)
	return KEYWORD.KEYWORDID%type
as
	l_result KEYWORD.KEYWORDID%type;
begin
	select	KEYWORDID
	into	l_result
	from	KEYWORD
	where	lower(KEYWORD) like lower(i_keyword)
	and	rownum = 1;

	return (l_result);
exception
	when others then
		return (null);
end	FIND;

end KEYWORDS;
/
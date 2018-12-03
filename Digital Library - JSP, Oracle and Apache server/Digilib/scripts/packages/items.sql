	create or replace package ITEMS
as

function	ADD(	i_primarytitle ITEM.PRIMARYTITLE%type,
		i_primaryauthor ITEM.PRIMARYAUTHOR%type,
		i_auduser ITEM.AUDUSER%type)
	return number;

function	MODIFY(	i_itemno ITEM.ITEMNO%type,
		i_primarytitle ITEM.PRIMARYTITLE%type := null,
		i_primaryauthor ITEM.PRIMARYAUTHOR%type := null,
		i_auduser ITEM.AUDUSER%type)
	return number;

function	REMOVE(	i_itemno ITEM.ITEMNO%type,
		i_auduser ITEM.AUDUSER%type)
	return number;

end ITEMS;
/
create or replace package body ITEMS
as

function	ADD(	i_primarytitle ITEM.PRIMARYTITLE%type,
		i_primaryauthor ITEM.PRIMARYAUTHOR%type,
		i_auduser ITEM.AUDUSER%type)
	return number
as
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		insert into ITEM
			(PRIMARYTITLE, PRIMARYAUTHOR, AUDUSER, AUDTIME)
		values	(i_primarytitle, i_primaryauthor, upper(i_auduser), sysdate);

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, sqlerrm, true);
end	ADD;

function	MODIFY(	i_itemno ITEM.ITEMNO%type,
		i_primarytitle ITEM.PRIMARYTITLE%type := null,
		i_primaryauthor ITEM.PRIMARYAUTHOR%type := null,
		i_auduser ITEM.AUDUSER%type)
	return number
as
	l_data ITEM%rowtype;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	ITEM
		where	ITEMNO = i_itemno
		for update;

		if (i_primarytitle is not null) then
			l_data.PRIMARYTITLE := i_primarytitle;
		end if;
		if (i_primaryauthor is not null) then
			l_data.PRIMARYAUTHOR := i_primaryauthor;
		end if;

		update	ITEM
		set	PRIMARYTITLE = l_data.PRIMARYTITLE,
			PRIMARYAUTHOR = l_data.PRIMARYAUTHOR,
			AUDUSER = upper(i_auduser),
			AUDTIME = sysdate
		where	ITEMNO = i_itemno;

		l_result := 1;
	else	
		l_result := 0;
	end if;

	return (l_result);
exception
	when no_data_found then
		raise_application_error(-20000, 'Dont have documents');
	when others then
		raise_application_error(-20999, sqlerrm, true);
end	MODIFY;

function	REMOVE(	i_itemno ITEM.ITEMNO%type,
		i_auduser ITEM.AUDUSER%type)
	return number
as
	l_copiescount number;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	count(*)
		into	l_copiescount
		from	COPY
		where	ITEMNO = i_itemno;

		if (l_copiescount > 0) then
			raise_application_error(-20050, 'Cant delete document.Other is existing');
		else
			delete
			from	ITEM
			where	ITEMNO = i_itemno;
		end if;

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
end	REMOVE;

end ITEMS;
/
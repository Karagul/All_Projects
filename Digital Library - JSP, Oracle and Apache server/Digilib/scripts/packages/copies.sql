create or replace package COPIES
as

function	ADD(	i_itemno COPY.ITEMNO%type,
		i_copytype COPY.COPYTYPE%type,
		i_location COPY.LOCATION%type,
		i_status COPY.STATUS%type,
		i_auduser COPY.AUDUSER%type)
	return number;

function	MODIFY(	i_itemno COPY.ITEMNO%type,
		i_copyno COPY.COPYNO%type,
		i_copytype COPY.COPYTYPE%type := null,
		i_location COPY.LOCATION%type := null,
		i_status COPY.STATUS%type := null,
		i_auduser COPY.AUDUSER%type)
	return number;

function	REMOVE(	i_itemno COPY.ITEMNO%type,
		i_copyno COPY.COPYNO%type,
		i_auduser COPY.AUDUSER%type)
	return number;

end COPIES;
/

create or replace package body COPIES
as

function	ADD(	i_itemno COPY.ITEMNO%type,
		i_copytype COPY.COPYTYPE%type,
		i_location COPY.LOCATION%type,
		i_status COPY.STATUS%type,
		i_auduser COPY.AUDUSER%type)
	return number
as
	cursor cs_waiting(c_itemno COPY.ITEMNO%type) is
		select	TRANSACTIONNO
		from	WAITINGLIST
		where	ITEMNO = c_itemno
		and	rownum = 1
		order by	PRIORITY desc, TRANSACTIONNO asc;
	l_waiting TRANSACTION.TRANSACTIONNO%type;
	l_copyno COPY.COPYNO%type;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		insert into COPY
			(ITEMNO, COPYTYPE, LOCATION, STATUS, AUDUSER, AUDTIME)
		values	(i_itemno, i_copytype, i_location, i_status, upper(i_auduser), sysdate);

		if (i_status = 1) then
			select	COPYNO
			into	l_copyno
			from	COPY
			where	ITEMNO = i_itemno
			and	STATUS = 1
			and	rownum = 1;

			open cs_waiting(i_itemno);
			fetch cs_waiting into l_waiting;
			if (cs_waiting%found) then
				update	TRANSACTION
				set	COPYNO = l_copyno,
					AUDUSER = upper(i_auduser),
					AUDTIME = sysdate
				where	TRANSACTIONNO = l_waiting;
			end if;
			close cs_waiting;
		end if;
		
		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, sqlerrm, true);
end	ADD;

function	MODIFY(	i_itemno COPY.ITEMNO%type,
		i_copyno COPY.COPYNO%type,
		i_copytype COPY.COPYTYPE%type := null,
		i_location COPY.LOCATION%type := null,
		i_status COPY.STATUS%type := null,
		i_auduser COPY.AUDUSER%type)
	return number
as
	l_data COPY%rowtype;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	COPY
		where	ITEMNO = i_itemno
		and	COPYNO = i_copyno
		for	update;

		if (i_copytype is not null) then
			l_data.COPYTYPE := i_copytype;
		end if;
		if (i_location is not null) then
			l_data.LOCATION := i_location;
		end if;
		if (i_status is not null) then
			l_data.STATUS := i_status;
		end if;

		update	COPY
		set	COPYTYPE = l_data.COPYTYPE,
			LOCATION = l_data.LOCATION,
			STATUS = l_data.STATUS,
			AUDUSER = upper(i_auduser),
			AUDTIME = sysdate
		where	ITEMNO = i_itemno
		and	COPYNO = i_copyno;

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end	MODIFY;

function	REMOVE(	i_itemno COPY.ITEMNO%type,
		i_copyno COPY.COPYNO%type,
		i_auduser COPY.AUDUSER%type)
	return number
as
	l_data COPY%rowtype;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then 
		select	*
		into	l_data
		from	COPY
		where	ITEMNO = i_itemno
		and	COPYNO = i_copyno
		for	update;

		if (l_data.STATUS <> 0) then
			raise_application_error(-20000, 'Cant delete card is activate');
		else
			delete
			from	COPY
			where	ITEMNO = i_itemno
			and	COPYNO = i_copyno;
		end if;

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, 'System Error', true);
end	REMOVE;

end COPIES;
/
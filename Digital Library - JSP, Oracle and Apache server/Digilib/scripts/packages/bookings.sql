create or replace package BOOKINGS
as

function	ADD(	i_memberid BOOKING.MEMBERID%type,
		i_itemno BOOKINGDETAIL.ITEMNO%type,
		i_auduser BOOKING.AUDUSER%type)
	return number;

function	REMOVE(	i_documentno BOOKING.DOCUMENTNO%type,
		i_itemno BOOKINGDETAIL.ITEMNO%type,
		i_auduser BOOKING.AUDUSER%type)
	return number;

function	POST(	i_documentno BOOKING.DOCUMENTNO%type,
		i_auduser BOOKING.AUDUSER%type)
	return number;

end	BOOKINGS;
/
create or replace package body BOOKINGS
as

function	ADD(	i_memberid BOOKING.MEMBERID%type,
		i_itemno BOOKINGDETAIL.ITEMNO%type,
		i_auduser BOOKING.AUDUSER%type)
	return number
as
	l_documentno BOOKING.DOCUMENTNO%type;
	l_detailscount number;
	l_maxbookings MEMBERGROUP.MAXBOOKINGS%type;
	l_result number;
begin
	if ((MEMBERS.VALIDATE(i_auduser) = 1) and upper(i_memberid) = upper(i_auduser)) then
		select	DOCUMENTNO
		into	l_documentno
		from	BOOKING
		where	upper(MEMBERID) = upper(i_memberid)
		and	STATUS = 1;

		select	count(*)
		into	l_detailscount
		from	BOOKINGDETAIL
		where	DOCUMENTNO = l_documentno;

		select	MAXBOOKINGS
		into	l_maxbookings
		from	MEMBERVIEW
		where	MEMBERID = i_memberid;

		if (l_detailscount >= l_maxbookings) then
			raise_application_error(-20050, 'System dont allow you register more than assignment');
		else
			insert into BOOKINGDETAIL
				(DOCUMENTNO, ITEMNO, DETAILDATE, AUDUSER, AUDTIME)
			values	(l_documentno, i_itemno, sysdate, upper(i_auduser), sysdate);
		end if;

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when no_data_found then
		insert into BOOKING
			(MEMBERID, DOCUMENTDATE, STATUS, AUDUSER, AUDTIME)
		values	(upper(i_memberid), sysdate, 1, upper(i_auduser), sysdate);
		return BOOKINGS.ADD(i_memberid, i_itemno, i_auduser);
	when others then
		raise_application_error(-20999, 'System Error', true);
end	ADD;

function	REMOVE(	i_documentno BOOKING.DOCUMENTNO%type,
		i_itemno BOOKINGDETAIL.ITEMNO%type,
		i_auduser BOOKING.AUDUSER%type)
	return number
as
	l_memberid BOOKING.MEMBERID%type;
	l_result number;
begin
	select	MEMBERID
	into	l_memberid
	from	BOOKING
	where	DOCUMENTNO = i_documentno;

	if ((LIBRARIANS.VALIDATE(i_auduser) = 1) or (MEMBERS.VALIDATE(i_auduser) = 1 and upper(i_auduser) = upper(l_memberid))) then
		delete
		from 	BOOKINGDETAIL
		where	DOCUMENTNO = i_documentno
		and	ITEMNO = i_itemno;

		l_result := 1;
	else
		l_result := 0;
	end if;
	return (l_result);
exception
	when no_data_found then
		raise_application_error(-20051, 'Dont have booking card');
	when others then
		raise_application_error(-20999, 'System Error', true);
end 	REMOVE;

function	POST(	i_documentno BOOKING.DOCUMENTNO%type,
		i_auduser BOOKING.AUDUSER%type)
	return number
as
	l_memberid BOOKING.MEMBERID%type;
	l_detailscount number;
	l_currentbookings number;
	l_maxbookings MEMBERGROUP.MAXBOOKINGS%type;
	l_bookingduration MEMBERGROUP.BOOKINGDURATION%type;
	cursor cs_bookings(ci_documentno BOOKING.DOCUMENTNO%type) is
		select	*
		from	BOOKINGDETAIL
		where	DOCUMENTNO = ci_documentno;
	cursor cs_copyno(ci_itemno ITEM.ITEMNO%type) is
		select	*
		from	COPY
		where	ITEMNO = ci_itemno
		and	STATUS = 1
		for update;
	l_curbooking number;
	l_curloan number;
	l_curloanoverdue number;
	l_copyno COPY%rowtype;
	l_result number;
begin
	select	MEMBERID
	into	l_memberid
	from	BOOKING
	where	DOCUMENTNO = i_documentno;

	if ((MEMBERS.VALIDATE(i_auduser) = 1 and upper(i_auduser) = upper(l_memberid)) or (LIBRARIANS.VALIDATE(i_auduser) = 1)) then
		select	count(*)
		into	l_detailscount 
		from	BOOKINGDETAIL
		where	DOCUMENTNO = i_documentno;

		select	count(*)
		into	l_currentbookings
		from	BOOKINGLIST
		where	MEMBERID = l_memberid;

		select	MAXBOOKINGS, BOOKINGDURATION
		into	l_maxbookings, l_bookingduration
		from	MEMBERVIEW
		where	MEMBERID = l_memberid;

		if (l_detailscount + l_currentbookings > l_maxbookings) then
			raise_application_error(-20053, 'Dont allow to register more than allowing quanlity');
		elsif (l_detailscount <= 0) then
			raise_application_error(-20054, 'Booking card is null');
		else
			for cs_booking in cs_bookings(i_documentno) loop
				select	count(rownum)
				into	l_curbooking
				from	BOOKINGLIST
				where	MEMBERID = l_memberid
				and	ITEMNO = cs_booking.ITEMNO;

				select	count(rownum)
				into	l_curloan
				from	LOANLIST
				where	MEMBERID = l_memberid
				and	ITEMNO = cs_booking.ITEMNO;

				select	count(rownum)
				into	l_curloanoverdue
				from	LOANOVERDUELIST
				where	MEMBERID = l_memberid
				and	ITEMNO = cs_booking.ITEMNO;

				if ((l_curbooking + l_curloan + l_curloanoverdue) = 0) then
				
					open cs_copyno(cs_booking.ITEMNO);
					fetch cs_copyno into l_copyno;
					if (cs_copyno%notfound) then
						l_copyno.COPYNO := null;
					else
						update	COPY
						set	STATUS = 2
						where	current of cs_copyno;
					end if;
					insert into TRANSACTION
						(TRANSACTIONTYPE, TRANSACTIONDATE, DUEDATE, MEMBERID, DOCUMENTNO, ITEMNO, COPYNO, STATUS, AUDUSER, AUDTIME)
					values	(0, sysdate, sysdate+l_bookingduration, l_memberid, i_documentno, cs_booking.ITEMNO, l_copyno.COPYNO, 1, upper(i_auduser), sysdate);
					close cs_copyno;
				else
					raise_application_error(-20058, 'Document is borrowed or registered,You cant register it');
				end if;
			end loop;
			update	BOOKING
			set	STATUS = 0,
				POSTEDDATE = sysdate,
				AUDUSER = upper(i_auduser),
				AUDTIME = sysdate
			where	DOCUMENTNO = i_documentno;
		end if;

		l_result := 1;
	else
		l_result := 0;
	end if;
	return (l_result);
exception
	when no_data_found then
		raise_application_error(-20052, 'Dont have booking card');
	when others then
		raise_application_error(-20999, 'System Error', true);
end	POST;

end	BOOKINGS;
/
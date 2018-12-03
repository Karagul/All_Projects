create or replace package MEMBERGROUPS
as

--Add new Membergroup
function	ADD(	i_groupid MEMBERGROUP.GROUPID%type,
		i_name MEMBERGROUP.NAME%type,
		i_priority MEMBERGROUP.PRIORITY%type,
		i_maxbookings MEMBERGROUP.MAXBOOKINGS%type,
		i_maxloans MEMBERGROUP.MAXLOANS%type,
		i_maxexpansions MEMBERGROUP.MAXEXPANSIONS%type,
		i_bookingduration MEMBERGROUP.BOOKINGDURATION%type,
		i_loanduration MEMBERGROUP.LOANDURATION%type,
		i_expansionduration MEMBERGROUP.EXPANSIONDURATION%type,
		i_membershipduration MEMBERGROUP.MEMBERSHIPDURATION%type,
		i_chargerate MEMBERGROUP.CHARGERATE%type,
		i_status MEMBERGROUP.STATUS%type := 1,
		i_auduser MEMBERGROUP.AUDUSER%type)
	return number;

--Modify existing Membergroup
function	MODIFY(	i_groupid MEMBERGROUP.GROUPID%type,
		i_name MEMBERGROUP.NAME%type := null,
		i_priority MEMBERGROUP.PRIORITY%type := null,
		i_maxbookings MEMBERGROUP.MAXBOOKINGS%type := null,
		i_maxloans MEMBERGROUP.MAXLOANS%type := null,
		i_maxexpansions MEMBERGROUP.MAXEXPANSIONS%type := null,
		i_bookingduration MEMBERGROUP.BOOKINGDURATION%type := null,
		i_loanduration MEMBERGROUP.LOANDURATION%type := null,
		i_expansionduration MEMBERGROUP.EXPANSIONDURATION%type := null,
		i_membershipduration MEMBERGROUP.MEMBERSHIPDURATION%type := null,
		i_chargerate MEMBERGROUP.CHARGERATE%type := null,
		i_status MEMBERGROUP.STATUS%type := null,
		i_auduser MEMBERGROUP.AUDUSER%type)
	return number;

--Remove existing Membergroup
function	REMOVE(	i_groupid MEMBERGROUP.GROUPID%type,
		i_auduser MEMBERGROUP.AUDUSER%type)
	return number;
end MEMBERGROUPS;
/

create or replace package body MEMBERGROUPS
as

--Add new Membergroup
function	ADD(	i_groupid MEMBERGROUP.GROUPID%type,
		i_name MEMBERGROUP.NAME%type,
		i_priority MEMBERGROUP.PRIORITY%type,
		i_maxbookings MEMBERGROUP.MAXBOOKINGS%type,
		i_maxloans MEMBERGROUP.MAXLOANS%type,
		i_maxexpansions MEMBERGROUP.MAXEXPANSIONS%type,
		i_bookingduration MEMBERGROUP.BOOKINGDURATION%type,
		i_loanduration MEMBERGROUP.LOANDURATION%type,
		i_expansionduration MEMBERGROUP.EXPANSIONDURATION%type,
		i_membershipduration MEMBERGROUP.MEMBERSHIPDURATION%type,
		i_chargerate MEMBERGROUP.CHARGERATE%type,
		i_status MEMBERGROUP.STATUS%type := 1,
		i_auduser MEMBERGROUP.AUDUSER%type)
	return number
as
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		insert into MEMBERGROUP
			(GROUPID, NAME, PRIORITY, 
			MAXBOOKINGS, MAXLOANS, MAXEXPANSIONS,
			BOOKINGDURATION, LOANDURATION, EXPANSIONDURATION,
			MEMBERSHIPDURATION, CHARGERATE, STATUS,
			AUDUSER, AUDTIME)
		values 	(upper(i_groupid), i_name, i_priority,
			i_maxbookings, i_maxloans, i_maxexpansions,
			i_bookingduration, i_loanduration, i_expansionduration,
			i_membershipduration, i_chargerate, i_status,
			upper(i_auduser), sysdate);
		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when others then
		raise_application_error(-20999, sqlerrm);
end	ADD;

--Modify existing Membergroup
function	MODIFY(	i_groupid MEMBERGROUP.GROUPID%type,
		i_name MEMBERGROUP.NAME%type := null,
		i_priority MEMBERGROUP.PRIORITY%type := null,
		i_maxbookings MEMBERGROUP.MAXBOOKINGS%type := null,
		i_maxloans MEMBERGROUP.MAXLOANS%type := null,
		i_maxexpansions MEMBERGROUP.MAXEXPANSIONS%type := null,
		i_bookingduration MEMBERGROUP.BOOKINGDURATION%type := null,
		i_loanduration MEMBERGROUP.LOANDURATION%type := null,
		i_expansionduration MEMBERGROUP.EXPANSIONDURATION%type := null,
		i_membershipduration MEMBERGROUP.MEMBERSHIPDURATION%type := null,
		i_chargerate MEMBERGROUP.CHARGERATE%type := null,
		i_status MEMBERGROUP.STATUS%type := null,
		i_auduser MEMBERGROUP.AUDUSER%type)
	return number
as
	l_data MEMBERGROUP%rowtype;
	l_membercount number;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	*
		into	l_data
		from	MEMBERGROUP
		where	upper(GROUPID) = upper(i_groupid)
		for update;

		if (i_name is not null) then
			l_data.NAME := i_name;
		end if;		
		if (i_priority is not null) then
			l_data.PRIORITY := i_priority;
		end if;		
		if (i_maxbookings is not null) then
			l_data.MAXBOOKINGS := i_maxbookings;
		end if;		
		if (i_maxloans is not null) then
			l_data.MAXLOANS := i_maxloans;
		end if;		
		if (i_maxexpansions is not null) then
			l_data.MAXEXPANSIONS := i_maxexpansions;
		end if;		
		if (i_bookingduration is not null) then
			l_data.BOOKINGDURATION := i_bookingduration;
		end if;		
		if (i_loanduration is not null) then
			l_data.LOANDURATION := i_loanduration;
		end if;		
		if (i_expansionduration is not null) then
			l_data.EXPANSIONDURATION := i_expansionduration;
		end if;		
		if (i_membershipduration is not null) then
			l_data.MEMBERSHIPDURATION := i_membershipduration;
		end if;		
		if (i_chargerate is not null) then
			l_data.CHARGERATE := i_chargerate;
		end if;		
		if (i_status is not null) then
			if (i_status = 0) then
				select	count(*)
				into 	l_membercount
				from	MEMBER
				where	upper(GROUPID) = upper(i_groupid);
				
				if (l_membercount > 0) then
					raise_application_error(-20031, 'Cant update group while members still have joined');
				end if;
			end if;
			l_data.STATUS := i_status;
		end if;

		update	MEMBERGROUP
		set	NAME = l_data.NAME,
			PRIORITY = l_data.PRIORITY,
			MAXBOOKINGS = l_data.MAXBOOKINGS,
			MAXLOANS = l_data.MAXLOANS,
			MAXEXPANSIONS = l_data.MAXEXPANSIONS,
			BOOKINGDURATION = l_data.BOOKINGDURATION,
			LOANDURATION = l_data.LOANDURATION,
			EXPANSIONDURATION = l_data.EXPANSIONDURATION,
			MEMBERSHIPDURATION = l_data.MEMBERSHIPDURATION,
			CHARGERATE = l_data.CHARGERATE,
			STATUS = l_data.STATUS,
			AUDUSER = upper(i_auduser),
			AUDTIME = sysdate
		where	upper(GROUPID) = upper(i_groupid);

		l_result := 1;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when no_data_found then
		raise_application_error(-20001, 'Dont exist member group');
	when others then
		raise_application_error(-20999, sqlerrm);
end	MODIFY;

--Remove existing Membergroup
function	REMOVE(	i_groupid MEMBERGROUP.GROUPID%type,
		i_auduser MEMBERGROUP.AUDUSER%type)
	return number
as
	l_status number;
	l_result number;
begin
	if (LIBRARIANS.VALIDATE(i_auduser) = 1) then
		select	STATUS
		into	l_status
		from	MEMBERGROUP
		where	upper(GROUPID) = upper(i_groupid);

		if (l_status = 0) then
			delete
			from	MEMBERGROUP
			where	upper(GROUPID) = upper(i_groupid);
			l_result := 1;
		else
			raise_application_error(-20000, 'Cant delete while it is activate');
		end if;
	else
		l_result := 0;
	end if;

	return (l_result);
exception
	when no_data_found then
		raise_application_error(-20001, 'Dont exist member group');
	when others then
		raise_application_error(-20999, sqlerrm);
end	REMOVE;

end MEMBERGROUPS;
/
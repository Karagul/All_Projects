create or replace trigger TG_REGISTRATIONNO
before insert on REGISTRATION
for each row
declare
	l_nextval REGISTRATION.REGISTRATIONNO%type;
	cursor cs_currval(ci_registrationno REGISTRATION.REGISTRATIONNO%type) is
		select	REGISTRATIONNO
		from	REGISTRATION
		where	REGISTRATIONNO = ci_registrationno;
begin
	select	SQ_REGISTRATIONNO.currval
	into	l_nextval
	from	dual;

	open cs_currval(l_nextval);
	fetch cs_currval into l_nextval;

	if cs_currval%found then
		select	SQ_REGISTRATIONNO.nextval
		into	l_nextval
		from	dual;
	else
		select	SQ_REGISTRATIONNO.currval
		into	l_nextval
		from	dual;
	end if;

	close cs_currval;	

	:new.REGISTRATIONNO := l_nextval;		
exception
	when others then
		select	SQ_REGISTRATIONNO.nextval
		into	:new.REGISTRATIONNO
		from	dual;
end;
/
create or replace trigger TG_MEMBERID
before insert on MEMBER
for each row
declare
	l_nextval MEMBER.MEMBERID%type;
	cursor cs_currval(ci_memberid MEMBER.MEMBERID%type) is
		select	MEMBERID
		from	MEMBER
		where	MEMBERID = ci_memberid;
begin
	select	lpad(to_char(SQ_MEMBERID.currval), 12, '0')
	into	l_nextval
	from	dual;

	open cs_currval(l_nextval);
	fetch cs_currval into l_nextval;

	if cs_currval%found then
		select	lpad(to_char(SQ_MEMBERID.nextval), 12, '0')
		into	l_nextval
		from	dual;
	else
		select	lpad(to_char(SQ_MEMBERID.currval), 12, '0')
		into	l_nextval
		from	dual;
	end if;

	close cs_currval;	

	:new.MEMBERID := l_nextval;
exception
	when others then
		select	lpad(to_char(SQ_MEMBERID.nextval), 12, '0')
		into	:new.MEMBERID
		from	dual;
end;
/

create or replace trigger TG_COPYNO
before insert on COPY
for each row
declare
	l_nextval COPY.COPYNO%type;
	cursor cs_currval(ci_itemno COPY.ITEMNO%type) is
		select	max(COPYNO)+1
		from	COPY
		group by	ITEMNO
		having	ITEMNO = ci_itemno;
begin
	open cs_currval(:new.ITEMNO);
	fetch cs_currval into l_nextval;

	if cs_currval%notfound then
		l_nextval := 1;
	end if;

	close cs_currval;	

	:new.COPYNO := l_nextval;
end;
/
create or replace trigger TG_BOOKINGNO
before insert on BOOKING
for each row
declare
	l_nextval BOOKING.DOCUMENTNO%type;
	cursor cs_currval(ci_documentno BOOKING.DOCUMENTNO%type) is
		select	DOCUMENTNO
		from	BOOKING
		where	DOCUMENTNO = ci_documentno;
begin
	select	SQ_BOOKINGNO.currval 
	into	l_nextval
	from	dual;

	open cs_currval(l_nextval);
	fetch cs_currval into l_nextval;

	if cs_currval%found then
		select	SQ_BOOKINGNO.nextval
		into	l_nextval
		from	dual;
	else
		select	SQ_BOOKINGNO.currval
		into	l_nextval
		from	dual;
	end if;

	close cs_currval;

	:new.DOCUMENTNO := l_nextval;
exception
	when others then
		select	SQ_BOOKINGNO.nextval
		into	:new.DOCUMENTNO
		from	dual;
end;
/
create or replace trigger TG_LOANNO
before insert on LOAN
for each row
declare
	l_nextval LOAN.DOCUMENTNO%type;
	cursor cs_currval(ci_documentno LOAN.DOCUMENTNO%type) is
		select	DOCUMENTNO
		from	LOAN
		where	DOCUMENTNO = ci_documentno;
begin
	select	SQ_LOANNO.currval 
	into	l_nextval
	from	dual;

	open cs_currval(l_nextval);
	fetch cs_currval into l_nextval;

	if cs_currval%found then
		select	SQ_LOANNO.nextval
		into	l_nextval
		from	dual;
	else
		select	SQ_LOANNO.currval
		into	l_nextval
		from	dual;
	end if;

	close cs_currval;

	:new.DOCUMENTNO := l_nextval;
exception
	when others then
		select	SQ_LOANNO.nextval
		into	:new.DOCUMENTNO
		from	dual;
end;
/
create or replace trigger TG_EXPANSIONNO
before insert on EXPANSION
for each row
declare
	l_nextval EXPANSION.DOCUMENTNO%type;
	cursor cs_currval(ci_documentno EXPANSION.DOCUMENTNO%type) is
		select	DOCUMENTNO
		from	EXPANSION
		where	DOCUMENTNO = ci_documentno;
begin
	select	SQ_EXPANSIONNO.currval 
	into	l_nextval
	from	dual;

	open cs_currval(l_nextval);
	fetch cs_currval into l_nextval;

	if cs_currval%found then
		select	SQ_EXPANSIONNO.nextval
		into	l_nextval
		from	dual;
	else
		select	SQ_EXPANSIONNO.currval
		into	l_nextval
		from	dual;
	end if;

	close cs_currval;

	:new.DOCUMENTNO := l_nextval;
exception
	when others then
		select	SQ_EXPANSIONNO.nextval
		into	:new.DOCUMENTNO
		from	dual;
end;
/
create or replace trigger TG_RETURNNO
before insert on RETURN
for each row
declare
	l_nextval RETURN.DOCUMENTNO%type;
	cursor cs_currval(ci_documentno RETURN.DOCUMENTNO%type) is
		select	DOCUMENTNO
		from	RETURN
		where	DOCUMENTNO = ci_documentno;
begin
	select	SQ_RETURNNO.currval 
	into	l_nextval
	from	dual;

	open cs_currval(l_nextval);
	fetch cs_currval into l_nextval;

	if cs_currval%found then
		select	SQ_RETURNNO.nextval
		into	l_nextval
		from	dual;
	else
		select	SQ_RETURNNO.currval
		into	l_nextval
		from	dual;
	end if;

	close cs_currval;

	:new.DOCUMENTNO := l_nextval;
exception
	when others then
		select	SQ_RETURNNO.nextval
		into	:new.DOCUMENTNO
		from	dual;
end;
/
create or replace trigger TG_TRANSACTIONNO
before insert on TRANSACTION
for each row
declare
	l_nextval TRANSACTION.TRANSACTIONNO%type;
	cursor cs_currval(ci_transactionno TRANSACTION.DOCUMENTNO%type) is
		select	TRANSACTIONNO
		from	TRANSACTION
		where	TRANSACTIONNO = ci_transactionno;
begin
	select	SQ_TRANSACTIONNO.currval 
	into	l_nextval
	from	dual;

	open cs_currval(l_nextval);
	fetch cs_currval into l_nextval;

	if cs_currval%found then
		select	SQ_TRANSACTIONNO.nextval
		into	l_nextval
		from	dual;
	else
		select	SQ_TRANSACTIONNO.currval
		into	l_nextval
		from	dual;
	end if;

	close cs_currval;

	:new.TRANSACTIONNO := l_nextval;
exception
	when others then
		select	SQ_TRANSACTIONNO.nextval
		into	:new.TRANSACTIONNO
		from	dual;
end;
/
create or replace trigger TG_OTHERTITLE
before insert on OTHERTITLE
for each row
declare
	l_sqnum OTHERTITLE.SEQUENCENO%type;
begin
	select	max(SEQUENCENO) + 1
	into	l_sqnum
	from	OTHERTITLE
	where	ITEMNO = :new.ITEMNO;

	if l_sqnum is null then
		l_sqnum := 1;
	end if;
	
	:new.SEQUENCENO := l_sqnum;
end;
/
create or replace trigger TG_NOTE
before insert on NOTE
for each row
declare
	l_sqnum NOTE.SEQUENCENO%type;
begin
	select	max(SEQUENCENO) + 1
	into	l_sqnum
	from	NOTE
	where	ITEMNO = :new.ITEMNO;

	if l_sqnum is null then
		l_sqnum := 1;
	end if;
	
	:new.SEQUENCENO := l_sqnum;
end;
/
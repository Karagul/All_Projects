
start digilib.sql
start views.sql
start sequences.sql
start triggers.sql
start packages/librarians.sql
start packages/registrations.sql
start packages/membergroups.sql
start packages/members.sql
start packages/classifications.sql
start packages/languages.sql
start packages/formats.sql
start packages/keywords.sql
start packages/names.sql
start packages/items.sql
start packages/copies.sql
start packages/bookings.sql
start packages/loans.sql
start packages/expansions.sql
start packages/returns.sql
start packages/dayend.sql

insert into LIBRARIAN
	(LIBRARIANID, NAME, PASSWORD, STATUS, AUDUSER, AUDTIME)
values	('ADMIN', 'Administrator', 'ADMIN', 1, 'SYSTEM', sysdate)
/

commit
/
drop sequence SQ_REGISTRATIONNO
/
drop sequence SQ_MEMBERID
/
drop sequence SQ_TRANSACTIONNO
/
drop sequence SQ_BOOKINGNO
/
drop sequence SQ_LOANNO
/
drop sequence SQ_EXPANSIONNO
/
drop sequence SQ_RETURNNO
/
drop sequence SQ_ITEMNO
/
drop sequence SQ_KEYWORDID
/
drop sequence SQ_NAMEID
/
create sequence SQ_REGISTRATIONNO
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
cycle
nocache
order
/
create sequence SQ_MEMBERID
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
nocycle
nocache
noorder
/
create sequence SQ_TRANSACTIONNO
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
cycle
nocache
order
/
create sequence SQ_BOOKINGNO
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
cycle
nocache
order
/
create sequence SQ_LOANNO
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
cycle
nocache
order
/
create sequence SQ_EXPANSIONNO
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
cycle
nocache
order
/
create sequence SQ_RETURNNO
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
cycle
nocache
order
/
create sequence SQ_ITEMNO
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
nocycle
nocache
order
/

create sequence SQ_KEYWORDID
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
nocycle
nocache
order
/
create sequence SQ_NAMEID
start with 1
increment by 1
minvalue 1
maxvalue 999999999999
nocycle
nocache
order
/
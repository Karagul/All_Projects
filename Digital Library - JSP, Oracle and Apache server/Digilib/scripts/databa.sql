/*==============================================================*/
/* Database name:  D I G I L I B                                */
/* DBMS name:      ORACLE Version 8i                            */
/* Created on:     1/15/2003 3:53:36 PM                         */
/*==============================================================*/


drop index BOOKINGDETAIL_FK1
/


drop index BOOKINGDETAIL_FK2
/


drop index EXPANSIONDETAIL_FK1
/


drop index EXPANSIONDETAIL_FK2
/


drop index EXPANSION_FK1
/


drop index ITEM_CLASSIFICATION_FK1
/


drop index ITEM_CLASSIFICATION_FK2
/


drop index ITEM_COPY_FK1
/


drop index ITEM_FORMAT_FK1
/


drop index ITEM_FORMAT_FK2
/


drop index ITEM_ITEM_NAME_FK1
/


drop index ITEM_KEYWORD_FK1
/


drop index ITEM_KEYWORD_FK2
/


drop index ITEM_LANGUAGE_FK1
/


drop index ITEM_LANGUAGE_FK2
/


drop index ITEM_NOTE_FK1
/


drop index ITEM_OTHERTITLE_FK1
/


drop index ITEM_RELATIONSHIP_FK1
/


drop index ITEM_RELATIONSHIP_FK2
/


drop index LOANDETAIL_FK1
/


drop index LOANDETAIL_FK2
/


drop index "MEMBER--BOOKING_FK1"
/


drop index "MEMBER--LOAN_FK1"
/


drop index "MEMBER--MEMBERGROUP_FK1"
/


drop index "MEMBER--RETURN_FK1"
/


drop index NAME_ITEM_NAME_FK2
/


drop index RETURNDETAIL_FK1
/


drop index RETURNDETAIL_FK2
/


drop table BOOKINGDETAIL cascade constraints
/


drop table RETURNDETAIL cascade constraints
/


drop table EXPANSIONDETAIL cascade constraints
/


drop table LOANDETAIL cascade constraints
/


drop table BOOKING cascade constraints
/


drop table LOAN cascade constraints
/


drop table EXPANSION cascade constraints
/


drop table RETURN cascade constraints
/


drop table MEMBER cascade constraints
/


drop table ITEM_CLASSIFICATION cascade constraints
/


drop table ITEM_KEYWORD cascade constraints
/


drop table ITEM_FORMAT cascade constraints
/


drop table ITEM_LANGUAGE cascade constraints
/


drop table ITEM_NAME cascade constraints
/


drop table ITEM_RELATIONSHIP cascade constraints
/


drop table LIBRARIAN cascade constraints
/


drop table TRANSACTION cascade constraints
/


drop table REGISTRATION cascade constraints
/


drop table COPY cascade constraints
/


drop table MEMBERGROUP cascade constraints
/


drop table CLASSIFICATION cascade constraints
/


drop table NOTE cascade constraints
/


drop table KEYWORD cascade constraints
/


drop table FORMAT cascade constraints
/


drop table NAME cascade constraints
/


drop table LANGUAGE cascade constraints
/


drop table OTHERTITLE cascade constraints
/


drop table ITEM cascade constraints
/


/*==============================================================*/
/* Table : ITEM                                                 */
/*==============================================================*/
create table ITEM (
   ITEMNO               NUMBER(12)                      not null,
   PRIMARYTITLE         VARCHAR2(200)                   not null,
   EDITION              VARCHAR2(50),
   IMPRINT              VARCHAR2(200),
   PHYSICALDESCRIPTION  VARCHAR2(500),
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_ITEM primary key (ITEMNO)
)
/


/*==============================================================*/
/* Table : OTHERTITLE                                           */
/*==============================================================*/
create table OTHERTITLE (
   ITEMNO               NUMBER(12)                      not null,
   SEQUENCENO           NUMBER(2)                       not null,
   OTHERTITLE           VARCHAR2(200)                   not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_OTHERTITLE primary key (ITEMNO, SEQUENCENO),
   constraint FK_OTHERTIT_ITEM_OTHE_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO)
)
/


/*==============================================================*/
/* Table : LANGUAGE                                             */
/*==============================================================*/
create table LANGUAGE (
   LANGUAGEID           CHAR(6)                         not null,
   NAME                 VARCHAR2(100)                   not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_LANGUAGE primary key (LANGUAGEID)
)
/


/*==============================================================*/
/* Table : NAME                                                 */
/*==============================================================*/
create table NAME (
   NAMEID               NUMBER(12)                      not null,
   NAME                 VARCHAR2(100)                   not null,
   LOCATION             VARCHAR2(200),
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_NAME primary key (NAMEID)
)
/


/*==============================================================*/
/* Table : FORMAT                                               */
/*==============================================================*/
create table FORMAT (
   FORMATID             CHAR(6)                         not null,
   NAME                 VARCHAR2(100)                   not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_FORMAT primary key (FORMATID)
)
/


/*==============================================================*/
/* Table : KEYWORD                                              */
/*==============================================================*/
create table KEYWORD (
   KEYWORDID            NUMBER(12)                      not null,
   KEYWORD              VARCHAR2(100)                   not null,
   AUDTIME              DATE,
   AUDUSER              CHAR(12),
   constraint PK_KEYWORD primary key (KEYWORDID)
)
/


/*==============================================================*/
/* Table : NOTE                                                 */
/*==============================================================*/
create table NOTE (
   ITEMNO               NUMBER(12)                      not null,
   SEQUENCENO           NUMBER(2)                       not null,
   NOTE                 VARCHAR2(255)                   not null,
   AUDTIME              DATE,
   AUDUSER              CHAR(12),
   constraint PK_NOTE primary key (ITEMNO, SEQUENCENO),
   constraint FK_NOTE_ITEM_NOTE_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO)
)
/


/*==============================================================*/
/* Table : CLASSIFICATION                                       */
/*==============================================================*/
create table CLASSIFICATION (
   DDCID                CHAR(20)                        not null,
   NAME                 VARCHAR2(100)                   not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_CLASSIFICATION primary key (DDCID)
)
/


/*==============================================================*/
/* Table : MEMBERGROUP                                          */
/*==============================================================*/
create table MEMBERGROUP (
   GROUPID              CHAR(12)                        not null,
   NAME                 VARCHAR2(200)                   not null,
   PRIORITY             NUMBER(1)                       not null,
   MAXBOOKINGS          NUMBER(2)                       not null,
   MAXLOANS             NUMBER(2)                       not null,
   MAXEXPANSIONS        NUMBER(2)                       not null,
   BOOKINGDURATION      NUMBER(3)                       not null,
   LOANDURATION         NUMBER(3)                       not null,
   EXPANSIONDURATION    NUMBER(3)                       not null,
   MEMBERSHIPDURATION   NUMBER(3)                       not null,
   CHARGERATE           NUMBER(6)                       not null,
   STATUS               NUMBER(1)                       not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_MEMBERGROUP primary key (GROUPID)
)
/


/*==============================================================*/
/* Table : COPY                                                 */
/*==============================================================*/
create table COPY (
   ITEMNO               NUMBER(12)                      not null,
   COPYNO               NUMBER(2)                       not null,
   COPYTYPE             NUMBER(1)                       not null,
   LOCATION             VARCHAR2(200)                   not null,
   STATUS               NUMBER(1)                       not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_COPY primary key (ITEMNO, COPYNO),
   constraint FK_COPY_ITEM_COPY_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO)
)
/


/*==============================================================*/
/* Table : REGISTRATION                                         */
/*==============================================================*/

create table REGISTRATION (
   REGISTRATIONNO       NUMBER(12)                      not null,
   NAME                 VARCHAR2(200)                   not null,
   GENDER               NUMBER(1)                       not null,
   BIRTHDAY             DATE                            not null,
   ADDRESS              VARCHAR2(200)                   not null,
   PHONE                VARCHAR2(50),
   FAX                  VARCHAR2(50),
   EMAIL                VARCHAR2(100)                   not null,
   PASSWORD             VARCHAR2(50)                    not null,
   PICTURETYPE          VARCHAR2(50),
   PICTURE              BLOB,
   constraint PK_REGISTRATION primary key (REGISTRATIONNO)
)
/


/*==============================================================*/
/* Table : TRANSACTION                                          */
/*==============================================================*/
create table TRANSACTION (
   TRANSACTIONNO        NUMBER(12)                      not null,
   TRANSACTIONTYPE      NUMBER(1)                       not null,
   TRANSACTIONDATE      DATE                            not null,
   DUEDATE              DATE,
   DOCUMENTNO           NUMBER(12)                      not null,
   MEMBERID             CHAR(12)                        not null,
   ITEMNO               NUMBER(12)                      not null,
   COPYNO               NUMBER(2),
   REFERENCENO          NUMBER(12),
   STATUS               NUMBER(1)                       not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_TRANSACTION primary key (TRANSACTIONNO)
)
/


/*==============================================================*/
/* Table : LIBRARIAN                                            */
/*==============================================================*/
create table LIBRARIAN (
   LIBRARIANID          CHAR(12)                        not null,
   NAME                 VARCHAR2(200)                   not null,
   PASSWORD             VARCHAR2(50)                    not null,
   STATUS               NUMBER(1)                       not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_LIBRARIAN primary key (LIBRARIANID)
)
/


/*==============================================================*/
/* Table : ITEM_RELATIONSHIP                                    */
/*==============================================================*/
create table ITEM_RELATIONSHIP (
   ITE_ITEMNO           NUMBER(12)                      not null,
   ITEMNO               NUMBER(12)                      not null,
   NAME                 VARCHAR2(100)                   not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_ITEM_RELATIONSHIP primary key (ITE_ITEMNO, ITEMNO),
   constraint FK_ITEM_REL_ITEM_RELA_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO),
   constraint FK_ITEM_REL_ITEM_RELA_ITEM foreign key (ITE_ITEMNO)
         references ITEM (ITEMNO)
)
/


/*==============================================================*/
/* Table : ITEM_NAME                                            */
/*==============================================================*/
create table ITEM_NAME (
   NAMEID               NUMBER(12)                      not null,
   ITEMNO               NUMBER(12)                      not null,
   TAG                  CHAR(10)                        not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_ITEM_NAME primary key (NAMEID, ITEMNO, TAG),
   constraint FK_ITEM_NAM_ITEM_ITEM_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO),
   constraint FK_ITEM_NAM_NAME_ITEM_NAME foreign key (NAMEID)
         references NAME (NAMEID)
)
/


/*==============================================================*/
/* Table : ITEM_LANGUAGE                                        */
/*==============================================================*/
create table ITEM_LANGUAGE (
   LANGUAGEID           CHAR(6)                         not null,
   ITEMNO               NUMBER(12)                      not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_ITEM_LANGUAGE primary key (LANGUAGEID, ITEMNO),
   constraint FK_ITEM_LAN_ITEM_LANG_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO),
   constraint FK_ITEM_LAN_ITEM_LANG_LANGUAGE foreign key (LANGUAGEID)
         references LANGUAGE (LANGUAGEID)
)
/


/*==============================================================*/
/* Table : ITEM_FORMAT                                          */
/*==============================================================*/
create table ITEM_FORMAT (
   FORMATID             CHAR(6)                         not null,
   ITEMNO               NUMBER(12)                      not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_ITEM_FORMAT primary key (FORMATID, ITEMNO),
   constraint FK_ITEM_FOR_ITEM_FORM_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO),
   constraint FK_ITEM_FOR_ITEM_FORM_FORMAT foreign key (FORMATID)
         references FORMAT (FORMATID)
)
/


/*==============================================================*/
/* Table : ITEM_KEYWORD                                         */
/*==============================================================*/
create table ITEM_KEYWORD (
   KEYWORDID            NUMBER(12)                      not null,
   ITEMNO               NUMBER(12)                      not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_ITEM_KEYWORD primary key (KEYWORDID, ITEMNO),
   constraint FK_ITEM_KEY_ITEM_KEYW_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO),
   constraint FK_ITEM_KEY_ITEM_KEYW_KEYWORD foreign key (KEYWORDID)
         references KEYWORD (KEYWORDID)
)
/


/*==============================================================*/
/* Table : ITEM_CLASSIFICATION                                  */
/*==============================================================*/
create table ITEM_CLASSIFICATION (
   DDCID                CHAR(20)                        not null,
   ITEMNO               NUMBER(12)                      not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_ITEM_CLASSIFICATION primary key (DDCID, ITEMNO),
   constraint FK_ITEM_CLA_ITEM_CLAS_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO),
   constraint FK_ITEM_CLA_ITEM_CLAS_CLASSIFI foreign key (DDCID)
         references CLASSIFICATION (DDCID)
)
/


/*==============================================================*/
/* Table : MEMBER                                               */
/*==============================================================*/
create table MEMBER (
   MEMBERID             CHAR(12)                        not null,
   GROUPID              CHAR(12)                        not null,
   NAME                 VARCHAR2(200)                   not null,
   GENDER               NUMBER(1)                       not null,
   BIRTHDAY             DATE                            not null,
   ADDRESS              VARCHAR2(200)                   not null,
   PHONE                VARCHAR2(50),
   FAX                  VARCHAR2(50),
   EMAIL                VARCHAR2(100)                   not null,
   PASSWORD             VARCHAR2(50)                    not null,
   PICTURETYPE          VARCHAR2(50),
   PICTURE              BLOB,
   ISSUEDDATE           DATE                            not null,
   EXPIREDATE           DATE                            not null,
   STATUS               NUMBER(1)                       not null,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_MEMBER primary key (MEMBERID),
   constraint "FK_MEMBER_MEMBER--M_MEMBERGR" foreign key (GROUPID)
         references MEMBERGROUP (GROUPID)
)
/


/*==============================================================*/
/* Table : RETURN                                               */
/*==============================================================*/
create table RETURN (
   DOCUMENTNO           NUMBER(12)                      not null,
   MEMBERID             CHAR(12)                        not null,
   DOCUMENTDATE         DATE                            not null,
   STATUS               NUMBER(1)                       not null,
   POSTEDDATE           DATE,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_RETURN primary key (DOCUMENTNO),
   constraint "FK_RETURN_MEMBER--R_MEMBER" foreign key (MEMBERID)
         references MEMBER (MEMBERID)
)
/


/*==============================================================*/
/* Table : EXPANSION                                            */
/*==============================================================*/
create table EXPANSION (
   DOCUMENTNO           NUMBER(12)                      not null,
   MEMBERID             CHAR(12)                        not null,
   DOCUMENTDATE         DATE                            not null,
   STATUS               NUMBER(1)                       not null,
   POSTEDDATE           DATE,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_EXPANSION primary key (DOCUMENTNO),
   constraint FK_EXPANSIO_EXPANSION_MEMBER foreign key (MEMBERID)
         references MEMBER (MEMBERID)
)
/


/*==============================================================*/
/* Table : LOAN                                                 */
/*==============================================================*/
create table LOAN (
   DOCUMENTNO           NUMBER(12)                      not null,
   MEMBERID             CHAR(12)                        not null,
   DOCUMENTDATE         DATE                            not null,
   STATUS               NUMBER(1)                       not null,
   POSTEDDATE           DATE,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_LOAN primary key (DOCUMENTNO),
   constraint "FK_LOAN_MEMBER--L_MEMBER" foreign key (MEMBERID)
         references MEMBER (MEMBERID)
)
/


/*==============================================================*/
/* Table : BOOKING                                              */
/*==============================================================*/
create table BOOKING (
   DOCUMENTNO           NUMBER(12)                      not null,
   MEMBERID             CHAR(12)                        not null,
   DOCUMENTDATE         DATE                            not null,
   STATUS               NUMBER(1)                       not null,
   POSTEDDATE           DATE,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_BOOKING primary key (DOCUMENTNO),
   constraint "FK_BOOKING_MEMBER--B_MEMBER" foreign key (MEMBERID)
         references MEMBER (MEMBERID)
)
/


/*==============================================================*/
/* Table : LOANDETAIL                                           */
/*==============================================================*/
create table LOANDETAIL (
   DOCUMENTNO           NUMBER(12)                      not null,
   ITEMNO               NUMBER(12)                      not null,
   COPYNO               NUMBER(2)                       not null,
   DETAILDATE           DATE,
   REFERENCENO          NUMBER(12),
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_LOANDETAIL primary key (DOCUMENTNO, ITEMNO, COPYNO),
   constraint FK_LOANDETA_LOANDETAI_COPY foreign key (ITEMNO, COPYNO)
         references COPY (ITEMNO, COPYNO),
   constraint FK_LOANDETA_LOANDETAI_LOAN foreign key (DOCUMENTNO)
         references LOAN (DOCUMENTNO)
)
/


/*==============================================================*/
/* Table : EXPANSIONDETAIL                                      */
/*==============================================================*/
create table EXPANSIONDETAIL (
   DOCUMENTNO           NUMBER(12)                      not null,
   ITEMNO               NUMBER(12)                      not null,
   COPYNO               NUMBER(2)                       not null,
   DETAILDATE           DATE,
   REFERENCENO          NUMBER(12),
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_EXPANSIONDETAIL primary key (DOCUMENTNO, ITEMNO, COPYNO),
   constraint FK_EXPANSIO_EXPANSION_COPY foreign key (ITEMNO, COPYNO)
         references COPY (ITEMNO, COPYNO),
   constraint FK_EXPANSIO_EXPANSION_EXPANSIO foreign key (DOCUMENTNO)
         references EXPANSION (DOCUMENTNO)
)
/


/*==============================================================*/
/* Table : RETURNDETAIL                                         */
/*==============================================================*/
create table RETURNDETAIL (
   DOCUMENTNO           NUMBER(12)                      not null,
   ITEMNO               NUMBER(12)                      not null,
   COPYNO               NUMBER(2)                       not null,
   DETAILDATE           DATE,
   REFERENCENO          NUMBER(12),
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_RETURNDETAIL primary key (DOCUMENTNO, ITEMNO, COPYNO),
   constraint FK_RETURNDE_RETURNDET_COPY foreign key (ITEMNO, COPYNO)
         references COPY (ITEMNO, COPYNO),
   constraint FK_RETURNDE_RETURNDET_RETURN foreign key (DOCUMENTNO)
         references RETURN (DOCUMENTNO)
)
/


/*==============================================================*/
/* Table : BOOKINGDETAIL                                        */
/*==============================================================*/
create table BOOKINGDETAIL (
   ITEMNO               NUMBER(12)                      not null,
   DOCUMENTNO           NUMBER(12)                      not null,
   DETAILDATE           DATE,
   AUDUSER              CHAR(12),
   AUDTIME              DATE,
   constraint PK_BOOKINGDETAIL primary key (ITEMNO, DOCUMENTNO),
   constraint FK_BOOKINGD_BOOKINGDE_BOOKING foreign key (DOCUMENTNO)
         references BOOKING (DOCUMENTNO),
   constraint FK_BOOKINGD_BOOKINGDE_ITEM foreign key (ITEMNO)
         references ITEM (ITEMNO)
)
/


/*==============================================================*/
/* Index: BOOKINGDETAIL_FK1                                     */
/*==============================================================*/
create  index BOOKINGDETAIL_FK1 on BOOKINGDETAIL (
   DOCUMENTNO ASC
)
/


/*==============================================================*/
/* Index: BOOKINGDETAIL_FK2                                     */
/*==============================================================*/
create  index BOOKINGDETAIL_FK2 on BOOKINGDETAIL (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: EXPANSIONDETAIL_FK1                                   */
/*==============================================================*/
create  index EXPANSIONDETAIL_FK1 on EXPANSIONDETAIL (
   ITEMNO ASC,
   COPYNO ASC
)
/


/*==============================================================*/
/* Index: EXPANSIONDETAIL_FK2                                   */
/*==============================================================*/
create  index EXPANSIONDETAIL_FK2 on EXPANSIONDETAIL (
   DOCUMENTNO ASC
)
/


/*==============================================================*/
/* Index: EXPANSION_FK1                                         */
/*==============================================================*/
create  index EXPANSION_FK1 on EXPANSION (
   MEMBERID ASC
)
/


/*==============================================================*/
/* Index: ITEM_CLASSIFICATION_FK1                               */
/*==============================================================*/
create  index ITEM_CLASSIFICATION_FK1 on ITEM_CLASSIFICATION (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: ITEM_CLASSIFICATION_FK2                               */
/*==============================================================*/
create  index ITEM_CLASSIFICATION_FK2 on ITEM_CLASSIFICATION (
   DDCID ASC
)
/


/*==============================================================*/
/* Index: ITEM_COPY_FK1                                         */
/*==============================================================*/
create  index ITEM_COPY_FK1 on COPY (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: ITEM_FORMAT_FK1                                       */
/*==============================================================*/
create  index ITEM_FORMAT_FK1 on ITEM_FORMAT (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: ITEM_FORMAT_FK2                                       */
/*==============================================================*/
create  index ITEM_FORMAT_FK2 on ITEM_FORMAT (
   FORMATID ASC
)
/


/*==============================================================*/
/* Index: ITEM_ITEM_NAME_FK1                                    */
/*==============================================================*/
create  index ITEM_ITEM_NAME_FK1 on ITEM_NAME (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: ITEM_KEYWORD_FK1                                      */
/*==============================================================*/
create  index ITEM_KEYWORD_FK1 on ITEM_KEYWORD (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: ITEM_KEYWORD_FK2                                      */
/*==============================================================*/
create  index ITEM_KEYWORD_FK2 on ITEM_KEYWORD (
   KEYWORDID ASC
)
/


/*==============================================================*/
/* Index: ITEM_LANGUAGE_FK1                                     */
/*==============================================================*/
create  index ITEM_LANGUAGE_FK1 on ITEM_LANGUAGE (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: ITEM_LANGUAGE_FK2                                     */
/*==============================================================*/
create  index ITEM_LANGUAGE_FK2 on ITEM_LANGUAGE (
   LANGUAGEID ASC
)
/


/*==============================================================*/
/* Index: ITEM_NOTE_FK1                                         */
/*==============================================================*/
create  index ITEM_NOTE_FK1 on NOTE (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: ITEM_OTHERTITLE_FK1                                   */
/*==============================================================*/
create  index ITEM_OTHERTITLE_FK1 on OTHERTITLE (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: ITEM_RELATIONSHIP_FK1                                 */
/*==============================================================*/
create unique index ITEM_RELATIONSHIP_FK1 on ITEM_RELATIONSHIP (
   ITEMNO ASC
)
/


/*==============================================================*/
/* Index: ITEM_RELATIONSHIP_FK2                                 */
/*==============================================================*/
create unique index ITEM_RELATIONSHIP_FK2 on ITEM_RELATIONSHIP (
   ITE_ITEMNO ASC
)
/


/*==============================================================*/
/* Index: LOANDETAIL_FK1                                        */
/*==============================================================*/
create  index LOANDETAIL_FK1 on LOANDETAIL (
   ITEMNO ASC,
   COPYNO ASC
)
/


/*==============================================================*/
/* Index: LOANDETAIL_FK2                                        */
/*==============================================================*/
create  index LOANDETAIL_FK2 on LOANDETAIL (
   DOCUMENTNO ASC
)
/


/*==============================================================*/
/* Index: "MEMBER--BOOKING_FK1"                                 */
/*==============================================================*/
create  index "MEMBER--BOOKING_FK1" on BOOKING (
   MEMBERID ASC
)
/


/*==============================================================*/
/* Index: "MEMBER--LOAN_FK1"                                    */
/*==============================================================*/
create  index "MEMBER--LOAN_FK1" on LOAN (
   MEMBERID ASC
)
/


/*==============================================================*/
/* Index: "MEMBER--MEMBERGROUP_FK1"                             */
/*==============================================================*/
create  index "MEMBER--MEMBERGROUP_FK1" on MEMBER (
   GROUPID ASC
)
/


/*==============================================================*/
/* Index: "MEMBER--RETURN_FK1"                                  */
/*==============================================================*/
create  index "MEMBER--RETURN_FK1" on RETURN (
   MEMBERID ASC
)
/


/*==============================================================*/
/* Index: NAME_ITEM_NAME_FK2                                    */
/*==============================================================*/
create  index NAME_ITEM_NAME_FK2 on ITEM_NAME (
   NAMEID ASC
)
/


/*==============================================================*/
/* Index: RETURNDETAIL_FK1                                      */
/*==============================================================*/
create  index RETURNDETAIL_FK1 on RETURNDETAIL (
   ITEMNO ASC,
   COPYNO ASC
)
/


/*==============================================================*/
/* Index: RETURNDETAIL_FK2                                      */
/*==============================================================*/
create  index RETURNDETAIL_FK2 on RETURNDETAIL (
   DOCUMENTNO ASC
)
/



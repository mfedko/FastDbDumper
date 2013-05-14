create sequence USER_ID_SEQ AS INTEGER start with 1 increment by 1 ;

create table USER (
  id int primary key,
  name character varying (16),
  parent_id int,
  constraint USER_PARENT_FK foreign key (parent_id) references USER(id)
);

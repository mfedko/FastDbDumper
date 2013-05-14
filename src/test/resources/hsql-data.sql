call NEXT VALUE FOR USER_ID_SEQ;
insert into USER (id, name, parent_id) values (1, 'Mike', null);
insert into USER (id, name, parent_id) values (NEXT VALUE FOR USER_ID_SEQ, 'Muti', 1);
insert into USER (id, name, parent_id) values (NEXT VALUE FOR USER_ID_SEQ, 'Marta', 1);

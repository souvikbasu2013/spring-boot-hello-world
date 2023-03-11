insert into sys_app_user (ID,USER_NAME,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,ROLE,SSN) 
values(101,'Souvik Basu','Souvik','Basu','bunty.nil@gmail.com','Admin','ssn001');
insert into sys_app_user (ID,USER_NAME,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,ROLE,SSN) 
values(102,'Peter Hobs','Peter','Hobs','pt.hb@gmail.com','Approver','ssn002');
insert into sys_app_user (ID,USER_NAME,FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,ROLE,SSN) 
values(103,'Tom Brooks','Tom','Brooks','tm.br@gmail.com','Requisitioner','ssn003');

insert into sys_order values(2001,'Order-2001',101);
insert into sys_order values(2002,'Order-2002',101);
insert into sys_order values(2003,'Order-2003',102);
insert into sys_order values(2004,'Order-2004',102);
insert into sys_order values(2005,'Order-2005',103);

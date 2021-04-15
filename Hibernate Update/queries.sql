Begin
   execute immediate 'Drop table "user"';
EXCEPTION
   WHEN OTHERS THEN NULL;
END;
/
create table "user"(
   userid NUMBER(10) NOT NULL,
   authenticate NUMBER(10) NOT NULL ,
   username VARCHAR2(20) default NULL,
   password VARCHAR2(20) default NULL,
   name VARCHAR2(20) default NULL,
   email VARCHAR2(20) default NULL,
   PRIMARY KEY (userid)
);

-- Generate ID using sequence and trigger
drop sequence user_seq;
create sequence user_seq start with 1 increment by 1;

create or replace trigger user_seq_tr
 before insert on "user" for each row
 when (new.userid is null)
begin
 select user_seq.nextval into :new.userid from dual;
end;
/

insert into "user"(userid,authenticate,username,password,name,email)
values(1,1,'Zara', 'Ali','ZaraAli','zara123@gmail.com');

insert into "user"(userid,authenticate,username,password,name,email)
values(2,2,'Daisy', 'Das','DaisyDas','daisy456@gmail.com');

insert into "user"(userid,authenticate,username,password,name,email)
values(3,3,'John', 'Paul','JohnPaul','john789@gmail.com' );

insert into "user"(userid,authenticate,username,password,name,email)
values(4,4,'Thara', 'Varthan','TharaVarthan','thara123@gmail.com');

insert into "user"(userid,authenticate,username,password,name,email)
values(5,5,'Shan', 'Mathi','ShanMathi','shan456@gmail.com');

insert into "user"(userid,authenticate,username,password,name,email)
values(6,6,'Haveena', 'Havi','HaveenaHavi','havi789@gmail.com' );

begin
   execute immediate 'drop table "user"';
exception
   when others then null;
end;
/
begin
   execute immediate 'drop table address';
exception
   when others then null;
end;
/
create table address(
id number(10) primary key,
line1 varchar2(255),
line2 varchar2(255),
city varchar2(255),
pincode number(10));


create table "user"(
id number(10) primary key,
name varchar2(255),
phoneNumber number(19),
password varchar2(255),
addressId number(10) unique not null,
foreign key(addressId) references address(id));


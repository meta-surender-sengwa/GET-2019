create database sms;
use sms;

create table student(
first_name varchar(20),
last_name varchar(20),
father_name varchar(25),
email varchar(30),
class varchar(2),
age varchar(2),
primary key(first_name, last_name));

desc student;

select * from student;
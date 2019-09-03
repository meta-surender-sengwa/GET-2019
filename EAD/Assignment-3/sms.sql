create database sms;
use sms;

create table student(
id int(11) auto_increment,
first_name varchar(45),
last_name varchar(45),
father_name varchar(45),
email varchar(45),
class int(11),
age int(11),
primary key(id);

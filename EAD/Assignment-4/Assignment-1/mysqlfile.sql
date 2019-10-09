create database mps;

use mps;

drop table employee;
create table employee 
(
    emp_id int auto_increment,
    emp_name varchar(30) not null,
    emp_gender varchar(6) not null,
    emp_email varchar(30) not null,
    emp_password varchar(30) not null,
    emp_contact varchar(10) not null,
    emp_department varchar(30),
    primary key(emp_id)
);

create table vehicle
(
    vehicle_name varchar(30) not null,
    vehicle_type varchar(30) not null,
    vehicle_number varchar(10),
    employee_id int not null,
    vehicle_identification varchar(50),
    primary key(vehicle_number),
    foreign key(employee_id) references employee(emp_id)
);

select * from employee;

select * from vehicle;

















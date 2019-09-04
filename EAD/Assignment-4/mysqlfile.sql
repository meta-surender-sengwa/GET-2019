create database mps;

use mps;

create table employee 
(
    emp_id int auto_increment,
    emp_name varchar(30),
    emp_gender varchar(6),
    emp_email varchar(30),
    emp_password varchar(30),
    emp_contact varchar(10),
    emp_department varchar(30),
    primary key(emp_id)
);

create table vehicle
(
    vehicle_name varchar(30),
    vehicle_type varchar(30),
    vehicle_number varchar(10),
    employee_id int,
    vehicle_identification varchar(50),
    primary key(vehicle_number),
    foreign key(employee_id) references employee(emp_id)
);

insert into 
employee(emp_name, emp_gender, emp_email, emp_password, emp_contact, emp_department) 
values("Surender Sengwa", "male", "surender.sengwa@metacube.com", "surender123", "9999999999", "testing");

select * from employee;

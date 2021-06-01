create database IF NOT EXISTS centermanager;
use centermanager;

create table teacher(
                        id int primary key auto_increment,
                        name nvarchar(200) ,
                        email varchar(200) ,
                        phone varchar(200) ,
                        dateOfBirth date,
                        identity varchar(20),
                        address varchar(200)
);


create table class(
                      id int primary key auto_increment,
                      name nvarchar(200) not null

);


create table student(
                        id int primary key auto_increment,
                        name nvarchar(200) not null ,
                        email varchar(200) not null ,
                        phone varchar(200) ,
                        dateOfBirth date,
                        identity varchar(20),
                        address varchar(200),
                        status varchar(20)
);


create table role (
                      id int primary key auto_increment,
                      name varchar(100)
);
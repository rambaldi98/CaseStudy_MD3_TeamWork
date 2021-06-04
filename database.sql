create database manager_teaching_center;
use manager_teaching_center;

create table student(
                        id int not null auto_increment primary key ,
                        name varchar(100) ,
                        email varchar(100) unique ,
                        identify varchar(100),
                        dateOfBirth date,
                        address varchar(100),
                        phoneNumber varchar(11),
                        id_class int,
                        status nvarchar(250),
                        foreign key (id_class) references class(id)
);


create table teacher(
                        id int not null auto_increment primary key ,
                        name varchar(100),
                        dateOfBirth date,
                        address varchar(100),
                        phoneNumber varchar(11),
                        description varchar(250),
                        email varchar(100) unique
);

create table class(
                      id int not null auto_increment primary key ,
                      name varchar(100) unique
);


create table subject (
                         id int not null auto_increment primary key ,
                         name varchar(100) unique
);

create  table point (
                        id_subject int ,
                        id_teacher int,
                        id_student int,
                        point int,
                        foreign key (id_subject) references subject(id),
                        foreign key (id_teacher) references teacher(id),
                        foreign key (id_student) references student(id)
);

create table diary_class(
                            id_class int,
                            id_teacher int,
                            date date,
                            diary text,
                            foreign key (id_class ) references class(id),
                            foreign key (id_teacher) references teacher(id)
);

create table diary_student(
                              id_student int,
                              id_teacher int,
                              date date,
                              diary text,
                              foreign key (id_student) references student(id),
                              foreign key (id_teacher) references teacher(id)
);
create table role(
                     id int not null auto_increment primary key ,
                     name varchar(100)
);

create table admin(
                      username varchar(100) not null primary key ,
                      password varchar(100) not null
);

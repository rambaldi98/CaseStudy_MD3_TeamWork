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
                        status varchar(200),
                        class_id int not null ,
                        foreign key class_id (class_id) references class(id)
);


create table diary_class(
    class_id int not null ,
    teacher_id int not null ,
    date date ,
    diary text,
    foreign key class_id (class_id) references class(id),
    foreign key teacher_id (teacher_id) references teacher(id)
);
create table diary_student(
                            student_id int not null ,
                            teacher_id int not null ,
                            date date ,
                            diary text,
                            foreign key student_id (student_id) references student(id),
                            foreign key teacher_id (teacher_id) references teacher(id)
);

create table subject(
    id int primary key auto_increment,
    name nvarchar(200) not null
);

create table point (
    subject_id int ,
    teacher_id int,
    student_id int,
    point float
);

create table role (
                      id int primary key auto_increment,
                      name varchar(100)
);

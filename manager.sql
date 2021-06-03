create database IF NOT EXISTS centermanager;
use centermanager;

create table role(
    id int primary key auto_increment,
    name nvarchar(200) not null
);
create table gender(
    id int primary key auto_increment,
    name nvarchar(200) not null
);

create table user(
    id int primary key auto_increment,
    name nvarchar(200),
    email nvarchar(200),
    password nvarchar(200),
    phone nvarchar(200),
    dateofbirth date,
    address nvarchar(200),
    gender_id int,
    role_id int ,
    foreign key role (role_id) references role(id) on delete cascade on update cascade,
    foreign key gender (gender_id) references gender(id) on delete cascade on update cascade
);

create table class
(
    id   int primary key auto_increment,
    name nvarchar(200) not null

);


create table class_student (
    id int primary key auto_increment,
    student_id int ,
    class_id int ,
    foreign key student (student_id) references user(id),
    foreign key class (class_id) references class(id)
);

create table diary_class(
    id int primary key auto_increment,
    class_id int ,
    teacher_id int,
    date date,
    diary text,
    foreign key class (class_id) references class(id),
    foreign key teacher (teacher_id) references user(id)
);

create table diary_student(
                              id int primary key auto_increment,
    student_id int,
    teacher_id int,
    date date,
    diary text,
    foreign key student (student_id) references class_student(id),
    foreign key teacher (teacher_id) references user(id)
);
drop table diary_student;

create table status(
    id int primary key auto_increment,
    status nvarchar(200)
);

create table status_student(
    id int primary key auto_increment,
    student_id int,
    status_id int,
    foreign key student (student_id) references user(id),
    foreign key status (student_id) references status(id)
);

create table subject(
    id int primary key auto_increment,
    name nvarchar(200)
);

create table point(
    id int primary key auto_increment,
    minister_id int,
    student_id int,
    subject_id int,
    point float,
    foreign key student (student_id) references user(id),
    foreign key minister (minister_id) references user(id),
    foreign key subject (subject_id) references subject(id)
);

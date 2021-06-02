create database IF NOT EXISTS centermanager;
use centermanager;

create table teacher
(
    id    int primary key auto_increment,
    name  nvarchar(200),
    email varchar(200)

);


create table class
(
    id   int primary key auto_increment,
    name nvarchar(200) not null

);

create table status(
    id int auto_increment primary key ,
    name nvarchar(200) not null
);

create table student
(
    id          int primary key auto_increment,
    name        nvarchar(200) not null,
    email       varchar(200)  not null,
    phone       varchar(200),
    dateOfBirth date,
    identity    varchar(20),
    address     varchar(200),
    status_id    int ,
    class_id    int           not null,
    foreign key class_id (class_id) references class (id) on delete cascade on update cascade,
    foreign key status (status_id) references status(id) on delete cascade on update cascade
);


create table diary_class
(
    class_id   int not null,
    teacher_id int not null,
    date       date,
    diary      text,
    foreign key class_id (class_id) references class (id) on delete cascade on update cascade,
    foreign key teacher_id (teacher_id) references teacher (id)on delete cascade on update cascade
);
create table diary_student
(
    student_id int not null,
    teacher_id int not null,
    date       date,
    diary      text,
    foreign key student_id (student_id) references student (id)on delete cascade on update cascade,
    foreign key teacher_id (teacher_id) references teacher (id) on delete cascade on update cascade
);

create table subject(
    id int primary key auto_increment,
    name nvarchar(200) not null
);



create table minister
(
    id    int primary key auto_increment,
    name  nvarchar(200),
    email varchar(200)
);

create table point
(
    subject_id  int,
    minister_id int,
    student_id  int,
    point       float,
    foreign key subject (subject_id) references subject (id) on delete cascade on update cascade,
    foreign key minister (minister_id) references minister (id) on delete cascade on update cascade,
    foreign key student (subject_id) references student (id) on delete cascade on update cascade
);

create table role
(
    id   int primary key auto_increment,
    name varchar(100)
);

create table login(
    user nvarchar(200),
    password nvarchar(200),
    role_id int ,
    foreign key role (role_id) references role(id)
);
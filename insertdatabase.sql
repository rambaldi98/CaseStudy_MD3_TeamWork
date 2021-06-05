use manager_teaching_center;

insert into role(name) value
    ('ADMIN'),
    ('TEACHER'),
    ('MINISTER'),
    ('STUDENT');




insert user (name,email,password,phone,dateofbirth,address,
                    gender_id,role_id) value ('haiii','adad','123456','11qsq','2000-10-10','asa',1,3);


# tim kiem user theo id
select * ,g.name as gender_name, r.name as role_name from user
join gender g on g.id = user.gender_id
join role r on r.id = user.role_id
where user.id = 2;


# sua thong tin theo id
update user set name = 'Duy Hair', email = 'duyhai@gmail.com', password = '123456',
            phone = '033664455', dateofbirth = '1997-07-07', address = 'Thanh Hoa', gender_id = 1, role_id = 4 where id = 8;



#tim kiem user theo id;
select * ,g.name as gender_name, r.name as role_name from user
            join gender g on g.id = user.gender_id
            join role r on r.id = user.role_id
            where user.id = 5;


# xoaa theo id
delete from  user where id = 9;


#theem moi 1 mon hoc
insert into subject (name) value ('Toan');



#them cac lop hoc
insert into class(name) values
('12A1'),('12A2'),('12A3');


#them cac user la student
INSERT INTO user (NAME, EMAIL, PASSWORD, PHONE, DATEOFBIRTH, ADDRESS, GENDER_ID, ROLE_ID) VALUES
('hung','hung@gmail.com','123456','0999999907','2000-10-10','Ha Noi',1,4),
('Trung','trung@gmail.com','123456','0999999901','2000-10-10','Ha Noi',1,4),
('Son','son@gmail.com','123456','0999999902','2000-10-10','Ha Noi',1,4),
('Truong','truon@gmail.com','123456','099999991','2000-10-10','Ha Noi',1,4),
('Dung','dung@gmail.com','123456','099999992','2000-10-10','Ha Noi',1,4);




#them lop cho cac hoc sinh
insert into class_student(student_id, class_id) values
(11,1),(12,1),(13,1), (14,2),(15,2);


#them 1 giao vien moi vao bang user;
insert into user(name, email, password, phone, dateofbirth, address, gender_id, role_id) value
    ('Kiều Anh', 'kieuanh@gmail.com','123456','033929292','1993-10-10','Hà Nam',2,2);



#them moi cac ban ghi trong bang diary_class;
#phan id cua giao vieen phải lấy đúng nên lưu ý nhé
insert into diary_class(class_id, teacher_id) VALUES
(1,4),(2,4),(3,4);


#them mới các bản ghi vào bảng diary_student;
#lưu ý student_id là khóa ngoại của bảng student_class
#teacher_id là id_user
insert into diary_student(student_id, teacher_id) VALUES
(1,4),(2,4),(3,4),(4,4),(5,4);

create table diary_student(
                              id int primary key auto_increment,
                              student_id int,
                              teacher_id int,
                              date date,
                              diary text,
                              foreign key student (student_id) references user (id),
                              foreign key teacher (teacher_id) references user (id)
);





#xem ten va lop ma gv quan ly
select c.name as class_name, c.id as id_class,u.name as user_name from diary_class
join class c on c.id = diary_class.class_id
join user u on u.id = diary_class.teacher_id;



select c.name,u.name from class_student
join class c on c.id = class_student.class_id
join user u on u.id = class_student.student_id where class_id = 1;


#viet nhat ki cho lop
insert into diary_class (class_id, teacher_id, date, diary) value
(1,4,now(),  'day la demo nhat ki');


# xem thong tin hoc sinh theo id
select * ,g.name as gender_name, r.name as role_name from user
  join gender g on g.id = user.gender_id
 join role r on r.id = user.role_id
where role_id = 4 and user.id = 12;

# viet nhat ki cho hoc sinh
insert into diary_student (student_id, teacher_id, date, diary) VALUE
(1,4,now(),'nhat ki cho em hihihi');

select c.name as class_name,c.id as id_class ,u.name as user_name from diary_class
            join class c on c.id = diary_class.class_id
            join user u on u.id = diary_class.teacher_id
where teacher_id =4;
# group by c.id ;

INSERT INTO manager_teaching_center.user (name, email, password, phone, dateofbirth, address, gender_id, role_id) VALUES
 ('Quân', 'quan@gmail.com', '123456', '0999999996', '1999-06-10', 'Ha Noi', 1, 2);

INSERT INTO manager_teaching_center.subject (id, name) VALUES (3, 'Van');

INSERT INTO manager_teaching_center.subject (id, name) VALUES (4, 'Vat li');

INSERT INTO manager_teaching_center.subject (id, name) VALUES (5, 'Hoa hoc');

INSERT INTO manager_teaching_center.point (minister_id, student_id, subject_id, point) VALUES (6, 11, 1, 9.5);

INSERT INTO manager_teaching_center.point (minister_id, student_id, subject_id, point) VALUES (6, 11, 2, 9);

INSERT INTO manager_teaching_center.point (minister_id, student_id, subject_id, point) VALUES (6, 11, 3, 6);

INSERT INTO manager_teaching_center.point (minister_id, student_id, subject_id, point) VALUES (6, 11, 4, 8);

INSERT INTO manager_teaching_center.point (minister_id, student_id, subject_id, point) VALUES (6, 12, 1, 9);

INSERT INTO manager_teaching_center.point (minister_id, student_id, subject_id, point) VALUES (6, 12, 2, 8);

INSERT INTO manager_teaching_center.point (minister_id, student_id, subject_id, point) VALUES (6, 12, 3, 8);

select s.name,point from point
join subject s on s.id = point.subject_id
where student_id = 11;

INSERT INTO manager_teaching_center.status (status) VALUES ('STUDYING');

 INSERT INTO manager_teaching_center.status (status) VALUES ('WAITING');

 INSERT INTO manager_teaching_center.status (status) VALUES ('STOP_STUDYING');

INSERT INTO manager_teaching_center.status (status) VALUES ('SUSPEND');

alter table status_student
add foreign key (status_id) references status(id);

select  name, status from status_student
join status s on s.id = status_student.status_id
join user u on u.id = status_student.student_id
where u.id = 11;

INSERT INTO manager_teaching_center.status_student (student_id, status_id) VALUES (11, 1);

INSERT INTO manager_teaching_center.status_student (student_id, status_id) VALUES (12, 1);

 INSERT INTO manager_teaching_center.status_student (student_id, status_id) VALUES (13, 2);

INSERT INTO manager_teaching_center.status_student (student_id, status_id) VALUES (14, 3);

select u.id , u.name as user_name,u.email,u.address,g.name as gender, status  from status_student
join user u on u.id = status_student.student_id
join gender g on g.id = u.gender_id
join status s on s.id = status_student.status_id
where u.name = 'hung' or email = 'son@gmail.com';

update status_student
set status_id = 3
where student_id = 12;






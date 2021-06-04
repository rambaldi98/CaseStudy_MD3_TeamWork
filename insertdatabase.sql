use manager_teaching_center;

insert into role(name) value
    ('admin'),
    ('minister'),
    ('teacher'),
    ('student');


insert user (name,email,password,phone,dateofbirth,address,
                    gender_id,role_id) value ('haiii','adad','123456','11qsq','2000-10-10','asa',1,3);

#  querry find user check user login
select u.name as name, u.email as email, u.password as password, u.phone as phone , u.dateofbirth as dateofbirth,u.address as address , r.name as role, g.name as gender from user u join gender g on u.gender_id = g.id join role r on u.role_id = r.id where email = 'asdd' and password = '123';

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
use centermanager;

insert into role(name) value
    ('admin'),
    ('minister'),
    ('teacher'),
    ('student');

select user, password,r.name from login join role r on r.id = login.role_id where r.name = 'student';
select user, password,r.name from login join role r on r.id = login.role_id ;
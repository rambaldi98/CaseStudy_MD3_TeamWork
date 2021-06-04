package service.adminjdbc;


import model.subject.Subject;

import model.user.Gender;
import model.user.Role;
import model.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IAdminService {

    List<User> findAll();

    User findById(int id);

    void create(User user, HttpServletRequest request);

    void delete(int id);

    void update(int id, User user, HttpServletRequest request);

    List<Gender> selectAllGender();

    List<Role> selectAllRole();

    Role findRoleById(int id);

    Gender findGenderById(int id);


    void createNewSubject(Subject subject);




}

package service.adminjdbc;

import model.user.User;

import java.util.List;

public interface IAdminService {

    List<User> findAll();

    User findById(int id);

    void create(User user);

    void delete(int id);

    void update(int id, User user);

}

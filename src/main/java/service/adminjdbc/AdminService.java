package service.adminjdbc;

import model.user.Gender;
import model.user.Role;
import model.user.User;
import service.ConnectJDBC;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminService implements IAdminService{

    public static final String SELECT_ALL_USER = "select * , r.name as role_name,g.name as gender_name from user\n" +
            "join role r on r.id = user.role_id\n" +
            "join gender g on g.id = user.gender_id";

    Connection connection = ConnectJDBC.getConnection();
    @Override
    public List<User> findAll() {

        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                int id = set.getInt("id");
                String user_name = set.getString("name");
                String email = set.getString("email");
                String password = set.getString("password");
                String phone = set.getString("phone");
                Date dateOfBirth = set.getDate("dateOfBirth");
                String address = set.getString("address");
                String gender_name = set.getString("gender_name");
                String role_name = set.getString("role_name");
                Gender gender = Gender.valueOf(gender_name);
                Role role = Role.valueOf(role_name);
                User user = new User(id,user_name,email,password,phone,dateOfBirth,address);

                user.setGender(gender);
                user.setRole(role);
                userList.add(user);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, User user) {

    }
}

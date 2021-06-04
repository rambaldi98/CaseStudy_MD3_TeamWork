package service.loginjdbc;

import model.user.Gender;
import model.user.Role;
import model.user.User;
import service.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LoginAccount {

    public static final String SELECT_CHECK_USER_ROLE = "select email,password,r.name as role_name from user join role r on r.id = user.role_id where email = ? and password =?";
    public static final String SELECT_CHECK_USER_LOGIN = "select u.name as name, u.email as email, u.password as password, u.phone as phone , u.dateofbirth as dateofbirth,u.address as address , r.name as role, g.name as gender from user u join gender g on u.gender_id = g.id join role r on u.role_id = r.id where email = ? and password = ?;";
    Connection connection = ConnectJDBC.getConnection();


    public User checkUser(String username, String password){

        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CHECK_USER_LOGIN);
            statement.setString(1,username);
            statement.setString(2,password);

            ResultSet set = statement.executeQuery();

            if (set.next()){

                String user_name = set.getString("name");
                String email = set.getString("email");
                String password1 = set.getString("password");
                String phone = set.getString("phone");
                Date dateOfBirth = set.getDate("dateOfBirth");
                String address = set.getString("address");
                String gender_name = set.getString("gender");
                String role_name = set.getString("role");
                Gender gender = Gender.valueOf(gender_name);
                Role role = Role.valueOf(role_name);
                 user = new User(user_name,email,password1,phone,dateOfBirth,address,gender,role);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
     return user;
    }



    public String checkLogin(String username ,String password){
        String role = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT_CHECK_USER_ROLE);
            statement.setString(1,username);
            statement.setString(2,password);

            ResultSet set = statement.executeQuery();

            if (set.next()){
                String role_name = set.getString("role_name");
                if (role_name.equals("ADMIN")) role = "ADMIN";
                else if (role_name.equals("TEACHER")) role = "TEACHER";
                else if (role_name.equals("MINISTER")) role = "MINISTER";
                else if (role_name.equals("STUDENT")) role = "STUDENT";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    return role;
    }


}

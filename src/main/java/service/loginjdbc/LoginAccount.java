package service.loginjdbc;

import model.user.Role;
import service.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAccount {

    Connection connection = ConnectJDBC.getConnection();

    public boolean checkLogin1(String username, String password){

        boolean isValid = false;

        try {
            PreparedStatement statement = connection.prepareStatement("select * from user where email = ? and password = ?");
            statement.setString(1,username);
            statement.setString(2,password);

            ResultSet set = statement.executeQuery();

            if (set.next()){
                isValid = true;

            }
            else isValid = false;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
     return isValid;
    }



    public String checkLogin(String username ,String password){
        String role = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select email,password,r.name as role_name from user\n" +
                    "join role r on r.id = user.role_id where email = ? and password =?");
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

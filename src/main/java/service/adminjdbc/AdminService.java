package service.adminjdbc;

import model.subject.Subject;
import model.user.Gender;
import model.user.Role;
import model.user.User;
import service.ConnectJDBC;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminService implements IAdminService{

    public static final String SELECT_ALL_USER = "select * , r.name as role_name,g.name as gender_name from user\n" +
            "join role r on r.id = user.role_id\n" +
            "join gender g on g.id = user.gender_id";
    public static final String SELECT_USER_BY_ID = "select * ,g.name as gender_name, r.name as role_name from user\n" +
            "join gender g on g.id = user.gender_id\n" +
            "join role r on r.id = user.role_id\n" +
            "where user.id = ?";
    public static final String UPDATE_USER_BY_ID = "update user set name = ?, email = ?, password = ?, " +
            "phone = ?, dateofbirth = ?, address = ?, gender_id = ?, role_id = ? where id = ?";
    public static final String INSERT_USER = "insert user (name,email,password,phone,dateofbirth,address," +
            "gender_id,role_id) value (?,?,?,?,?,?,?,?)";
    public static final String DELETE_USER_BY_ID = "delete from  user where id = ?";
    public static final String INSERT_NEW_SUBJECT = "insert into subject (name ) value (?)";

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
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID);
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
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
                System.out.println(statement);
                user = new User(user_name,email,password,phone,dateOfBirth,address,gender,role);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }


    public static String converDate(Date date){
        DateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        return   newdate.format(date);

    }

    @Override
    public void create(User user, HttpServletRequest request) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getPhone());
            statement.setString(5, converDate( user.getDateOfBirth()));
            statement.setString(6,user.getAddress());
            statement.setString(7, request.getParameter("gender_id"));
            statement.setString(8, request.getParameter("role_id"));
            System.out.println(statement);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void delete(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID);
            statement.setInt(1,id);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(int id, User user, HttpServletRequest request) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_BY_ID);
            statement.setInt(9,id);
            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getPhone());
            statement.setString(5,converDate(user.getDateOfBirth()));
            statement.setString(6,user.getAddress());
            statement.setString(7, request.getParameter("gender_id"));
            statement.setString(8, request.getParameter("role_id"));
            System.out.println(statement);
            statement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public List<Gender> selectAllGender(){
        List<Gender> genderList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from gender");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name_gender = set.getString("name");
                Gender gender = Gender.valueOf(name_gender);
                genderList.add(gender);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genderList;
    }


    @Override
    public List<Role> selectAllRole(){
        List<Role> roleList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from role");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name_role = set.getString("name");
//                Role role = new Role(id,name_role);
                Role role = Role.valueOf(name_role);
                roleList.add(role);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Gender findGenderById(int id) {
        Gender gender = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from gender " +
                    "where id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String gender_name = set.getString("name");
                gender = Gender.valueOf(gender_name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return gender;
    }


    @Override
    public Role findRoleById(int id) {
        Role role = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from role where id = ?");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String name_role = set.getString("name");
                role = Role.valueOf(name_role);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return role;
    }


    @Override
    public void createNewSubject(Subject subject) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_NEW_SUBJECT);
            statement.setString(1,subject.getName());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


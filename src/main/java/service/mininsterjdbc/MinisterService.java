package service.mininsterjdbc;

import model.student.Status;
import model.student.Student;
import model.user.Gender;
import model.user.User;
import service.ConnectJDBC;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MinisterService implements IMinisterService{

    Connection connection = ConnectJDBC.getConnection();

    @Override
    public Student searchStudent(String name) {
        Student student = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select u.id ,  u.name as user_name,u.email,u.address,g.name as gender, status  from status_student\n" +
                    "join user u on u.id = status_student.student_id\n" +
                    "join gender g on g.id = u.gender_id\n" +
                    "join status s on s.id = status_student.status_id\n" +
                    "where u.name = ? ");

            statement.setString(1,name);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                int id = set.getInt("u.id");
                String email = set.getString("u.email");
                String address = set.getString("u.address");
                String gender = set.getString("gender");
                String status = set.getString("status");
                Gender gender1 = Gender.valueOf(gender);
                Status status1 = Status.valueOf(status);

                User user = new User(id,name,email,address,gender1);
                student = new Student(user,status1);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return student;
    }


    @Override
    public Status findStatusById(int id) {
        Status status1 = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select * from status where id = ?");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
             String status =    set.getString("status");
             status1 = Status.valueOf(status);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        return null;
    }

    @Override
    public void changeStatus(int id, Status status, HttpServletRequest request  ) {
        try {
            PreparedStatement statement = connection.prepareStatement("update status_student set status_id = ?\n" +
                    "where student_id = ?");
            statement.setString(1,request.getParameter("status_id"));
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

package service.mininsterjdbc;

import model.point.Point;
import model.student.Status;
import model.student.Student;
import model.subject.Subject;
import model.user.Gender;
import model.user.User;
import service.ConnectJDBC;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public List<Student> findAllStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select *,status from user\n" +
                    "join status_student ss on user.id = ss.student_id\n" +
                    "join status s on s.id = ss.status_id\n" +
                    "where role_id = 4");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String email = set.getString("email");
                String phone = set.getString("phone");
                String address = set.getString("address");
                String status = set.getString("status");
                User user = new User(id,name,email,phone,address);
                Status status1 = Status.valueOf(status);
                Student student = new Student(user,status1);
                studentList.add(student);


            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return studentList;
    }

    public List<Point> viewAllPoint(int id) {
        List<Point> pointList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select s.id  ,s.name as subject_name,point from point\n" +
                    "join subject s on s.id = point.subject_id\n" +
                    "where student_id = ?");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int sub_id = set.getInt("s.id");
                String name_subject = set.getString("subject_name");
                float point = set.getFloat("point");
                Subject subject = new Subject( sub_id,name_subject);
                Point point1 = new Point(subject,point);
                pointList.add(point1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pointList;
    }

    @Override
    public Point viewPointByIdSubject(int id) {
        Point point = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from point where subject_id = ? ");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                float points = set.getFloat("point");
                point = new Point(points);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return point;
    }

    @Override
    public void updatePointById(int id, Point point) {
        try {
            PreparedStatement statement = connection.prepareStatement("update point set point = ? where subject_id = ?");
            statement.setInt(2,id);
            statement.setFloat(1,point.getPoint());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

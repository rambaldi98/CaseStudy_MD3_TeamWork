package service.studentjdbc;

import model.point.Point;
import model.student.Status;
import model.student.Student;
import model.subject.Subject;
import model.user.User;
import service.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{

    public static final String SELECT_STATUS_BY_ID_STUDENT = "select  name, status from status_student\n" +
            "join status s on s.id = status_student.status_id\n" +
            "join user u on u.id = status_student.student_id\n" +
            "where u.id = ? ";
    Connection connection = ConnectJDBC.getConnection();

    @Override
    public List<Point> viewAllPoint(int id) {
        List<Point> pointList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select s.name as subject_name,point from point\n" +
                    "join subject s on s.id = point.subject_id\n" +
                    "where student_id = ?");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String name_subject = set.getString("subject_name");
                float point = set.getFloat("point");
                  Subject subject = new Subject(name_subject);
                Point point1 = new Point(subject,point);
                pointList.add(point1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pointList;
    }

    @Override
    public Student viewStatus(int id) {
        Student student = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_STATUS_BY_ID_STUDENT);
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){

                String status = set.getString("status");
                Status status1 = Status.valueOf(status);
                student = new Student(status1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return student;
    }
}

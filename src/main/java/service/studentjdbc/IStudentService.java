package service.studentjdbc;

import model.point.Point;
import model.student.Status;
import model.student.Student;

import java.util.List;

public interface IStudentService {

    List<Point> viewAllPoint(int id);

    Student viewStatus(int id);
}

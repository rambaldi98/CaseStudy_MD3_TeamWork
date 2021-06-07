package service.mininsterjdbc;

import model.point.Point;
import model.student.Status;
import model.student.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMinisterService {

    Student searchStudent(String name);

    Status findStatusById(int id);

    void changeStatus(int id, Status status,  HttpServletRequest request);

    List<Student> findAllStudent();

    List<Point> viewAllPoint(int id);

    Point viewPointByIdSubject(int id);

    void updatePointById(int id, Point point);



}

package service.mininsterjdbc;

import model.student.Status;
import model.student.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IMinisterService {

    Student searchStudent(String name);

    Status findStatusById(int id);

    void changeStatus(int id, Status status,  HttpServletRequest request);



}

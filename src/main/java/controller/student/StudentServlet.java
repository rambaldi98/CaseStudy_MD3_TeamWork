package controller.student;

import controller.login.LoginServlet;
import model.point.Point;
import model.student.Student;
import service.studentjdbc.IStudentService;
import service.studentjdbc.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "viewPoint":
                showPoint(request,response);
                break;
            case "viewStatus":
                showStatus(request,response);
                break;

        }
    }

    private void showStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = this.studentService.viewStatus(LoginServlet.user.getId());
        request.setAttribute("user",LoginServlet.user);
        request.setAttribute("student",student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/viewStatus.jsp");
        dispatcher.forward(request,response);
    }

    private void showPoint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Point> pointList = this.studentService.viewAllPoint(LoginServlet.user.getId());
        request.setAttribute("pointList",pointList);
        request.setAttribute("user",LoginServlet.user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/viewPoint.jsp");
        dispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

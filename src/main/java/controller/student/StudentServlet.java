package controller.student;

import controller.login.LoginServlet;
import model.point.Point;
import model.student.Student;
import model.user.User;
import service.studentjdbc.IStudentService;
import service.studentjdbc.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    IStudentService studentService = new StudentService();
    private static User user = LoginServlet.user;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Cookie[] cookie = req.getCookies();
        Cookie a = null;
        boolean check = false;
        for ( Cookie c : cookie) {
            if(c.getValue().equals(user.getName())){
                a = c;
                check = true;
            }
        }
        if(check){
            req.setAttribute("user",user);
            doGet(req,res);
            doPost(req,res);
        }
        else {
            res.sendRedirect("/login");
        }
    }
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

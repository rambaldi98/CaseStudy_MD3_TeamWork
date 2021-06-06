package controller.minister;

import controller.login.LoginServlet;
import model.student.Status;
import model.student.Student;
import model.user.User;
import service.mininsterjdbc.IMinisterService;
import service.mininsterjdbc.MinisterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MinisterServlet", urlPatterns = "/minister")
public class MinisterServlet extends HttpServlet {

    IMinisterService ministerService = new MinisterService();
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
            case "searchStudent":
                showFormSearch(request,response);
                break;
            case "changeStatus":
                showFormChangeStatus(request,response);
                break;
        }
    }

    private void showFormChangeStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("minister/changeStatus.jsp");
        dispatcher.forward(request,response);

    }

    private void showFormSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("minister/searchStudent.jsp");
        dispatcher.forward(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action){
            case "searchStudent":
                searchStudent(request,response);
                break;
            case "changeStatus":
                changeStatus(request,response);
                break;

        }
    }

    private void changeStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_status = Integer.parseInt(request.getParameter("status_id"));
        Status status = this.ministerService.findStatusById(id_status);

        this.ministerService.changeStatus(id,status, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("minister/changeStatus.jsp");
        request.setAttribute("notification", "thay doi thanh cong");
        dispatcher.forward(request,response);
    }


    private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Student student = this.ministerService.searchStudent(name);
        RequestDispatcher dispatcher ;
        System.out.println(student);
        if (student != null){
            dispatcher = request.getRequestDispatcher("minister/viewStudent.jsp");
            request.setAttribute("student",student);
        }
        else {
          dispatcher =  request.getRequestDispatcher("minister/searchStudent.jsp");
            request.setAttribute("notification","khong tim thay, thu lai");
        }
        dispatcher.forward(request,response);


    }
}

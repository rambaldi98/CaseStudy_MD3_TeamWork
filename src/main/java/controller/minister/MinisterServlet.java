package controller.minister;

import model.student.Status;
import model.student.Student;
import model.user.User;
import service.mininsterjdbc.IMinisterService;
import service.mininsterjdbc.MinisterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MinisterServlet", urlPatterns = "/minister")
public class MinisterServlet extends HttpServlet {

    IMinisterService ministerService = new MinisterService();

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
        RequestDispatcher dispatcher = null;
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

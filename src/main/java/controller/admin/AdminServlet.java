package controller.admin;

import model.user.User;
import service.adminjdbc.AdminService;
import service.adminjdbc.IAdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    IAdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action){
            case "listUser":
                showListUser(request,response);
                break;


            case "createUser":
                showFormCreateUSer(request,response);
                break;
        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = adminService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/listUser.jsp");
        request.setAttribute("userList",userList);
        dispatcher.forward(request,response);

    }

    private void showFormCreateUSer(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

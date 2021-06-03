package controller.login;

import service.loginjdbc.LoginAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.HashMap;
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    LoginAccount loginAccount = new LoginAccount();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       String action = request.getParameter("action");
//       if (action == null) action = "";
//       switch (action){
//           case "loginAccount":
//               showFormLogin(request,response);
//               break;
//       }
        showFormLogin(request,response);
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login/loginAccount.jsp");
        dispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        switch (action){
//            case "loginAccount":
                loginAccount(request,response);
//                break;
//        }
    }

    private void loginAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher;
        String role = loginAccount.checkLogin(username,password);
        boolean isValid = loginAccount.checkLogin1(username,password);
        if (isValid) {
            if (role.equals("ADMIN")) {
                dispatcher = request.getRequestDispatcher("admin/indexAdmin.jsp");
                dispatcher.forward(request, response);
            } else if (role.equals("TEACHER")) {
                dispatcher = request.getRequestDispatcher("teacher/indexTeacher.jsp");
                dispatcher.forward(request, response);
            } else if (role.equals("MINISTER")) {
                dispatcher = request.getRequestDispatcher("minister/indexMinister.jsp");
                dispatcher.forward(request, response);
            } else if (role.equals("STUDENT")) {
                dispatcher = request.getRequestDispatcher("student/indexStudent.jsp");
                dispatcher.forward(request, response);
            }
        }

         else {
            dispatcher = request.getRequestDispatcher("login/loginAccount.jsp");
            request.setAttribute("notification", "sai thong tin tai khoan hoac mat khau");
            dispatcher.forward(request, response);
        }

        }



    }


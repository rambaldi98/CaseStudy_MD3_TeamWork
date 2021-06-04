package controller.login;

import model.user.Role;
import model.user.User;
import service.loginjdbc.LoginAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    public static final String LOGIN_LOGIN_ACCOUNT_JSP = "login/loginAccount.jsp";
    public static final String LOGIN_INDEX_ADMIN_JSP = "admin/indexAdmin.jsp";
    public static final String LOGIN_INDEX_TEACHER_JSP = "teacher/indexTeacher.jsp";
    public static final String LOGIN_INDEX_MINISTER_JSP = "minister/indexMinister.jsp";
    public static final String LOGIN_INDEX_STUDENT_JSP = "student/indexStudent.jsp";
    public static final String ACCOUNT_INCORRECT = "account or password you entered is incorrect.";

    public static User user;
    LoginAccount loginAccount = new LoginAccount();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        showFormLogin(request,response);


    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_LOGIN_ACCOUNT_JSP);
        dispatcher.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                loginAccount(request,response);

    }

    private void loginAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher = null;
        user = loginAccount.checkUser(username,password);


        if (user != null) {
            Role role = user.getRole();

            switch (role) {
                case ADMIN:
                    dispatcher = request.getRequestDispatcher(LOGIN_INDEX_ADMIN_JSP);

                    break;
                case MINISTER:
                    dispatcher = request.getRequestDispatcher(LOGIN_INDEX_MINISTER_JSP);

                    break;
                case STUDENT:
                    dispatcher = request.getRequestDispatcher(LOGIN_INDEX_STUDENT_JSP);

                    break;
                case TEACHER:
                    dispatcher = request.getRequestDispatcher(LOGIN_INDEX_TEACHER_JSP);
                    break;
            }

            Cookie cookie = new Cookie("user1",user.getName());
            cookie.setMaxAge(20);
            response.addCookie(cookie);
            request.setAttribute("user",user.getName());
            dispatcher.forward(request, response);
        }
         else {
            dispatcher = request.getRequestDispatcher(LOGIN_LOGIN_ACCOUNT_JSP);
            request.setAttribute("notification", ACCOUNT_INCORRECT);
            dispatcher.forward(request, response);
        }

        }

    }


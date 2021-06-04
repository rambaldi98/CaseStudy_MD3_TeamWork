package controller.admin;



import model.subject.Subject;

import model.user.Gender;
import model.user.Role;
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
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
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

            case "updateUser":
                showFormUpdate(request,response);
                break;

            case "deleteUser":
                showFormDelete(request,response);
                break;
            default:
                showIndexAdmin(request,response);
                break;

            case "createSubject":
                showFormCreateNewSubject(request,response);
                break;

        }
    }


    private void showFormCreateNewSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/createSubject.jsp");
        dispatcher.forward(request,response);


    }


    private void showIndexAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/indexAdmin.jsp");
        dispatcher.forward(request,response);
    }


    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.adminService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/deleteUser.jsp");
        request.setAttribute("user",user);
        dispatcher.forward(request,response);

    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.adminService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/updateUser.jsp");
        request.setAttribute("user",user);
        dispatcher.forward(request,response);
    }



    private void showFormCreateUSer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        RequestDispatcher dispatcher=request.getRequestDispatcher("admin/createUser.jsp");
        List<Role> roleList=adminService.selectAllRole();
        List<Gender> genderList=adminService.selectAllGender();
        request.setAttribute("roleList",roleList);
        request.setAttribute("genderList",genderList);
        dispatcher.forward(request,response);
    }




    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = adminService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/listUser.jsp");
        request.setAttribute("userList",userList);
        dispatcher.forward(request,response);

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action){

            case "createUser":
                createNewUser(request,response);
                break;

            case "updateUser":
                 updateUser(request,response);
                break;

            case "deleteUser":
                deleteUser(request,response);
                break;

                case "createSubject":
                    createNewSubject(request,response);
                    break;




            }
        }
        catch (ParseException e) {
        e.printStackTrace();
         }
    }

    private void createNewSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        Subject subject = new Subject(name);
        this.adminService.createNewSubject(subject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/createSubject.jsp");
        request.setAttribute("notification","them mon hoc thanh cong");
        dispatcher.forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.adminService.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/deleteUser.jsp");
        request.setAttribute("notification", "xoa thanh cong");
        dispatcher.forward(request, response);

    }


    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String date =  request.getParameter("dateOfBirth");

        Date dateOfBirth =  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfBirth"));
        String address = request.getParameter("address");
        int id_gender = Integer.parseInt(request.getParameter("gender_id"));
        Gender gender = adminService.findGenderById(id_gender);
        int id_role = Integer.parseInt(request.getParameter("role_id"));
        Role role = adminService.findRoleById(id_role);

        User user = new User(id,name,email,password,phone,dateOfBirth,address,gender,role);

        this.adminService.update(id,user, request);


        request.setAttribute("notification","Sửa thông tin thành công");
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/updateUser.jsp");
        dispatcher.forward(request,response);


    }

    private void createNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String date =  request.getParameter("dateOfBirth");
        System.out.println(date);
        Date dateOfBirth =  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfBirth"));

        String address = request.getParameter("address");

        int id_gender = Integer.parseInt(request.getParameter("gender_id"));
        Gender gender = adminService.findGenderById(id_gender);

        int id_role = Integer.parseInt(request.getParameter("role_id"));
        Role role = adminService.findRoleById(id_role);


        User user = new User(name,email,password,phone,dateOfBirth,address,gender,role);

        this.adminService.create(user,request);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/createUser.jsp");

        request.setAttribute("notification", "Them moi thang cong");
        dispatcher.forward(request,response);


    }
}

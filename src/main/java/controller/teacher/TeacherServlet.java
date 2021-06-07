package controller.teacher;

import controller.login.LoginServlet;
import model.classes.Class;
import model.diary.DiaryClass;
import model.diary.DiaryStudent;
import model.student.ClassStudent;
import model.user.User;
import service.loginjdbc.LoginAccount;
import service.teacherjdbc.ITeacherService;
import service.teacherjdbc.TeacherService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TeacherServlet", urlPatterns = "/teacher")
public class TeacherServlet extends HttpServlet {

    ITeacherService teacherService = new TeacherService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");


        if (action == null) action = "";
        switch (action){
            case "listClass":
                showListClass(request,response);
                break;
            case "listStudent":
                showListStudent(request,response);
                break;
            case "writeDiaryClass":
                showFormWriteDiaryClass(request,response);
                break;

            case "writeDiaryStudent":
                showFormWriteDiaryStudent(request,response);
                break;

            case "viewDetailStudent":
                showDetailStudent(request,response);
                break;
        }
    }

    private void showFormWriteDiaryStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("user",LoginServlet.user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/writeDiaryStudent.jsp");
        dispatcher.forward(request,response);

    }

    private void showDetailStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User student = this.teacherService.findStudentById(id);
        request.setAttribute("student",student);

        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/viewDetailStudent.jsp");
        dispatcher.forward(request,response);
    }


    private void showFormWriteDiaryClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Class> classList = this.teacherService.findAllClass();
        request.setAttribute("user",LoginServlet.user);
        request.setAttribute("classList",classList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/writeDiaryClass.jsp");
        dispatcher.forward(request,response);

    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<ClassStudent> classStudentList = this.teacherService.findAllStudentByClass(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/listStudent.jsp");
        request.setAttribute("classStudentList",classStudentList);
        dispatcher.forward(request,response);

    }

    private void showListClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DiaryClass> diaryClassList = this.teacherService.findAllClassByTeacher();
        request.setAttribute("diaryClassList", diaryClassList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/listClass.jsp");
        dispatcher.forward(request,response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String action = request.getParameter("action");
        try {
             switch (action){
                 case "writeDiaryClass":
                    writeDiaryClass(request,response);
                    break;

                 case "writeDiaryStudent":
                     writeDiaryStudent(request,response);
                     break;
            }
         } catch (ParseException e) {
        e.printStackTrace();
        }
    }

    private void writeDiaryStudent(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {

        User user = LoginServlet.user;
        int id_student = Integer.parseInt(request.getParameter("id"));
        User student = this.teacherService.findStudentById(id_student);
        Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
        String diary = request.getParameter("diary");
        System.out.println(LoginServlet.user);
        DiaryStudent diaryStudent = new DiaryStudent(student,LoginServlet.user,date,diary );
        this.teacherService.writeDiaryStudent(diaryStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/writeDiaryStudent.jsp");
        request.setAttribute("notification", "viet nhat ki thanh cong");
        dispatcher.forward(request,response);

    }

    private void writeDiaryClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {


        int id_class = Integer.parseInt(request.getParameter("id_class"));
        String diary = request.getParameter("diary");

        Class classes = this.teacherService.findClassById(id_class);

        Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));

        DiaryClass diaryClass = new DiaryClass(classes,LoginServlet.user,date,diary);
        this.teacherService.writeDiaryClass(diaryClass);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher/writeDiaryClass.jsp");
        request.setAttribute("notification", "them nhat ki thanh cong");
        dispatcher.forward(request,response);

        System.out.println(diaryClass);



    }
}

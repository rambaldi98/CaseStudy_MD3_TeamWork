package controller.teacher;

import model.diary.DiaryClass;
import model.student.ClassStudent;
import service.teacherjdbc.ITeacherService;
import service.teacherjdbc.TeacherService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        }
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

    }
}

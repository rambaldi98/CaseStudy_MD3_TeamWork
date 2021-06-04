package service.teacherjdbc;

import model.classes.Class;
import model.diary.DiaryClass;
import model.diary.DiaryStudent;
import model.student.ClassStudent;
import model.student.Student;
import model.user.User;
import service.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements ITeacherService{

    public static final String SELCET_ALL_FROM_DIARY_CLASS = "select c.name as class_name,c.id as id_class ,u.name as user_name from diary_class\n" +
            "join class c on c.id = diary_class.class_id\n" +
            "join user u on u.id = diary_class.teacher_id;";
    public static final String SELECT_STUDENT_BY_ID_CLASS = "select c.name as name_class,u.name as name_student from class_student\n" +
            "join class c on c.id = class_student.class_id\n" +
            "join user u on u.id = class_student.student_id where class_id = ?";

    Connection connection = ConnectJDBC.getConnection();


    @Override
    public List<DiaryClass> findAllClassByTeacher() {
        List<DiaryClass>  diaryClassList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELCET_ALL_FROM_DIARY_CLASS);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id_class = set.getInt("id_class");
                String name_class  = set.getString("class_name");
                String name_teacher = set.getString("user_name");

                User user = new User(name_teacher);
                Class classes = new Class(id_class,name_class);
                DiaryClass diaryClass = new DiaryClass(classes, user);
                diaryClassList.add(diaryClass);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return diaryClassList;
    }

    @Override
    public List<ClassStudent> findAllStudentByClass(int id) {
        List<ClassStudent> classStudentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID_CLASS);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String name_student = set.getString("name_student");
                String name_class  = set.getString("name_class");
              Class classes = new Class(name_class);
              User student = new User(name_student);
              ClassStudent classStudent = new ClassStudent(student,classes);
              classStudentList.add(classStudent);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return classStudentList;
    }

    @Override
    public void writeDiaryClass(DiaryClass diaryClass) {

    }

    @Override
    public void writeDiaryStudent(DiaryStudent diaryStudent) {

    }
}

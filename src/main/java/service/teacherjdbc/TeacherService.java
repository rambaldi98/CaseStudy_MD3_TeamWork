package service.teacherjdbc;

import controller.login.LoginServlet;
import model.classes.Class;
import model.diary.DiaryClass;
import model.diary.DiaryStudent;
import model.student.ClassStudent;
import model.student.Student;
import model.user.Gender;
import model.user.Role;
import model.user.User;
import service.ConnectJDBC;
import service.adminjdbc.AdminService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherService implements ITeacherService{

    public static final String SELCET_ALL_FROM_DIARY_CLASS = "select c.name as class_name,c.id as id_class ,u.name as user_name from diary_class\n" +
            "join class c on c.id = diary_class.class_id\n" +
            "join user u on u.id = diary_class.teacher_id";


            ;
    public static final String SELECT_STUDENT_BY_ID_CLASS = "select c.name as name_class,u.id as id_student, u.name as name_student  from class_student\n" +
            "join class c on c.id = class_student.class_id\n" +
            "join user u on u.id = class_student.student_id where class_id = ?";
    public static final String SELECT_STUDENT_BY_ID = "select * ,g.name as gender_name, r.name as role_name from user\n" +
            "  join gender g on g.id = user.gender_id\n" +
            " join role r on r.id = user.role_id\n" +
            "where role_id = 4 and user.id = ?";
    public static final String INSERT_DIARY_STUDENT = "insert into diary_student (student_id, teacher_id, date, diary) VALUE\n" +
            "(?,?,?,?)";

    Connection connection = ConnectJDBC.getConnection();


    public static String convertDate(Date date){
        DateFormat newdate = new SimpleDateFormat("yyyy-MM-dd");
        return   newdate.format(date);
    }


    @Override
    public List<DiaryClass> findAllClassByTeacher() {
        List<DiaryClass>  diaryClassList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELCET_ALL_FROM_DIARY_CLASS);

            System.out.println(LoginServlet.user.getId());
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
                int id_student = set.getInt("id_student");
                String name_student = set.getString("name_student");
                String name_class  = set.getString("name_class");
              Class classes = new Class(name_class);
              User student = new User(id_student, name_student);
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
        try {
            PreparedStatement statement = connection.prepareStatement("insert into diary_class (class_id, teacher_id, date, diary) value\n" +
                    "(?,?,?, ?)");
            statement.setInt(1,diaryClass.getaClass().getId());
            statement.setInt(2,diaryClass.getTeacher().getId());
            statement.setString(3, convertDate(diaryClass.getDate()));
            statement.setString(4,diaryClass.getDiary());

            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void writeDiaryStudent(DiaryStudent diaryStudent) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_DIARY_STUDENT);
            statement.setInt(1,diaryStudent.getStudent().getId());
            statement.setInt(2,diaryStudent.getTeacher().getId());
            statement.setString(3,convertDate(diaryStudent.getDate()));
            statement.setString(4,diaryStudent.getDiary());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    @Override
    public List<Class> findAllClass() {
        
        List<Class> classList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from class");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                Class classes = new Class(id,name);
                classList.add(classes);
            }
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return classList;
    }


    @Override
    public Class findClassById(int id) {
        Class classes = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from class where id = ?");

            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String name = set.getString("name");
                classes = new Class(id,name);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classes;
    }

    @Override
    public User findStudentById(int id) {
        User student = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String user_name = set.getString("name");
                String email = set.getString("email");
                String password = set.getString("password");
                String phone = set.getString("phone");
                Date dateOfBirth = set.getDate("dateOfBirth");
                String address = set.getString("address");
                String gender_name = set.getString("gender_name");
                String role_name = set.getString("role_name");
                Gender gender = Gender.valueOf(gender_name);
                Role role = Role.valueOf(role_name);
                System.out.println(statement);
                student = new User(id,user_name,email,password,phone,dateOfBirth,address,gender,role);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }
}

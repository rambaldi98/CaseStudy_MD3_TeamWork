package service.teacherjdbc;

import model.classes.Class;
import model.diary.DiaryClass;
import model.diary.DiaryStudent;
import model.student.ClassStudent;
import model.student.Student;
import model.user.User;

import java.util.List;

public interface ITeacherService {
    List<DiaryClass> findAllClassByTeacher();

    List<ClassStudent> findAllStudentByClass(int id);

    void writeDiaryClass (DiaryClass diaryClass);

    void  writeDiaryStudent(DiaryStudent diaryStudent);

    List<Class> findAllClass();

    Class findClassById(int id);
    
    User findStudentById(int id);



}

package service.teacherjdbc;

import model.diary.DiaryClass;
import model.diary.DiaryStudent;
import model.student.ClassStudent;
import model.student.Student;

import java.util.List;

public interface ITeacherService {
    List<DiaryClass> findAllClassByTeacher();

    List<ClassStudent> findAllStudentByClass(int id);

    void writeDiaryClass (DiaryClass diaryClass);

    void  writeDiaryStudent(DiaryStudent diaryStudent);



}

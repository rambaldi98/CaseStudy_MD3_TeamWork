package model.diary;

import model.classes.Class;
import model.user.User;

import java.util.Date;

public class DiaryClass {
    private int id;
    private Class aClass;
    private User teacher;
    private Date date;
    private String diary;

    public DiaryClass() {
    }

    public DiaryClass(Class aClass, User teacher, Date date, String diary) {
        this.aClass = aClass;
        this.teacher = teacher;
        this.date = date;
        this.diary = diary;
    }

    public DiaryClass(int id, Class aClass, User teacher, Date date, String diary) {
        this.id = id;
        this.aClass = aClass;
        this.teacher = teacher;
        this.date = date;
        this.diary = diary;
    }

    public DiaryClass(Class classes, User user) {
        this.aClass = classes;
        this.teacher = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiary() {
        return diary;
    }

    public void setDiary(String diary) {
        this.diary = diary;
    }
}

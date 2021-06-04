package model.diary;

import model.user.User;

import java.util.Date;

public class DiaryStudent {
    private int id;
    private User student;
    private User teacher;
    private Date date;
    private String diary;

    public DiaryStudent() {
    }

    public DiaryStudent(User student, User teacher, Date date, String diary) {
        this.student = student;
        this.teacher = teacher;
        this.date = date;
        this.diary = diary;
    }

    public DiaryStudent(int id, User student, User teacher, Date date, String diary) {
        this.id = id;
        this.student = student;
        this.teacher = teacher;
        this.date = date;
        this.diary = diary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
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

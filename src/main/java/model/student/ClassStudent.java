package model.student;

import model.classes.Class;
import model.user.User;

public class ClassStudent {

    private int id;
    private User student;
    private Class aClass;

    public ClassStudent(int id, User student, Class aClass) {
        this.id = id;
        this.student = student;
        this.aClass = aClass;
    }

    public ClassStudent() {
    }

    public ClassStudent(User student, Class aClass) {
        this.student = student;
        this.aClass = aClass;
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

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}

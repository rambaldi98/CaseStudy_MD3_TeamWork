package model.student;

import model.user.Gender;
import model.user.User;

public class Student {
    private int id;
    private User student;
    private Status status;

    public Student(int id, User student, Status status) {
        this.id = id;
        this.student = student;
        this.status = status;
    }

    public Student(User student, Status status) {
        this.student = student;
        this.status = status;
    }

    public Student() {
    }

    public Student(String name_student) {
    }

    public Student(Status status1) {
        this.status = status1;
    }

    public Student(User user) {
        this.student = user;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student=" + student +
                ", status=" + status +
                '}';
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

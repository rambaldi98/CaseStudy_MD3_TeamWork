package model.point;

import model.subject.Subject;
import model.user.User;

public class Point {
    private int id;
    private User minister;
    private User student;
    private Subject subject;
    private float point;

    public Point() {
    }

    public Point(User minister, User student, Subject subject, float point) {
        this.minister = minister;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public Point(int id, User minister, User student, Subject subject, float point) {
        this.id = id;
        this.minister = minister;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public Point(Subject subject, float point) {
        this.subject = subject;
        this.point = point;
    }

    public Point(float points) {
        this.point = points;
    }

    @Override
    public String toString() {
        return "Point{" +
                "point=" + point +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getMinister() {
        return minister;
    }

    public void setMinister(User minister) {
        this.minister = minister;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }
}

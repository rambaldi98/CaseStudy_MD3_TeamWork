package model.classes;

public class Class {
    private int id;
    private String name;

    public Class (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Class(String name) {
        this.name = name;
    }

    public Class() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

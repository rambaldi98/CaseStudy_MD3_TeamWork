package model.classes;

public class Class {
    private  int id;
    private String name;

    public Class(String name_class) {
        this.name = name_class;
    }

    public Class(int id_class, String name_class) {
        this.id = id_class;
        this.name = name_class;
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

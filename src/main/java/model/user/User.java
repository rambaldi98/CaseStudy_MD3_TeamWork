package model.user;

import java.util.Date;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Date dateOfBirth;
    private String address;
    private Gender gender;
    private Role role;

    public User(int id, String name, String email, String address) {
    }

    public User(String name, String email, String password, String phone, Date dateOfBirth, String address, Gender gender, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gender = gender;
        this.role = role;
    }

    public User(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int id, String name, String email, String password, String phone, Date dateOfBirth, String address, Gender gender, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gender = gender;
        this.role = role;
    }

    public User(int id, String user_name, String email, String password, String phone, Date dateOfBirth, String address) {
        this.id = id;
        this.name = user_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;

    }

    public User(String name, String email, String password, String phone, String address, Gender gender, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.role = role;
    }

    public User(String name_teacher) {
        this.name = name_teacher;
    }

    public User(int id_student, String name_student) {
        this.id = id_student;
        this.name = name_student;
    }

    public User(int id, String name, String email, String address, Gender gender1) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender1;
    }

    public User(int id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

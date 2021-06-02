package user.student;

public class student {
    private String Email;
    private String Password;
    private int NumberPhone;
    private String FullName;
    private String DateOfBirth;
    private String Address;
    private String Gender;

    public student() {
    }

    public student(String email, String password, int numberPhone, String fullName, String dateOfBirth, String address, String gender) {
        Email = email;
        Password = password;
        NumberPhone = numberPhone;
        FullName = fullName;
        DateOfBirth = dateOfBirth;
        Address = address;
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getNumberPhone() {
        return NumberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        NumberPhone = numberPhone;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "student{" +
                "Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", NumberPhone=" + NumberPhone +
                ", FullName='" + FullName + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", Address='" + Address + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}

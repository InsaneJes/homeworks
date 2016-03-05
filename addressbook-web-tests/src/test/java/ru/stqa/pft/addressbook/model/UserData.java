package ru.stqa.pft.addressbook.model;

public class UserData {
    private final String usermail;
    private final String firstname;
    private final String lastname;
    private final String mobilenumber;
    private String group;

    public UserData(String usermail, String firstname, String lastname, String mobilenumber, String group) {
        this.usermail = usermail;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobilenumber = mobilenumber;
        this.group = group;
    }

    public String getUsermail() {
        return usermail;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String getGroup() {
        return group;
    }
}

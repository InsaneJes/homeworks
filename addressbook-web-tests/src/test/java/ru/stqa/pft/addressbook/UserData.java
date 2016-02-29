package ru.stqa.pft.addressbook;

public class UserData {
    private final String usermail;
    private final String firstname;
    private final String lastname;
    private final String mobilenumber;

    public UserData(String usermail, String firstname, String lastname, String mobilenumber) {
        this.usermail = usermail;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobilenumber = mobilenumber;
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
}

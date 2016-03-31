package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("user")

public class UserData {
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;;
    private String usermail;
    private String firstname;
    private String lastname;

    private String group;

    private String mobilePhone;
    private String homePhone;
    private String workPhone;

    private String allPhones;

    private String address1;
    private String address2;
    private String email2;
    private String email3;

    private String allEmails;

    private File photo;

    public File getPhoto() {
        return photo;
    }

    public UserData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getUsermail() {
        return usermail;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    public UserData withUsermail(String usermail) {
        this.usermail = usermail;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (id != userData.id) return false;
        if (firstname != null ? !firstname.equals(userData.firstname) : userData.firstname != null) return false;
        return lastname != null ? lastname.equals(userData.lastname) : userData.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public UserData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public UserData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;

    }

    public UserData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public UserData withMobilePhone(String mobile) {
        this.mobilePhone = mobile;
        return this;
    }

    public UserData withWorkPhone(String work) {
        this.workPhone = work;
        return this;
    }

    public UserData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public UserData withGroup(String group) {
        this.group = group;
        return this;
    }

    public UserData withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public UserData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public UserData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public UserData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

}

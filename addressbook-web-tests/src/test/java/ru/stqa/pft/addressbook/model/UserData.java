package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("user")
@Entity
@Table(name="addressbook")

public class UserData {
    @XStreamOmitField
    @Id
    @Column(name="id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name="email")
    @Type(type = "text")
    private String usermail;

    @Expose
    @Column(name="firstname")
    private String firstname;

    @Expose
    @Column(name="lastname")
    private String lastname;

    @Expose
    @Column(name="mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Expose
    @Column(name="home")
    @Type(type = "text")
    private String homePhone;

    @Expose
    @Column(name="work")
    @Type(type = "text")
    private String workPhone;

    @Transient
    private String allPhones;

    @Expose
    @Column(name="address")
    @Type(type = "text")
    private String address1;

    @Expose
    @Column(name="address2")
    @Type(type = "text")
    private String address2;

    @Expose
    @Column(name="email2")
    @Type(type = "text")
    private String email2;

    @Expose
    @Column(name="email3")
    @Type(type = "text")
    private String email3;

    @Transient
    private String allEmails;

    @Expose
    @Column(name="photo")
    @Type(type = "text")
    private String photo;

    @ManyToMany
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public File getPhoto() {
        return new File(photo);
    }

    public UserData withPhoto(File photo) {
        this.photo = photo.getPath();
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

    public Groups getGroups() {
        return new Groups(groups);
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

    public UserData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}

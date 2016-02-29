package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.UserData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver wd) {
        super (wd);
    }

    public void submitUserCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillUserForm(UserData userData) {
        type(By.name("email"), userData.getUsermail());
        type(By.name("firstname"), userData.getFirstname());
        type(By.name("lastname"), userData.getLastname());
        type(By.name("mobile"), userData.getMobilenumber());

    }

    public void initUserCreation() {
        click(By.linkText("add new"));
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }
}

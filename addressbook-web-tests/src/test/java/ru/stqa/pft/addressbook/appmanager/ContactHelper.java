package ru.stqa.pft.addressbook.appmanager;


import com.thoughtworks.selenium.webdriven.commands.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super (wd);
    }

    public void submitUserCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillUserForm(UserData userData, boolean creation) {
        type(By.name("email"), userData.getUsermail());
        type(By.name("firstname"), userData.getFirstname());
        type(By.name("lastname"), userData.getLastname());
        type(By.name("mobile"), userData.getMobilenumber());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
        } else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initUserCreation() {
        click(By.linkText("add new"));
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void editFirstContact() {
        click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[8]/a"));
    }

    public void submitUserUpdate() {
        click(By.xpath("//*[@id='content']/form[1]/input[1]"));
    }

    public void selectFirstContact() {
        click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[1]/input[1]"));
    }

    public void DeleteContact() {
        click(By.xpath("//*[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void createUser(UserData user, boolean b) {
        initUserCreation();
        fillUserForm(user, true);
        submitUserCreation();
        returnToHomePage();
    }

    public boolean isThereUser() {
        return isElementPresent(By.name("entry"));
    }
}

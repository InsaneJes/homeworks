package ru.stqa.pft.addressbook.appmanager;


import com.thoughtworks.selenium.webdriven.commands.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.ArrayList;
import java.util.List;

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

    /*  Закомментированный ниже метод заменён другим - editContact()
    public void editFirstContact() {
        click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[8]/a"));
    }
    */

    public void editContact(int index) {
        wd.findElements(By.xpath("//*[@title='Edit']")).get(index).click();
    }

    public void submitUserUpdate() {
        click(By.xpath("//*[@id='content']/form[1]/input[1]"));
    }

    /*  Закомментированный ниже метод заменён другим - selectContact()
    public void selectFirstContact() {
        click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[1]/input[1]"));
    }
    */

    public void selectContact(int index) {
        wd.findElements(By.xpath("//*[@name='selected[]']")).get(index).click();
    }

    public void DeleteContact() {
        click(By.xpath("//*[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void createUser(UserData user) {
        initUserCreation();
        fillUserForm(user, true);
        submitUserCreation();
        returnToHomePage();
    }

    public boolean isThereUser() {
        return isElementPresent(By.name("entry"));
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//tr[@name='entry']")).size();
    }

    public List<UserData> getContactList() {
        List<UserData> contacts = new ArrayList<UserData>();
        List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String firstname = element.findElement(By.xpath("td[3]")).getText();
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            UserData contact = new UserData(id, null, firstname, lastname, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}

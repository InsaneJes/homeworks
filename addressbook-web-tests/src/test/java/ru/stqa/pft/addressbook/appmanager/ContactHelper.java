package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.UserData;

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
        type(By.name("email2"), userData.getEmail2());
        type(By.name("email3"), userData.getEmail3());
        type(By.name("firstname"), userData.getFirstname());
        type(By.name("lastname"), userData.getLastname());
        type(By.name("mobile"), userData.getMobilePhone());
        type(By.name("home"), userData.getHomePhone());
        type(By.name("work"), userData.getWorkPhone());
        type(By.name("address"), userData.getAddress1());
        type(By.name("address2"), userData.getAddress2());



        if (userData.getGroup() != null) {
            if (creation) {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
            } else {
                Assert.assertFalse(isElementPresent(By.name("new_group")));
            }
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

    public void editContact(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
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

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void deleteContact() {
        click(By.xpath("//*[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void create(UserData user) {
        initUserCreation();
        fillUserForm(user, true);
        submitUserCreation();
        returnToHomePage();
    }

    public void modify(UserData contact) {
        editContact(contact.getId());
        fillUserForm(contact, false);
        submitUserUpdate();
        returnToHomePage();
    }

    public void delete(UserData user) {
        selectContactById(user.getId());
        deleteContact();
        returnToHomePage();
    }

    public boolean isThereUser() {
        return isElementPresent(By.name("entry"));
    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//tr[@name='entry']")).size();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//*[@name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String firstname = element.findElement(By.xpath("td[3]")).getText();
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            String allPhones = element.findElement(By.xpath("td[6]")).getText();
            String allEmails = element.findElement(By.xpath("td[5]")).getText();
            String address1 = element.findElement(By.xpath("td[4]")).getText();
            /*
            contacts.add(new UserData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
                    */
            contacts.add(new UserData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones).withAddress1(address1).withAllEmails(allEmails));
        }
        return contacts;
    }

    public UserData infoFromEditForm(UserData contact) {
        editContact(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname= wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address1 = wd.findElement(By.name("address")).getAttribute("value");
        String address2 = wd.findElement(By.name("address2")).getAttribute("value");
        String usermail = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new UserData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withAddress1(address1).withAddress2(address2)
                .withUsermail(usermail).withEmail2(email2).withEmail3(email3);
    }
}

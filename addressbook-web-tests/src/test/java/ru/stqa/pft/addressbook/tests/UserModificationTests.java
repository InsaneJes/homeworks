package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase{

    @Test
    public void testUserModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().editFirstContact();
        app.getContactHelper().fillUserForm(new UserData("newMail@newmail.ru", "Petr", "Petrov", "8-901-555-55-55", null), false);
        app.getContactHelper().submitUserUpdate();
        app.getContactHelper().returnToHomePage();
    }
}

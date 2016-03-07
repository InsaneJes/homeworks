package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase{

    @Test
    public void testUserModification() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereUser()) {
            app.getContactHelper().createUser(new UserData("Testmail@testmail.ru", "Ivan", "Ivanov", "8-909-666-66-66", "test1"), true);
        }
        app.getContactHelper().editFirstContact();
        app.getContactHelper().fillUserForm(new UserData("newMail@newmail.ru", "Petr", "Petrov", "8-901-555-55-55", null), false);
        app.getContactHelper().submitUserUpdate();
        app.getContactHelper().returnToHomePage();
    }
}

package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserDeletionTests extends TestBase{

    @Test
    public void testUserDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereUser()) {
            app.getContactHelper().createUser(new UserData("Testmail@testmail.ru", "Ivan", "Ivanov", "8-909-666-66-66", "test1"));
        }
        app.getContactHelper().selectFirstContact();
        app.getContactHelper().DeleteContact();
        app.getContactHelper().returnToHomePage();

    }
}

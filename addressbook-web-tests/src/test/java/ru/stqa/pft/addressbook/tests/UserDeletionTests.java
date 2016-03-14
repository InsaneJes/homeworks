package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTests extends TestBase{

    @Test
    public void testUserDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereUser()) {
            app.getContactHelper().createUser(new UserData("Testmail@testmail.ru", "Ivan", "Ivanov", "8-909-666-66-66", "test1"));
        }
        List<UserData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().DeleteContact();
        app.getContactHelper().returnToHomePage();
        List<UserData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

    }
}

package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserModificationTests extends TestBase{

    @Test
    public void testUserModification() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereUser()) {
            app.getContactHelper().createUser(new UserData("Testmail@testmail.ru", "Ivan", "Ivanov", "8-909-666-66-66", "test1"));
        }
        List<UserData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size() -1);
        UserData contact = new UserData(before.get(before.size() - 1).getId(),"newMail@newmail.ru", "Petr", "Petrov", "8-901-555-55-55", null);
        app.getContactHelper().fillUserForm(contact, false);
        app.getContactHelper().submitUserUpdate();
        app.getContactHelper().returnToHomePage();
        List<UserData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super UserData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}

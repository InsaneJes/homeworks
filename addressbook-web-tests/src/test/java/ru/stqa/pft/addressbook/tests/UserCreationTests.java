package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<UserData> before = app.getContactHelper().getContactList();
        UserData contact = new UserData("Testmail@testmail.ru", "Ivan", "Ivanov", "8-909-666-66-66", "test1");
        app.getContactHelper().createUser(contact);
        List<UserData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super UserData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}

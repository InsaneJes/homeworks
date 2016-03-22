package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserCreationTests extends TestBase {

    @Test(enabled = false)
    public void testUserCreation() {
        app.goTo().homePage();
        List<UserData> before = app.contact().list();
        UserData contact = new UserData("Testmail@testmail.ru", "Ivan", "Ivanov", "8-909-666-66-66", "test1");
        app.contact().create(contact);
        List<UserData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super UserData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}

package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new UserData("Testmail@testmail.ru", "Ivan", "Ivanov", "8-909-666-66-66", "test1"));
        }
    }

    @Test(enabled = false)
    public void testUserModification() {
        List<UserData> before = app.contact().list();
        int index = before.size() - 1;
        UserData contact = new UserData(before.get(index).getId(),"newMail@newmail.ru", "Petr", "Petrov", "8-901-555-55-55", null);
        app.contact().modify(index, contact);
        List<UserData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super UserData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }


}

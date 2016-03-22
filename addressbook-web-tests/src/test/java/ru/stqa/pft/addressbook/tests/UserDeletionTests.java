package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new UserData("Testmail@testmail.ru", "Ivan", "Ivanov", "8-909-666-66-66", "test1"));
        }
    }

    @Test
    public void testUserDeletion() {
        List<UserData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<UserData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }
}

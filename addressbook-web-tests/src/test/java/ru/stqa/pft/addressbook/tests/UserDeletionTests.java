package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Set;

public class UserDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new UserData().withUsermail("Testmail@testmail.ru").withFirstname("Ivan").withLastname("Ivanov").withMobilenumber("8-909-666-66-66").withGroup("test1"));
        }
    }

    @Test
    public void testUserDeletion() {
        Set<UserData> before = app.contact().all();
        UserData deletedUser = before.iterator().next();
        app.contact().delete(deletedUser);
        Set<UserData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedUser);
        Assert.assertEquals(before, after);

    }
}

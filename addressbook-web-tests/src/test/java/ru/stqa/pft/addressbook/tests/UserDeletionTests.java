package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.UserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new UserData().withUsermail("Testmail@testmail.ru").withFirstname("Ivan").withLastname("Ivanov").withMobilePhone("8-909-666-66-66").withGroup("test1"));
        }
    }

    @Test
    public void testUserDeletion() {
        Contacts before = app.contact().all();
        UserData deletedUser = before.iterator().next();
        app.contact().delete(deletedUser);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedUser)));

    }
}

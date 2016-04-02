package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.UserData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new UserData().withUsermail("Testmail@testmail.ru").withFirstname("Ivan").withLastname("Ivanov")
                    .withMobilePhone("8-909-666-66-66").withPhoto(new File("src/test/resources/ph.png")));
        }
    }

    @Test
    public void testUserModification() {
        Contacts before = app.db().contacts();
        UserData modifiedUser = before.iterator().next();
        UserData contact = new UserData()
                .withId(modifiedUser.getId()).withUsermail("newMail@newmail.ru").withFirstname("Petr").withLastname("Petrov")
                .withMobilePhone("8-901-555-55-55").withPhoto(new File("src/test/resources/ph.png"));
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedUser).withAdded(contact)));
    }


}

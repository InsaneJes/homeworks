package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Set;

public class UserModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new UserData().withUsermail("Testmail@testmail.ru").withFirstname("Ivan").withLastname("Ivanov").withMobilenumber("8-909-666-66-66").withGroup("test1"));
        }
    }

    @Test
    public void testUserModification() {
        Set<UserData> before = app.contact().all();
        UserData modifiedUser = before.iterator().next();
        UserData contact = new UserData()
                .withId(modifiedUser.getId()).withUsermail("newMail@newmail.ru").withFirstname("Petr").withLastname("Petrov").withMobilenumber("8-901-555-55-55");
        app.contact().modify(contact);
        Set<UserData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedUser);
        before.add(contact);

        /*
        Comparator<? super UserData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        */

        Assert.assertEquals(before,after);
    }


}

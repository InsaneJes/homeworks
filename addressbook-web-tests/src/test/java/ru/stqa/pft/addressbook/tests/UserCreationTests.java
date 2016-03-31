package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validUsers() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new UserData().withFirstname("Ivan 1").withLastname("Ivanov 1").withAddress1("pr-t Mira, 1").withAddress2("pr-t Pobedi 1")
                .withUsermail("Test@mail.org1").withEmail2("Test2@mail.org1").withEmail3("Test3@mail.org1").withHomePhone("01").withMobilePhone("001").withWorkPhone("0001")
                .withPhoto(new File("src/test/resources/ph.png"))});
        list.add(new Object[] {new UserData().withFirstname("Ivan 2").withLastname("Ivanov 2").withAddress1("pr-t Mira, 2").withAddress2("pr-t Pobedi 2")
                .withUsermail("Test@mail.org2").withEmail2("Test2@mail.org2").withEmail3("Test3@mail.org2").withHomePhone("02").withMobilePhone("002").withWorkPhone("0002")
                .withPhoto(new File("src/test/resources/ph.png"))});
        list.add(new Object[] {new UserData().withFirstname("Ivan 3").withLastname("Ivanov 3").withAddress1("pr-t Mira, 3").withAddress2("pr-t Pobedi 3")
                .withUsermail("Test@mail.org3").withEmail2("Test2@mail.org3").withEmail3("Test3@mail.org3").withHomePhone("03").withMobilePhone("003").withWorkPhone("0003")
                .withPhoto(new File("src/test/resources/ph.png"))});
        return list.iterator();
    }

    @Test(dataProvider = "validUsers")
    public void testUserCreation(UserData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }

}

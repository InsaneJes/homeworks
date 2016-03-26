package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsDetailsTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        app.contact().deleteAllOnPage();
        app.goTo().homePage();
        UserData newContact = new UserData().withUsermail("Testmail@testmail.ru").withFirstname("Ivan").withLastname("Ivanov").withMobilePhone("8-909-666-66-66")
                .withHomePhone("+7(495)777-77-77").withWorkPhone("+7999")
                .withAddress1("пр-т Мира д.7 кв. 7;")
                .withEmail2("2Test2@test.com").withEmail3("test-test@test.org");
        app.contact().create(newContact);

    }

    @Test
    public void contactDetailsPageTest() {
        app.goTo().homePage();
        UserData contact = app.contact().all().iterator().next();
        UserData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(app.contact().infoFromDetailsPage(contact), equalTo(fromModifyToOneString(contactInfoFromEditForm)));
    }

    private String fromModifyToOneString(UserData contact) {
        app.goTo().homePage();
        return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress1(), contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getUsermail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactsDetailsTest::cleaned)
                .collect(Collectors.joining(""));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "");
    }

}

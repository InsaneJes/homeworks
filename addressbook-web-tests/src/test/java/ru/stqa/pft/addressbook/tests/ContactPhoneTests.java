package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(
                    new UserData().withUsermail("Testmail@testmail.ru").withFirstname("Ivan").withLastname("Ivanov").withMobilePhone("8-909-666-66-66")
                            .withHomePhone("+7(495)777-77-77").withWorkPhone("+7999")
                            .withAddress1("пр-т Мира д.7 кв. 7;").withAddress2("ул. им. Ленина д. 8 корп. 8. кв. 8")
                            .withUsermail("Test1@test.ru").withEmail2("2Test2@test.com").withEmail3("test-test@test.org")
            );
        }
    }

    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        UserData contact = app.contact().all().iterator().next();
        UserData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(UserData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }
}

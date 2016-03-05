package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserCreationTests extends TestBase {

    @Test
    public void testUserCreation() {
        app.getContactHelper().initUserCreation();
        app.getContactHelper().fillUserForm(new UserData("Testmail@testmail.ru", "Ivan", "Ivanov", "8-909-666-66-66", "test1"), true);
        app.getContactHelper().submitUserCreation();
        app.getContactHelper().returnToHomePage();
    }

}

package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        submitGroupCreation();
        gotoGroupPage();    /* Т.к. на всех страницах одно меню, то для сокращения количества кода
                            и первый переход, и возврат на страницу групп сделал одним методом  */
    }

}

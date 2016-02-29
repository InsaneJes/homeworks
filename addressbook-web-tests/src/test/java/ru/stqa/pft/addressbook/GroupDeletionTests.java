package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

    @Test
    public void еуыеGroupDeletion() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        gotoGroupPage();
    }
}

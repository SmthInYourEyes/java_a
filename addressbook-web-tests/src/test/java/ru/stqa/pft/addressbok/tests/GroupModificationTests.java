package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbok.model.GroupData;

public class GroupModificationTests extends TestBase {


    @Test
    public void testGroupModification() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("testR", "TestR2", "testR3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
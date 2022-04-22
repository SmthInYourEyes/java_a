package ru.stqa.pft.addressbok.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbok.model.GroupData;

public class GroupModificationTests extends TestBase {


    @Test
    public void testGroupModification() {

        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));{
            }
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("testR", "aa", "aa"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
    }

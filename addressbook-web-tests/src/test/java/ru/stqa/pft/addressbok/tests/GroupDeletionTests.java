package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));{
      }
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}




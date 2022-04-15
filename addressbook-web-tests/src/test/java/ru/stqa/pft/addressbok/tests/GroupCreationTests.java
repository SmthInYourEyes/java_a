package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testCreationGroup() {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
  }

}

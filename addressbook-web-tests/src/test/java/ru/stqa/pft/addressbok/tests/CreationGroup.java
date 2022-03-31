package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.GroupData;

public class CreationGroup extends TestBase {

  @Test
  public void testCreationGroup() {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test11", "test1", "test111"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGruopPage();
  }

}

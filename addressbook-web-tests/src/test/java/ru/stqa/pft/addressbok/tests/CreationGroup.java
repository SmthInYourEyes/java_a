package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.GroupData;

public class CreationGroup extends TestBase {

  @Test
  public void testCreationGroup() {

    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test11", "test1", "test111"));
    app.submitGroupCreation();
    app.returnToGruopPage();
  }

}

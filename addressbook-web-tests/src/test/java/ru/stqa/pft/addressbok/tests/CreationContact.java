package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.ContactData;

public class CreationContact extends TestBase {


  @Test
  public void testCreationContact() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("aaa", "bbb", "7744477755", "67mmppyy5", "ggghht@tu.com"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToHomePage();
  }
}





package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.ContactData;

public class ContactCreation extends TestBase {


    @Test
    public void testCreationContact() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("aaa", "bbb", "7744477755", "67445", "ggghht@tu.com", "testR"), true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }
}





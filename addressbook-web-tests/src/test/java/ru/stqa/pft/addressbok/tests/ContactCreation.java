package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.ContactData;

public class ContactCreation extends TestBase {


    @Test
    public void testCreationContact() {
        app.getContactHelper().createContact(new ContactData("aaa", "bbb", "7", "67445", "а.com", "[none]"));
        app.getNavigationHelper().goToHomePage();
    }
}





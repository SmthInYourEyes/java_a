package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.ContactData;

public class ContactCreation extends TestBase {


    @Test
    public void testCreationContact() {
        app.getContactHelper().createContact(new ContactData(Integer.valueOf("aaa"), "bbb", "а.com", "[none]"));
        app.getNavigationHelper().goToHomePage();
    }
}





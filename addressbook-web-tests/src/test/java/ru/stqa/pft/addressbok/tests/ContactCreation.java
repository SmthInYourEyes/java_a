package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.ContactData;
import ru.stqa.pft.addressbok.model.GroupData;

public class ContactCreation extends TestBase {


    @Test
    public void testCreationContact() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("aaa", "bbb", "7744477755", "67mmppyy5", "ggghht@tu.com", "testR"), true);{
            }
        }
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("aaa", "bbb", "7744477755", "67mmppyy5", "ggghht@tu.com", "testR"), true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }
}





package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbok.model.ContactData;

public class ContactModification extends TestBase {

    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test1", "test2", "test3",
                    "test4", "test5", "[none]"));{
            }
        }
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "test3",
                "test4", "test5", null), false);
        app.getContactHelper().submitContactModification();

    }

}

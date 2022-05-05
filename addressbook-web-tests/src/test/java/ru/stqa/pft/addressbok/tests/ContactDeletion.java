package ru.stqa.pft.addressbok.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbok.model.ContactData;


import java.util.List;

public class ContactDeletion extends TestBase {

    @Test(enabled = false)
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(null, "test", "test", "[none]"));
            {
            }
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().goToHomePage();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}

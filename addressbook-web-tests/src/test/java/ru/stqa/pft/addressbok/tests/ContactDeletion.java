package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.Test;

public class ContactDeletion extends TestBase {

    @Test
    public void testContactDeletion()
    {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();

        app.getNavigationHelper().goToHomePage();
    }
}

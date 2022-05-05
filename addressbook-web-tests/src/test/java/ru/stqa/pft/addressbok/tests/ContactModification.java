package ru.stqa.pft.addressbok.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbok.model.ContactData;


import java.util.Comparator;
import java.util.List;

public class ContactModification extends TestBase {


    @BeforeMethod
    public void ensureContactPreconditions() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(null,
                    "test", "test", "[none]"));
        }
        app.getContactHelper().goToHomePage();
    }

        @Test(enabled = false)
        public void testContactModification() {
            List<ContactData> before = app.getContactHelper().getContactList();
            int index = before.size() - 1;
            ContactData contact = new ContactData(before.get(index).getId(), "test12", "test11", null);
            app.getContactHelper().modifyContact(index, contact);
            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size());

            before.remove(index);
            before.add(contact);
            Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);


        }

    }

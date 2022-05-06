package ru.stqa.pft.addressbok.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.ContactData;

import java.util.Set;

public class ContactCreation extends TestBase {


    @Test()
    public void testCreationContact() {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("bbb").withLastname("aaa").withGroup("[none]");
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);

    }
}





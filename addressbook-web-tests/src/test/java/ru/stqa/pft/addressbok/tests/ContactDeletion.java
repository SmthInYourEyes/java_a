package ru.stqa.pft.addressbok.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbok.model.ContactData;
import ru.stqa.pft.addressbok.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletion extends TestBase {

    @Test()
    public void testContactDeletion() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstname("ffg").withLastname("ggt").withGroup("[none]"));
            {
            }
        }
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedContact)));
    }


}

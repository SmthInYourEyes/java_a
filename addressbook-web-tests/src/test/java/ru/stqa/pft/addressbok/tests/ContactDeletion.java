package ru.stqa.pft.addressbok.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbok.model.ContactData;
import ru.stqa.pft.addressbok.model.GroupData;

import java.util.Set;

public class ContactDeletion extends TestBase {

    @Test()
    public void testContactDeletion() {
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData().withFirstname("ffg").withLastname("ggt").withGroup("[none]"));
            {}
        }
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }


}

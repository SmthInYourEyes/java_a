package ru.stqa.pft.addressbok.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbok.model.ContactData;


import java.util.List;

public class ContactDeletion extends TestBase {

    @Test()
    public void testContactDeletion() {
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData().withFirstname("ffg").withLastname("ggt"));
            {
            }
        }
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(index);
        Assert.assertEquals(before, after);
    }


}

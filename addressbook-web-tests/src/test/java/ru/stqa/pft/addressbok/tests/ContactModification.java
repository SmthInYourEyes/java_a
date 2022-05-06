package ru.stqa.pft.addressbok.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbok.model.ContactData;
import java.util.Set;

public class ContactModification extends TestBase {


    @BeforeMethod
    public void ensureContactPreconditions() {
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData().withFirstname("nnnn").withLastname("gttr")
                    .withGroup("[none]"));
        }
        app.contact().home();
    }

        @Test()
        public void testContactModification() {
            Set<ContactData> before = app.contact().all();
            ContactData modifiedContact = before.iterator().next();
            ContactData contact = new ContactData().withFirstname("ppp").withLastname("hhh");
            app.contact().modify(contact);
            Set<ContactData> after = app.contact().all();
            Assert.assertEquals(after.size(), before.size());

            before.remove(modifiedContact);
            before.add(contact);
            Assert.assertEquals(before, after);


        }

    }

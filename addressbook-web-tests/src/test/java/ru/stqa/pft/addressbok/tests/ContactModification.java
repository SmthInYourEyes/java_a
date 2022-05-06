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
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData().withFirstname("nnnn").withLastname("gttr")
                    .withGroup("[none]"));
        }
        app.contact().home();
    }

        @Test()
        public void testContactModification() {
            List<ContactData> before = app.contact().list();
            int index = before.size() - 1;
            ContactData contact = new ContactData().withFirstname("ppp").withLastname("hhh");
            app.contact().modify(index, contact);
            List<ContactData> after = app.contact().list();
            Assert.assertEquals(after.size(), before.size());

            before.remove(index);
            before.add(contact);
            Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);


        }

    }

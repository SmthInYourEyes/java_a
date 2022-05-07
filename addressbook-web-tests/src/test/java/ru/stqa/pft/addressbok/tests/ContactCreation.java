package ru.stqa.pft.addressbok.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbok.model.ContactData;
import ru.stqa.pft.addressbok.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreation extends TestBase {


    @Test
    public void testCreationContact() {
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/123.png");
        ContactData contact = new ContactData()
                .withFirstname("bbb").withLastname("aaa").withGroup("[none]").withPhoto(photo);
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(
                contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}





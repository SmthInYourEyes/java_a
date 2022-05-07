package ru.stqa.pft.addressbok.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbok.model.ContactData;
import ru.stqa.pft.addressbok.model.Contacts;
import ru.stqa.pft.addressbok.model.Groups;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {super(wd);}

    public void initContactCreation(ContactData contact) {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactModification(int id) {  wd.findElement(By.xpath(String.
            format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    private void selectContactById(int id) {wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void home() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());



        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByValue(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void create(ContactData contact) {
        home();
        initContactCreation(contact);
        fillContactForm((contact), true);
        submitContactCreation();
        contactCache = null;
        home();
    }
    public ContactData infoFromEditForm(ContactData contact) {
        initContactModification(contact.getId());
        String firstname =wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname =wd.findElement(By.name("lastname")).getAttribute("value");
        String home =wd.findElement(By.name("home")).getAttribute("value");
        String mobile =wd.findElement(By.name("mobile")).getAttribute("value");
        String work =wd.findElement(By.name("work")).getAttribute("value");
        String address =wd.findElement(By.name("address")).getAttribute("value");
        String email1 =wd.findElement(By.name("email")).getAttribute("value");
        String email2 =wd.findElement(By.name("email2")).getAttribute("value");
        String email3 =wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home)
                .withWorkPhone(work).withMobilePhone(mobile).withAddress(address).withEmail1(email1).withEmail2(email2)
                .withEmail3(email3);
    }


    public void modify(ContactData contact) {
        home();
        //selectContact(index);
        initContactModification(contact.getId());
        fillContactForm(contact,false);
        submitContactModification();
        contactCache = null;
        home();
    }

    public void delete(ContactData contact) {
       home();
       //selectContactById(contact.getId());
       initContactModification(contact.getId());
       deleteSelectedContacts();
       contactCache = null;
       home();
    }



    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> list() {
        List <ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//*[@id='maintable']/tbody/tr[@name = 'entry']"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath("td[3]")).getText();
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            ContactData contact = new ContactData().withFirstname(firstname).withLastname(lastname);
            contacts.add(contact);
        }
        return contacts;

    }


    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }

        contactCache= new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(1).getText();
            String lastname = cells.get(2).getText();
            String address = cells.get(3).getText();
            String[] emails = cells.get(4).getText().split("\n");
            String[] phones = cells.get(5).getText().split("\n");
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address)
                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2])
                    .withEmail1(emails[0]).withEmail2(emails[1]).withEmail3(emails[2]));
        }
        return new Contacts(contactCache);

    }
}




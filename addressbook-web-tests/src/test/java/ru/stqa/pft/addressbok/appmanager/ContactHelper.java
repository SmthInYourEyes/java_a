package ru.stqa.pft.addressbok.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbok.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void initContactCreation(ContactData contact) {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void goToHomePage() {
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

    public void createContact(ContactData contact) {
        initContactCreation(contact);
        fillContactForm((contact), true);
        submitContactCreation();
    }

    public void modifyContact(int index,ContactData contact) {
      selectContact(index);
        initContactModification();
        fillContactForm(contact,false);
        submitContactModification();
       goToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> getContactList() {
        List <ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//*[@id='maintable']/tbody/tr[@name = 'entry']"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath("td[3]")).getText();
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, firstname, lastname, null);
            contacts.add(contact);
        }
        return contacts;

    }
}




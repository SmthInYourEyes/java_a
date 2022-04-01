package ru.stqa.pft.addressbok.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbok.model.ContactData;

public class ContactHelper extends HelperBase {



    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstname());
        type(By.name("lastname"), contactData.lastname());
        type(By.name("home"), contactData.homephone());
        type(By.name("address"), contactData.address());
        type(By.name("email"), contactData.email());
    }
}

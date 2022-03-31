package ru.stqa.pft.addressbok.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbok.model.ContactData;
import ru.stqa.pft.addressbok.tests.TestBase;

public class CreationContact extends TestBase {


  @Test
  public void testCreationContact() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("aaa", "bbb", "77444777555", "67mmppyy5", "ggghht@tu.com"));
    app.submitContactCreation();
    app.goToHomePage();
  }
}





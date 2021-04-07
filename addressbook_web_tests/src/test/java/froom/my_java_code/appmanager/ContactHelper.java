package froom.my_java_code.appmanager;

import froom.my_java_code.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void initContactCreation() {
    click(By.xpath("//*[@id='content']/form/input[1]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void selectContact(int index) {
    driver.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactDeletion() {
    click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
  }

  public void confirmAlert() {
    new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();
  }

  public void initContactModification(int index) {
    WebElement webElement = driver.findElements(By.name("entry")).get(index);
    webElement.findElement(By.cssSelector(":nth-child(8)")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void createContact(ContactData contactData, boolean b) {
    goToAddNewContact();
    initContactCreation();
    fillContactForm(contactData, b);
    submitContactCreation();
    goToHomePage();
  }

  public boolean isContactPresent() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<WebElement> elements = driver.findElements(By.name("entry"));
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (WebElement element : elements) {
      String name = element.findElement(By.cssSelector(":nth-child(3)")).getText();
      String address = element.findElement(By.cssSelector(":nth-child(4)")).getText();
      String email = element.findElement(By.cssSelector(":nth-child(5) > a")).getText();
      String phone = element.findElement(By.cssSelector(":nth-child(6)")).getText();
      ContactData contactData = new ContactData(name, address, phone, email, null);
      contacts.add(contactData);
    }
    return contacts;
  }
}

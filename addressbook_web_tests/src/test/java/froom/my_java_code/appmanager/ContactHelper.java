package froom.my_java_code.appmanager;

import froom.my_java_code.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void initContactDeletion() {
    click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
  }

  public void confirmAlert() {
    new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();
  }

  private void selectContactByID(int id) {
    click(By.cssSelector(String.format("input[id='%s']", id)));
  }

  private void initContactModificationById(int id) {
    click(By.xpath(String.format("//input[@id='%s']/../../td[8]/a", id)));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void createContact(ContactData contactData) {
    goToAddNewContact();
    initContactCreation();
    fillContactForm(contactData, true);
    submitContactCreation();
    goToHomePage();
  }

  public void deleteContact(ContactData contact) {
    selectContactByID(contact.getId());
    initContactDeletion();
    confirmAlert();
    goToHomePage();
  }

  public void modifyContact(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    goToHomePage();
  }

  public Set<ContactData> getContactSet() {
    List<WebElement> elements = driver.findElements(By.name("entry"));
    Set<ContactData> contacts = new HashSet<ContactData>();
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.xpath("./td[1]/input")).getAttribute("id"));
      String name = element.findElement(By.xpath("./td[3]")).getText();
      String address = element.findElement(By.xpath("./td[4]")).getText();
      String email = element.findElement(By.xpath("./td[5]/a")).getText();
      String phones = element.findElement(By.xpath("./td[6]")).getText();
      ContactData contactData = new ContactData().withId(id).withName(name).withAddress(address).withEmail(email).withPhones(phones);
      contacts.add(contactData);
    }
    return contacts;
  }

  public ContactData getContactDataFromModifyForm(ContactData entryContact) {
    initContactModificationById(entryContact.getId());
    String name = driver.findElement(By.name("firstname")).getAttribute("value");
    String address = driver.findElement(By.name("address")).getAttribute("value");
    String homePhone = driver.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = driver.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = driver.findElement(By.name("work")).getAttribute("value");
    String email = driver.findElement(By.name("email")).getAttribute("value");
    goToHomePage();
    return new ContactData()
            .withId(entryContact.getId()).withName(name).withAddress(address)
            .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone).withEmail(email);
  }
}

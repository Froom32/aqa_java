package froom.my_java_code.appmanager;

import froom.my_java_code.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void initContactCreation() {
    click(By.xpath("//*[@id='content']/form/input[1]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmail());
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactDeletion() {
    click(By.xpath("//*[@id='content']/form[2]/div[2]/input"));
  }

  public void confirmAlert() {
    new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[8]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }
}

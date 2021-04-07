package froom.my_java_code.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void click(By locator) {
    driver.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = driver.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
      }
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void goToGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && driver.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    } else {
      click(By.xpath("//*[@id='nav']/ul/li[3]/a"));
    }
  }

  public void goToAddNewContact() {
    if (isElementPresent(By.tagName("h1"))
            && driver.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPresent(By.name("quickadd"))) {
      return;
    } else {
      click(By.xpath("//*[@id='nav']/ul/li[2]/a"));
    }
  }

  public void goToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    } else {
      click(By.xpath("//*[@id='nav']/ul/li[1]/a"));
    }
  }

}

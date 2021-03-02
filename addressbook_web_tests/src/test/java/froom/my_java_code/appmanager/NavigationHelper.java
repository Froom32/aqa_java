package froom.my_java_code.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToGroupPage() {
    click(By.xpath("//*[@id='nav']/ul/li[3]/a"));
  }

  public void goToAddNewContact() {
    click(By.xpath("//*[@id='nav']/ul/li[2]/a"));
  }

  public void goHome() {
    click(By.xpath("//*[@id='nav']/ul/li[1]/a"));
  }
}

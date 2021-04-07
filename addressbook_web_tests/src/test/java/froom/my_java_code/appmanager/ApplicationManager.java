package froom.my_java_code.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {
  WebDriver driver;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private String browser;

  public void init() {
    if (browser.equals(BrowserType.CHROME)) {
      driver = new ChromeDriver();
    } else if (browser.equals(BrowserType.EDGE)) {
      driver = new EdgeDriver();
    }
    driver.manage().window().maximize();
    groupHelper = new GroupHelper(driver);
    sessionHelper = new SessionHelper(driver);
    contactHelper = new ContactHelper(driver);
    driver.get("http://localhost/addressbook/");
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    driver.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}

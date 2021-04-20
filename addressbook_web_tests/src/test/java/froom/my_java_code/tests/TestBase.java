package froom.my_java_code.tests;

import froom.my_java_code.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeSuite
  public void setup() {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}

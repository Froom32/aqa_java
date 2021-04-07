package froom.my_java_code.tests;

import froom.my_java_code.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeClass
  public void setup() {
    app.init();
  }

  @AfterClass
  public void tearDown() {
    app.stop();
  }

}

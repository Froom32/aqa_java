package froom.my_java_code.tests;

import froom.my_java_code.models.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goHome();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Olha", "Dinsova", "Konstantinovskaya street, h.24, r.2", "+380445489122", "random@gmail.com"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goHome();
  }
}

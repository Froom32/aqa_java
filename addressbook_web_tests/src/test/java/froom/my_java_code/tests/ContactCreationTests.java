package froom.my_java_code.tests;

import froom.my_java_code.models.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goHome();
    app.getNavigationHelper().goToAddNewContact();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Mike", "Bilyk", "prospect Oleksandrovskiy, h.111, r.21", "+380952492290", "bilikmike@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goHome();
  }
}

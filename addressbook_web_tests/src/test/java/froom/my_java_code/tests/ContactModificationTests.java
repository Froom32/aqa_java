package froom.my_java_code.tests;

import froom.my_java_code.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().goToHomePage();
    if (! app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("Mike Bilyk", "prospect Oleksandrovskiy, h.111, r.21", "+380952492290", "bilikmike@gmail.com", "Wolves"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contactData = new ContactData("Dinsova", "Konstantinovskaya street, h.24, r.2", "+380445489122", "random@gmail.com", null);
    app.getContactHelper().fillContactForm(contactData, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    before.remove(before.size() - 1);
    before.add(contactData);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}

package froom.my_java_code.tests;

import froom.my_java_code.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contactData = new ContactData("Mike Bilyk", "prospect Oleksandrovskiy, h.111, r.21", "+380952492290", "bilikmike@gmail.com", "Bears");
    app.getContactHelper().createContact(contactData, true);
    List<ContactData> after = app.getContactHelper().getContactList();

    before.add(contactData);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}

package froom.my_java_code.tests;

import froom.my_java_code.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().goToHomePage();
    if (! app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("Mike Bilyk", "prospect Oleksandrovskiy, h.111, r.21", "+380952492290", "bilikmike@gmail.com", "Wolves"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().initContactDeletion();
    app.getContactHelper().confirmAlert();
    app.getContactHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    before.remove(0);
    Assert.assertEquals(before, after);
  }

}

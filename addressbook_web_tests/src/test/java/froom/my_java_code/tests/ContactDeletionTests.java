package froom.my_java_code.tests;

import froom.my_java_code.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void preconditionContactDeletion() {
    app.getContactHelper().goToHomePage();
    if (app.getContactHelper().getContactSet().size() == 0) {
      app.getContactHelper().createContact(
              new ContactData().withName("Mike Bilyk").withAddress("prospect Oleksandrovskiy, h.111, r.21")
                      .withMobilePhone("+380952492290").withEmail("bilikmike@gmail.com").withGroup("Wolves"));
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() {
    Set<ContactData> before = app.getContactHelper().getContactSet();
    ContactData deletedContact = before.iterator().next();
    app.getContactHelper().deleteContact(deletedContact);
    Set<ContactData> after = app.getContactHelper().getContactSet();

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }

}

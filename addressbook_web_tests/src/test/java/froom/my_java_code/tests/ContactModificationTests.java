package froom.my_java_code.tests;

import froom.my_java_code.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class ContactModificationTests extends TestBase {

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
  public void testContactCreation() {
    Set<ContactData> before = app.getContactHelper().getContactSet();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact =
            new ContactData().withId(modifiedContact.getId()).withName("Dinsova").withAddress("Konstantinovskaya street, h.24, r.2")
                    .withMobilePhone("+380445489122").withEmail("random@gmail.com");
    app.getContactHelper().modifyContact(contact);
    Set<ContactData> after = app.getContactHelper().getContactSet();

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}

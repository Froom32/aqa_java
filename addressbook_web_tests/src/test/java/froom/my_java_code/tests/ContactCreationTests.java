package froom.my_java_code.tests;

import froom.my_java_code.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() {
    app.getContactHelper().goToHomePage();
    Set<ContactData> before = app.getContactHelper().getContactSet();
    ContactData contact =
            new ContactData().withName("Mike Bilyk").withAddress("prospect Oleksandrovskiy, h.111, r.21")
                    .withMobilePhone("+380952492290").withEmail("bilikmike@gmail.com").withGroup("Bears");
    app.getContactHelper().createContact(contact);
    Set<ContactData> after = app.getContactHelper().getContactSet();

    before.add(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()));
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}

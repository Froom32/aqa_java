package froom.my_java_code.tests;

import froom.my_java_code.models.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTest extends TestBase {

  @BeforeMethod
  public void preconditionContactDeletion() {
    app.getContactHelper().goToHomePage();
    if (app.getContactHelper().getContactSet().size() == 0) {
      app.getContactHelper().createContact(
              new ContactData().withName("Mike Bilyk").withAddress("prospect Oleksandrovskiy, h.111, r.21")
                      .withMobilePhone("+380952492290").withEmail("bilikmike@gmail.com").withGroup("Wolves"));
    }
  }

  @Test
  public void testContactPhone() {
    ContactData contact = app.getContactHelper().getContactSet().iterator().next();
    ContactData contactDataFromModifyForm = app.getContactHelper().getContactDataFromModifyForm(contact);

    assertThat(contact.getHomePhone(), equalTo(cleaner(contactDataFromModifyForm.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaner(contactDataFromModifyForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaner(contactDataFromModifyForm.getWorkPhone())));
  }

  private String cleaner(String phone) {
    return phone.replaceAll("\s", "").replaceAll("[-()]", "");
  }

}

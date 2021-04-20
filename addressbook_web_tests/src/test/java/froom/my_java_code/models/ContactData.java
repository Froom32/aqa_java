package froom.my_java_code.models;

import java.util.Objects;

public class ContactData {

  private String name;
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String email;
  private String group;
  private int id;
  private String phones;

  public int getId() {
    return id;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getPhones() {
    return phones;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withPhones(String phones) {
    this.phones = phones;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, mobilePhone, email, id);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", email='" + email + '\'' +
            ", id=" + id +
            '}';
  }

}

package froom.my_java_code.appmanager;

import froom.my_java_code.models.GroupData;
import froom.my_java_code.models.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  public void returnToGroupPage() {
    if (isElementPresent(By.xpath("//*[@id='content']/div/i/a"))) {
      click(By.xpath("//*[@id='content']/div/i/a"));
    } else goToGroupPage();
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getGroupName());
    type(By.name("group_header"), groupData.getGroupHeader());
    type(By.name("group_footer"), groupData.getGroupFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroupByID(int id) {
    driver.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("submit"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupsCash = null;
    returnToGroupPage();
  }

  public void deleteGroup(GroupData group) {
    selectGroupByID(group.getGroupID());
    deleteSelectedGroups();
    groupsCash = null;
    returnToGroupPage();
  }

  public void modifyGroup(GroupData group) {
    selectGroupByID(group.getGroupID());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupsCash = null;
    returnToGroupPage();
  }

  public int getGroupCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

  private Groups groupsCash = null;

  public Groups getGroupSet() {
    List<WebElement> elements = driver.findElements(By.name("selected[]"));
    if (groupsCash != null) {
      return new Groups(groupsCash);
    }
    groupsCash = new Groups();
    for (WebElement element : elements) {
      String dirtyName = element.getAttribute("title");
      String name = dirtyName.substring(8, dirtyName.length() - 1);
      int id = Integer.parseInt(element.getAttribute("value"));
      GroupData groupData = new GroupData().withID(id).withName(name);
      groupsCash.add(groupData);
    }
    return new Groups(groupsCash);
  }
}

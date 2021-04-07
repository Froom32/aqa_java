package froom.my_java_code.tests;

import froom.my_java_code.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getGroupHelper().goToGroupPage();
    if (! app.getGroupHelper().isGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData(0,"Wolves", "the best group ever", "really the best"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData groupData = new GroupData(before.get(before.size() - 1).getGroupID(),"Foxes", "the worst group ever", "really the worst");
    app.getGroupHelper().fillGroupForm(groupData);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();

    before.remove(before.size() - 1);
    before.add(groupData);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}

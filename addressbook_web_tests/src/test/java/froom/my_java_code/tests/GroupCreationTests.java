package froom.my_java_code.tests;

import froom.my_java_code.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getGroupHelper().goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData groupData = new GroupData(0,"Bears", "the best group ever", "really the best");
    app.getGroupHelper().createGroup(groupData);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    groupData.setGroupID(after.stream().max(Comparator.comparingInt(GroupData::getGroupID)).get().getGroupID());
    before.add(groupData);
    before.sort(Comparator.comparing(GroupData::getGroupID));
    after.sort(Comparator.comparing(GroupData::getGroupID));
    Assert.assertEquals(before, after);
  }

}

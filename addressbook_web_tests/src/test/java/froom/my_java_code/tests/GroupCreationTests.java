package froom.my_java_code.tests;

import froom.my_java_code.models.GroupData;
import froom.my_java_code.models.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getGroupHelper().goToGroupPage();
    Groups before = app.getGroupHelper().getGroupSet();
    GroupData group = new GroupData().withName("Bears").withHeader("the best group ever").withFooter("really the best");
    app.getGroupHelper().createGroup(group);
    assertThat(app.getGroupHelper().getGroupCount(), equalTo(before.size() + 1));
    Groups after = app.getGroupHelper().getGroupSet();
    assertThat(after, equalTo(
            before.withAdded(group.withID(after.stream().mapToInt(GroupData::getGroupID).max().getAsInt()))));
  }

  @Test
  public void testGroupCreationNegative() {
    app.getGroupHelper().goToGroupPage();
    Groups before = app.getGroupHelper().getGroupSet();
    GroupData group = new GroupData().withName("Bears'").withHeader("the best group ever").withFooter("really the best");
    app.getGroupHelper().createGroup(group);
    assertThat(app.getGroupHelper().getGroupCount(), equalTo(before.size()));
    Groups after = app.getGroupHelper().getGroupSet();
    assertThat(after, equalTo(before));
  }

}

package froom.my_java_code.tests;

import froom.my_java_code.models.GroupData;
import froom.my_java_code.models.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  private void preconditionGroupCreation() {
    app.getGroupHelper().goToGroupPage();
    if (app.getGroupHelper().getGroupSet().size() == 0) {
      app.getGroupHelper().createGroup(new GroupData().withName("Bears").withHeader("the best group ever").withFooter("really the best"));
    }
  }

  @Test(enabled = false)
  public void testGroupModification() {
    Groups before = app.getGroupHelper().getGroupSet();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group =
            new GroupData().withID(modifiedGroup.getGroupID()).withName("Foxes").withHeader("the worst group ever").withFooter("really the worst");
    app.getGroupHelper().modifyGroup(group);
    Groups after = app.getGroupHelper().getGroupSet();
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
  }

}

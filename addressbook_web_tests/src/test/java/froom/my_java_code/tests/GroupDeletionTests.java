package froom.my_java_code.tests;

import froom.my_java_code.models.GroupData;
import froom.my_java_code.models.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  private void preconditionGroupDeletion() {
    app.getGroupHelper().goToGroupPage();
    if (app.getGroupHelper().getGroupSet().size() == 0) {
      app.getGroupHelper().createGroup(new GroupData().withName("Bears").withHeader("the best group ever").withFooter("really the best"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.getGroupHelper().getGroupSet();
    GroupData group = before.iterator().next();
    app.getGroupHelper().deleteGroup(group);
    assertThat(app.getGroupHelper().getGroupCount(), equalTo(before.size() - 1));
    Groups after = app.getGroupHelper().getGroupSet();
    assertThat(after, equalTo(before.withOut(group)));
  }
}

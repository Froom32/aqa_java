package froom.my_java_code.models;

import java.util.Objects;

public class GroupData {
  private final String groupName;
  private final String groupHeader;
  private final String groupFooter;
  private int groupID;

  public GroupData(int groupID, String groupName, String groupHeader, String groupFooter) {
    this.groupID = groupID;
    this.groupName = groupName;
    this.groupHeader = groupHeader;
    this.groupFooter = groupFooter;
  }

  public int getGroupID() {
    return groupID;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getGroupHeader() {
    return groupHeader;
  }

  public String getGroupFooter() {
    return groupFooter;
  }

  public void setGroupID(int groupID) {
    this.groupID = groupID;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "groupName='" + groupName + '\'' +
            ", groupID=" + groupID +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return groupID == groupData.groupID && Objects.equals(groupName, groupData.groupName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupName, groupID);
  }
}

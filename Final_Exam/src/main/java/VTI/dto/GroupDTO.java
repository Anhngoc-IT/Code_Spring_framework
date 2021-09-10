package VTI.dto;

import java.util.Date;

import VTI.entity.Group;
import VTI.entity.User;

public class GroupDTO {
	
	private short groupId;

	private String groupName;

	private int member;

	private Date createDate;

	private User user;


//	public GroupDTO(short groupId, String groupName, int member, Date createDate, User user) {
//		super();
//		this.groupId = groupId;
//		this.groupName = groupName;
//		this.member = member;
//		this.createDate = createDate;
//		this.user = user;
//	}

	public GroupDTO(short groupId, String groupName, int member, User user, Date createDate) {
		
			super();
			this.groupId = groupId;
			this.groupName = groupName;
			this.member = member;
			this.createDate = createDate;
			this.user = user;
	}

	public short getGroupId() {
		return groupId;
	}

	public void setGroupId(short groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "GroupDTO [groupName=" + groupName + ", member=" + member + ", createDate=" + createDate + ", user="
				+ user + "]";
	}

	public Group convertToGroup() {
		return new Group((short) 0, groupName, member, createDate, user);
	}

	

}

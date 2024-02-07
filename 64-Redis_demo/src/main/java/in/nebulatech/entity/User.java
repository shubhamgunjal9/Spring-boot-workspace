package in.nebulatech.entity;

import java.io.Serializable;

public class User implements Serializable {
	
	private int userId;
	private String userName;
	private String course;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public User(int userId, String userName, String course) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.course = course;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", course=" + course + "]";
	}

	
}

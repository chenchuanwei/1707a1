package com.bawei.bean;

/**
 * @author ccw
 *
 * 2019年11月5日
 */
public class User {

	private Integer uid;  //primary key auto_increment,
	private String uname; //varchar(50) unique,
	private String pwd; //varchar(50),
	private String nickname; //varchar(50),
	private String birthday;
	private Integer gender;
	private Integer locked;
	private String created; //date,
	private String updated; //date,
	private String picture; //varchar(255)
	
	public User(Integer uid, String uname, String pwd, String nickname, String birthday, Integer gender, Integer locked,
			String created, String updated, String picture) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
		this.nickname = nickname;
		this.birthday = birthday;
		this.gender = gender;
		this.locked = locked;
		this.created = created;
		this.updated = updated;
		this.picture = picture;
	}
	public User() {
		super();
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + ", nickname=" + nickname + ", birthday="
				+ birthday + ", gender=" + gender + ", locked=" + locked + ", created=" + created + ", updated="
				+ updated + ", picture=" + picture + "]";
	}
	
	
}

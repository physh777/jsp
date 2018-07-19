package com.test.jsp.vo;

public class UserInfo {
	private int num;
	private String id;
	private String pwd;
	private String name;
	private String hobby;
	private String trans;
	private String address;
	private int dpNum;
	
	public int getDpNum() {
		return dpNum;
	}
	public void setDpNum(int dpNum) {
		this.dpNum = dpNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserInfo [num=" + num + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", hobby=" + hobby
				+ ", trans=" + trans + ", address=" + address + ", dpNum=" + dpNum + "]";
	}
	
}

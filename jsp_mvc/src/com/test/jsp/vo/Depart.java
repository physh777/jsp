package com.test.jsp.vo;

public class Depart {
	private int dpNum;
	private String dpName;
	private String dpDesc;
	private String visible;
	private int cnt;
	
	public int getDpNum() {
		return dpNum;
	}
	public void setDpNum(int dpNum) {
		this.dpNum = dpNum;
	}
	public String getDpName() {
		return dpName;
	}
	public void setDpName(String dpName) {
		this.dpName = dpName;
	}
	public String getDpDesc() {
		return dpDesc;
	}
	public void setDpDesc(String dpDesc) {
		this.dpDesc = dpDesc;
	}
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Depart [dpNum=" + dpNum + ", dpName=" + dpName + ", dpDesc=" + dpDesc + ", visible=" + visible
				+ ", cnt=" + cnt + "]";
	}
}

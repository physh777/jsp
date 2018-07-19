package com.test.jsp.vo;

public class Board {

	private int bNum;
	private String bTitle;
	private String bText;
	private int uNum;
	private String bCredat;
	private String bCretim;
	private int bModusr;
	private String bModdat;
	private String bModtim;
	private char visible;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbText() {
		return bText;
	}
	public void setbText(String bText) {
		this.bText = bText;
	}
	public int getuNum() {
		return uNum;
	}
	public void setuNum(int uNum) {
		this.uNum = uNum;
	}
	public String getbCredat() {
		return bCredat;
	}
	public void setbCredat(String bCredat) {
		this.bCredat = bCredat;
	}
	public String getbCretim() {
		return bCretim;
	}
	public void setbCretim(String bCretim) {
		this.bCretim = bCretim;
	}
	public int getbModusr() {
		return bModusr;
	}
	public void setbModusr(int bModusr) {
		this.bModusr = bModusr;
	}
	public String getbModdat() {
		return bModdat;
	}
	public void setbModdat(String bModdat) {
		this.bModdat = bModdat;
	}
	public String getbModtim() {
		return bModtim;
	}
	public void setbModtim(String bModtim) {
		this.bModtim = bModtim;
	}
	public char getVisible() {
		return visible;
	}
	public void setVisible(char visible) {
		this.visible = visible;
	}
	@Override
	public String toString() {
		return "Board [bNum=" + bNum + ", bTitle=" + bTitle + ", bText=" + bText + ", uNum=" + uNum + ", bCredat="
				+ bCredat + ", bCretim=" + bCretim + ", bModusr=" + bModusr + ", bModdat=" + bModdat + ", bModtim="
				+ bModtim + ", visible=" + visible + ", userName=" + userName + "]";
	}

}

package com.shop.pojo;

import java.io.Serializable;

public class TbShop implements Serializable {
    private Integer sid;

    private String imgpath;

    private String lname;

    private String name;

    private String content;

    private String price;

    private String kc;

    private String zt;
    
    
    
    private Integer num;
    private String sjname;
    private String tel;
    private String address;
	public TbShop(Integer sid, String imgpath, String lname, String name, String content, String price, String kc,
			String zt, Integer num, String sjname, String tel, String address) {
		super();
		this.sid = sid;
		this.imgpath = imgpath;
		this.lname = lname;
		this.name = name;
		this.content = content;
		this.price = price;
		this.kc = kc;
		this.zt = zt;
		this.num = num;
		this.sjname = sjname;
		this.tel = tel;
		this.address = address;
	}
	public TbShop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getKc() {
		return kc;
	}
	public void setKc(String kc) {
		this.kc = kc;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getSjname() {
		return sjname;
	}
	public void setSjname(String sjname) {
		this.sjname = sjname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "TbShop [sid=" + sid + ", imgpath=" + imgpath + ", lname=" + lname + ", name=" + name + ", content="
				+ content + ", price=" + price + ", kc=" + kc + ", zt=" + zt + ", num=" + num + ", sjname=" + sjname
				+ ", tel=" + tel + ", address=" + address + "]";
	}
    
}
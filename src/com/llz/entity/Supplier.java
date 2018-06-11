package com.llz.entity;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午9:32:03
 * @name 供货商实体类
 */

public class Supplier {
	private int id;
	private String sname;
	private String tel;
	private String rname;
	private String email;
	private String address;

	public Supplier() {
		super();
	}

	public Supplier(String sname, String tel, String rname, String email,
			String address) {
		super();
		this.sname = sname;
		this.tel = tel;
		this.rname = rname;
		this.email = email;
		this.address = address;
	}

	public Supplier(int id, String sname, String tel, String rname,
			String email, String address) {
		super();
		this.id = id;
		this.sname = sname;
		this.tel = tel;
		this.rname = rname;
		this.email = email;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", sname=" + sname + ", tel=" + tel
				+ ", rname=" + rname + ", email=" + email + ", address="
				+ address + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

package com.llz.entity;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午9:30:57
 * @name 客户实体类
 */

public class Client {
	private int id;
	private String cname;
	private String tel;
	private String rname;
	private String email;
	private String address;

	public Client() {
		super();
	}

	public Client(String cname, String tel, String rname, String email,
			String address) {
		super();
		this.cname = cname;
		this.tel = tel;
		this.rname = rname;
		this.email = email;
		this.address = address;
	}

	public Client(int id, String cname, String tel, String rname, String email,
			String address) {
		super();
		this.id = id;
		this.cname = cname;
		this.tel = tel;
		this.rname = rname;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

	@Override
	public String toString() {
		return "Client [id=" + id + ", cname=" + cname + ", tel=" + tel
				+ ", rname=" + rname + ", email=" + email + ", address="
				+ address + "]";
	}

}

package com.llz.entity;

/**
 * @author lilingzhi
 * @date 2017年5月11日 下午2:17:14
 * @name 用户实体类
 */

public class User {
	private int id;
	private String name;
	private String pass;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}

	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public User() {
	}

	public User(int id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}

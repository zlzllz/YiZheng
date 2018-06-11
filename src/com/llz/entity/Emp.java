package com.llz.entity;

/**
 * @author lilingzhi
 * @date 2017年5月3日 上午11:52:47
 * @name 职工实体类
 */

import java.sql.Date;

public class Emp {
	private int id;
	private Dept dept;
	private String ename;
	private String sex;
	private int age;
	private String tel;
	private String job;
	private Date time;

	public Emp() {
		super();
	}

	public Emp(Dept dept, String ename, String sex, int age, String tel,
			String job) {
		super();
		this.dept = dept;
		this.ename = ename;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.job = job;
	}

	public Emp(int id, Dept dept, String ename, String sex, int age,
			String tel, String job) {
		super();
		this.id = id;
		this.dept = dept;
		this.ename = ename;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.job = job;
	}
	
	public Emp(int id, Dept dept, String ename, String sex, int age,
			String tel, String job, Date time) {
		super();
		this.id = id;
		this.dept = dept;
		this.ename = ename;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.job = job;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", dept=" + dept + ", ename=" + ename
				+ ", sex=" + sex + ", age=" + age + ", tel=" + tel + ", job="
				+ job + ", time=" + time + "]";
	}
	
}

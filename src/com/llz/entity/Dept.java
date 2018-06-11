package com.llz.entity;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午11:36:19
 * @name 部门实体类
 */

public class Dept {
	private int id;
	private String dname;
	private double salary;

	public Dept() {
	}

	public Dept(String dname, double salary) {
		this.dname = dname;
		this.salary = salary;
	}

	public Dept(int id, String dname, double salary) {
		super();
		this.id = id;
		this.dname = dname;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Dept [id=" + id + ", dname=" + dname + ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

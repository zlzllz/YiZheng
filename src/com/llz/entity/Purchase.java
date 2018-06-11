package com.llz.entity;

/**
 * @author lilingzhi
 * @date 2017年5月3日 下午3:44:47
 * @name 进货商实体类
 */

import java.util.Date;

public class Purchase {
	private int id;
	private Supplier supplier;
	private Emp emp;
	private String jname;//进货商名称
	private int num;
	private double price;
	private Date time;

	public Purchase() {
		super();
	}

	// ���
	public Purchase(Supplier supplier, Emp emp, String jname, int num, double price) {
		super();
		this.supplier = supplier;
		this.emp = emp;
		this.jname = jname;
		this.num = num;
		this.price = price;
	}
	
	// ����
	public Purchase(int id, Supplier supplier, Emp emp, String jname, int num,
			double price) {
		super();
		this.id = id;
		this.supplier = supplier;
		this.emp = emp;
		this.jname = jname;
		this.num = num;
		this.price = price;
	}

	public Purchase(int id, Supplier supplier, Emp emp, String jname, int num,
			double price, Date time) {
		super();
		this.id = id;
		this.supplier = supplier;
		this.emp = emp;
		this.jname = jname;
		this.num = num;
		this.price = price;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", supplier=" + supplier + ", emp=" + emp
				+ ", jname=" + jname + ", num=" + num + ", price=" + price
				+ ", time=" + time + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}

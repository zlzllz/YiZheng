package com.llz.entity;

/**
 * @author lilingzhi
 * @date 2017年5月3日 下午3:17:31
 * @name 订单实体类
 */

import java.util.Date;

public class Order {
	private int id;
	private Client client;
	private Product product;
	private Emp emp;
	private int num;
	private int status;
	private Date time;
	private int ispay;
	private double pay;

	public Order() {
		super();
	}

	// ���
	public Order(Client client, Product product, Emp emp, int num, double pay) {
		super();
		this.client = client;
		this.product = product;
		this.emp = emp;
		this.num = num;
		this.pay = pay;
	}

	// ����
	public Order(int id, Client client, Product product, Emp emp, int num,
			int status, int ispay, double pay) {
		super();
		this.id = id;
		this.client = client;
		this.product = product;
		this.emp = emp;
		this.num = num;
		this.status = status;
		this.ispay = ispay;
		this.pay = pay;
	}

	public Order(int id, Client client, Product product, Emp emp, int num,
			int status, Date time, int ispay, double pay) {
		super();
		this.id = id;
		this.client = client;
		this.product = product;
		this.emp = emp;
		this.num = num;
		this.status = status;
		this.time = time;
		this.ispay = ispay;
		this.pay = pay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getIspay() {
		return ispay;
	}

	public void setIspay(int ispay) {
		this.ispay = ispay;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", client=" + client + ", product="
				+ product + ", emp=" + emp + ", num=" + num + ", status="
				+ status + ", time=" + time + ", ispay=" + ispay + ", pay="
				+ pay + "]";
	}

}

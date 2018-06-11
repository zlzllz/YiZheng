package com.llz.entity;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午9:31:29
 * @name 商品实体类
 */

public class Product {
	private int id;
	private String pname;
	private String type;
	private String unit;
	private String img;
	private double price;

	public Product() {
		super();
	}

	public Product(String pname, String type, String unit, String img,
			double price) {
		super();
		this.pname = pname;
		this.type = type;
		this.unit = unit;
		this.img = img;
		this.price = price;
	}

	public Product(int id, String pname, String type, String unit, String img,
			double price) {
		super();
		this.id = id;
		this.pname = pname;
		this.type = type;
		this.unit = unit;
		this.img = img;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", type=" + type
				+ ", unit=" + unit + ", img=" + img + ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

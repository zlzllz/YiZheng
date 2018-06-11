package com.llz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.llz.dao.ProductDao;
import com.llz.entity.Product;

/**
 * @author lilingzhi
 * @date 2017年5月15日 上午9:27:14
 */

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

	// 获取全部商品信息
	@Override
	public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from zproduct";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Product d = new Product();
				d.setId(rs.getInt("id"));
				d.setPname(rs.getString("pname"));
				d.setType(rs.getString("typee"));
				d.setUnit(rs.getString("unit"));
				d.setImg(rs.getString("img"));
				d.setPrice(rs.getDouble("price"));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过ID获取商品信息
	@Override
	public Product getById(int id) {
		Product p = null;
		String sql = "select * from zproduct where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setPname(rs.getString("pname"));
				p.setType(rs.getString("typee"));
				p.setUnit(rs.getString("unit"));
				p.setImg(rs.getString("img"));
				p.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	// 通过商品名称获取商品信息
	@Override
	public List<Product> getByPname(String name) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from zproduct where pname like '%" + name + "%'";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setPname(rs.getString("pname"));
				p.setType(rs.getString("typee"));
				p.setUnit(rs.getString("unit"));
				p.setImg(rs.getString("img"));
				p.setPrice(rs.getDouble("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 通过商品名称获取商品信息
		@Override
		public Product getByPname1(String name) {
			Product p = null;
			String sql = "select * from zproduct where pname =?";
			List<Object> objs = new ArrayList<Object>();
			objs.add(name);
			try {
				rs = super.executeQuery(sql, objs);
				while (rs.next()) {
					p = new Product();
					p.setId(rs.getInt("id"));
					p.setPname(rs.getString("pname"));
					p.setType(rs.getString("typee"));
					p.setUnit(rs.getString("unit"));
					p.setImg(rs.getString("img"));
					p.setPrice(rs.getDouble("price"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p;
		}

	// 通过类型获取商品信息
	@Override
	public List<Product> getByType(String type) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from zproduct where typee = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(type);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setPname(rs.getString("pname"));
				p.setType(rs.getString("typee"));
				p.setUnit(rs.getString("unit"));
				p.setImg(rs.getString("img"));
				p.setPrice(rs.getDouble("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 新增商品信息
	@Override
	public int save(Product product) {
		String sql = "insert into zproduct(pname,typee,unit,img,price) values(?,?,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(product.getPname());
		objs.add(product.getType());
		objs.add(product.getUnit());
		objs.add(product.getImg());
		objs.add(product.getPrice());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 更新商品信息
	@Override
	public int update(Product product) {
		String sql = "update zproduct set pname=?,typee=?,unit=?,img=?,price=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(product.getPname());
		objs.add(product.getType());
		objs.add(product.getUnit());
		objs.add(product.getImg());
		objs.add(product.getPrice());
		objs.add(product.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 删除商品信息
	@Override
	public int delete(Product product) {
		String sql = "delete from zproduct where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(product.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	@Override
	public List<Product> getPname() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select pname from zproduct group by pname";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Product d = new Product();
				d.setPname(rs.getString("pname"));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

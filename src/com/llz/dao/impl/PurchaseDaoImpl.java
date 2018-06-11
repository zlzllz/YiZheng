package com.llz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.llz.dao.EmpDao;
import com.llz.dao.PurchaseDao;
import com.llz.dao.SupplierDao;
import com.llz.entity.Emp;
import com.llz.entity.Purchase;
import com.llz.entity.Supplier;

/**
 * @author lilingzhi
 * @date 2017年5月15日 上午9:27:13
 */

public class PurchaseDaoImpl extends BaseDaoImpl implements PurchaseDao {

	SupplierDao sdao = new SupplierDaoImpl();
	EmpDao edao = new EmpDaoImpl();

	// 获取全部进货单信息
	@Override
	public List<Purchase> getAll() {
		List<Purchase> list = new ArrayList<Purchase>();
		String sql = "select * from zpurchase order by timee desc";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Purchase p = new Purchase();
				p.setId(rs.getInt("id"));
				Supplier s = sdao.getById(rs.getInt("s_id"));
				p.setSupplier(s);
				Emp e = edao.getById(rs.getInt("e_id"));
				p.setEmp(e);
				p.setJname(rs.getString("jname"));
				p.setNum(rs.getInt("num"));
				p.setPrice(rs.getDouble("price"));
				p.setTime(rs.getDate("timee"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过ID获取进货单信息
	@Override
	public Purchase getById(int id) {
		Purchase p = null;
		String sql = "select * from zpurchase where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				p = new Purchase();
				p.setId(rs.getInt("id"));
				Supplier s = sdao.getById(rs.getInt("s_id"));
				p.setSupplier(s);
				Emp e = edao.getById(rs.getInt("e_id"));
				p.setEmp(e);
				p.setJname(rs.getString("jname"));
				p.setNum(rs.getInt("num"));
				p.setPrice(rs.getDouble("price"));
				p.setTime(rs.getDate("timee"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	// 通过进货单ID获取进货单信息
	@Override
	public List<Purchase> getByS_id(int id) {
		List<Purchase> list = new ArrayList<Purchase>();
		String sql = "select * from zpurchase where s_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Purchase p = new Purchase();
				p.setId(rs.getInt("id"));
				Supplier s = sdao.getById(rs.getInt("s_id"));
				p.setSupplier(s);
				Emp e = edao.getById(rs.getInt("e_id"));
				p.setEmp(e);
				p.setJname(rs.getString("jname"));
				p.setNum(rs.getInt("num"));
				p.setPrice(rs.getDouble("price"));
				p.setTime(rs.getDate("timee"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过职工ID获取进货单信息
	@Override
	public List<Purchase> getByE_id(int id) {
		List<Purchase> list = new ArrayList<Purchase>();
		String sql = "select * from zpurchase where e_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Purchase p = new Purchase();
				p.setId(rs.getInt("id"));
				Supplier s = sdao.getById(rs.getInt("s_id"));
				p.setSupplier(s);
				Emp e = edao.getById(rs.getInt("e_id"));
				p.setEmp(e);
				p.setJname(rs.getString("jname"));
				p.setNum(rs.getInt("num"));
				p.setPrice(rs.getDouble("price"));
				p.setTime(rs.getDate("timee"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过进货商品名称获取进货单信息
	@Override
	public List<Purchase> getByJname(String name) {
		List<Purchase> list = new ArrayList<Purchase>();
		String sql = "select * from zpurchase where jname = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(name);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Purchase p = new Purchase();
				p.setId(rs.getInt("id"));
				Supplier s = sdao.getById(rs.getInt("s_id"));
				p.setSupplier(s);
				Emp e = edao.getById(rs.getInt("e_id"));
				p.setEmp(e);
				p.setJname(rs.getString("jname"));
				p.setNum(rs.getInt("num"));
				p.setPrice(rs.getDouble("price"));
				p.setTime(rs.getDate("timee"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过日期获取进货单信息
	@Override
	public List<Purchase> getByDate(String date) {
		List<Purchase> list = new ArrayList<Purchase>();
		List<Object> objs = new ArrayList<Object>();
		String sql;
		if (date.length() > 10) {
			String[] sdate = date.split("-");
			
			String[] s1 = sdate[0].split("/");
			if(s1[0].length()==1){
				s1[0] = "0" + s1[0];
			}
			if(s1[1].length()==1){
				s1[1] = "0" + s1[1];
			}
			s1[2] = s1[2].trim();
			String t1 = s1[2] + "-" + s1[0] + "-" + s1[1];
			
			String[] s2 = sdate[1].split("/");
			if(s2[0].trim().length()==1){
				s2[0] = "0" + s2[0].trim();
			}
			if(s2[1].length()==1){
				s2[1] = "0" + s2[1];
			}
			s2[2] = s2[2].trim();
			String t2 = s2[2] + "-" + s2[0] + "-" + s2[1];
			
			sql = "select * from zpurchase where to_char(timee,'yyyy-mm-dd') between ? and ?";
			objs.add(t1);
			objs.add(t2);
		} else {
			String[] s = date.split("/");
			if(s[0].length()==1){
				s[0] = "0" + s[0];
			}
			if(s[1].length()==1){
				s[1] = "0" + s[1];
			}
			String t = s[2] + "-" + s[0] + "-" + s[1];
			sql = "select * from zpurchase where to_char(timee,'yyyy-mm-dd') = ?";
			objs.add(t);
		}
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Purchase p = new Purchase();
				p.setId(rs.getInt("id"));
				Supplier s = sdao.getById(rs.getInt("s_id"));
				p.setSupplier(s);
				Emp e = edao.getById(rs.getInt("e_id"));
				p.setEmp(e);
				p.setJname(rs.getString("jname"));
				p.setNum(rs.getInt("num"));
				p.setPrice(rs.getDouble("price"));
				p.setTime(rs.getDate("timee"));
				list.add(p);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	// 新增进货单信息
	@Override
	public int save(Purchase purchase) {
		String sql = "insert into zpurchase(s_id,e_id,jname,num,price)"
				+ "values(?,?,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(purchase.getSupplier().getId());
		objs.add(purchase.getEmp().getId());
		objs.add(purchase.getJname());
		objs.add(purchase.getNum());
		objs.add(purchase.getPrice());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 更新进货单信息
	@Override
	public int update(Purchase purchase) {
		String sql = "update zpurchase set s_id=?,e_id=?,jname=?,num=?,price=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(purchase.getSupplier().getId());
		objs.add(purchase.getEmp().getId());
		objs.add(purchase.getJname());
		objs.add(purchase.getNum());
		objs.add(purchase.getPrice());
		objs.add(purchase.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 删除进货单信息
	@Override
	public int delete(Purchase purchase) {
		String sql = "delete from zpurchase where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(purchase.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

}

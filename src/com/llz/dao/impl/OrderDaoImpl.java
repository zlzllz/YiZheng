package com.llz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.llz.dao.ClientDao;
import com.llz.dao.EmpDao;
import com.llz.dao.OrderDao;
import com.llz.dao.ProductDao;
import com.llz.entity.Client;
import com.llz.entity.Emp;
import com.llz.entity.Order;
import com.llz.entity.Product;

/**
 * @author lilingzhi
 * @date 2017年5月15日 上午9:27:14
 */

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

	ClientDao cdao = new ClientDaoImpl();
	ProductDao pdao = new ProductDaoImpl();
	EmpDao edao = new EmpDaoImpl();

	// 获取全部订单信息
	@Override
	public List<Order> getAll() {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from zorder order by timee desc";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Client c = cdao.getById(rs.getInt("c_id"));
				o.setClient(c);
				Product p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Emp e = edao.getById(rs.getInt("e_id"));
				o.setEmp(e);
				o.setNum(rs.getInt("num"));
				o.setStatus(rs.getInt("status"));
				o.setTime(rs.getDate("timee"));
				o.setIspay(rs.getInt("ispay"));
				o.setPay(rs.getDouble("pay"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过ID获取订单信息
	@Override
	public Order getById(int id) {
		Order o = null;
		String sql = "select * from zorder where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				o = new Order();
				o.setId(rs.getInt("id"));
				Client c = cdao.getById(rs.getInt("c_id"));
				o.setClient(c);
				Product p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Emp e = edao.getById(rs.getInt("e_id"));
				o.setEmp(e);
				o.setNum(rs.getInt("num"));
				o.setStatus(rs.getInt("status"));
				o.setTime(rs.getDate("timee"));
				o.setIspay(rs.getInt("ispay"));
				o.setPay(rs.getDouble("pay"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

	// 通过客户获取订单信息
	@Override
	public List<Order> getByC_id(int id) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from zorder where c_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Client c = cdao.getById(rs.getInt("c_id"));
				o.setClient(c);
				Product p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Emp e = edao.getById(rs.getInt("e_id"));
				o.setEmp(e);
				o.setNum(rs.getInt("num"));
				o.setStatus(rs.getInt("status"));
				o.setTime(rs.getDate("timee"));
				o.setIspay(rs.getInt("ispay"));
				o.setPay(rs.getDouble("pay"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过商品获取订单信息
	@Override
	public List<Order> getByP_id(int id) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from zorder where p_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Client c = cdao.getById(rs.getInt("c_id"));
				o.setClient(c);
				Product p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Emp e = edao.getById(rs.getInt("e_id"));
				o.setEmp(e);
				o.setNum(rs.getInt("num"));
				o.setStatus(rs.getInt("status"));
				o.setTime(rs.getDate("timee"));
				o.setIspay(rs.getInt("ispay"));
				o.setPay(rs.getDouble("pay"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过职工获取订单信息
	@Override
	public List<Order> getByE_id(int id) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from zorder where e_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Client c = cdao.getById(rs.getInt("c_id"));
				o.setClient(c);
				Product p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Emp e = edao.getById(rs.getInt("e_id"));
				o.setEmp(e);
				o.setNum(rs.getInt("num"));
				o.setStatus(rs.getInt("status"));
				o.setTime(rs.getDate("timee"));
				o.setIspay(rs.getInt("ispay"));
				o.setPay(rs.getDouble("pay"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过状态获取订单信息
	@Override
	public List<Order> getByStatus(int status) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from zorder where status = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(status);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Client c = cdao.getById(rs.getInt("c_id"));
				o.setClient(c);
				Product p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Emp e = edao.getById(rs.getInt("e_id"));
				o.setEmp(e);
				o.setNum(rs.getInt("num"));
				o.setStatus(rs.getInt("status"));
				o.setTime(rs.getDate("timee"));
				o.setIspay(rs.getInt("ispay"));
				o.setPay(rs.getDouble("pay"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过是否支付获取订单信息
	@Override
	public List<Order> getByIspay(int pay) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from zorder where ispay = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(pay);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Client c = cdao.getById(rs.getInt("c_id"));
				o.setClient(c);
				Product p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Emp e = edao.getById(rs.getInt("e_id"));
				o.setEmp(e);
				o.setNum(rs.getInt("num"));
				o.setStatus(rs.getInt("status"));
				o.setTime(rs.getDate("timee"));
				o.setIspay(rs.getInt("ispay"));
				o.setPay(rs.getDouble("pay"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过下单日期获取订单信息
	@Override
	public List<Order> getByDate(String date) {
		List<Order> list = new ArrayList<Order>();
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
			
			sql = "select * from zorder where to_char(timee,'yyyy-mm-dd') between ? and ?";
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
			sql = "select * from zorders where to_char(timee,'yyyy-mm-dd') = ?";
			objs.add(t);
		}
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt("id"));
				Client c = cdao.getById(rs.getInt("c_id"));
				o.setClient(c);
				Product p = pdao.getById(rs.getInt("p_id"));
				o.setProduct(p);
				Emp e = edao.getById(rs.getInt("e_id"));
				o.setEmp(e);
				o.setNum(rs.getInt("num"));
				o.setStatus(rs.getInt("status"));
				o.setTime(rs.getDate("timee"));
				o.setIspay(rs.getInt("ispay"));
				o.setPay(rs.getDouble("pay"));
				list.add(o);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	// 新增订单信息
	@Override
	public int save(Order o) {
		String sql = "insert into zorder(c_id,p_id,e_id,num,status,ispay,pay) "
				+ "values(?,?,?,?,default,default,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(o.getClient().getId());
		objs.add(o.getProduct().getId());
		objs.add(o.getEmp().getId());
		objs.add(o.getNum());
		objs.add(o.getPay());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 更新订单信息
	@Override
	public int update(Order o) {
		String sql = "update zorder set c_id=?,p_id=?,e_id=?,num=?,status=?,ispay=?,pay=? where id=? ";
		List<Object> objs = new ArrayList<Object>();
		objs.add(o.getClient().getId());
		objs.add(o.getProduct().getId());
		objs.add(o.getEmp().getId());
		objs.add(o.getNum());
		objs.add(o.getStatus());
		objs.add(o.getIspay());
		objs.add(o.getPay());
		objs.add(o.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 删除订单信息
	@Override
	public int delete(Order o) {
		String sql = "delete from zorder where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(o.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

}

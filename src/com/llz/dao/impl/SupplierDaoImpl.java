package com.llz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.llz.dao.SupplierDao;
import com.llz.entity.Supplier;

/**
 * @author lilingzhi
 * @date 2017年5月11日 上午9:27:13
 */

public class SupplierDaoImpl extends BaseDaoImpl implements SupplierDao {

	// 获取全部供货商信息
	@Override
	public List<Supplier> getAll() {
		List<Supplier> list = new ArrayList<Supplier>();
		String sql = "select * from zsupplier";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Supplier s = new Supplier();
				s.setId(rs.getInt("id"));
				s.setSname(rs.getString("sname"));
				s.setTel(rs.getString("tel"));
				s.setRname(rs.getString("rname"));
				s.setEmail(rs.getString("email"));
				s.setAddress(rs.getString("address"));
				list.add(s);// �ǵ����
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过ID获取供货商信息
	@Override
	public Supplier getById(int id) {
		Supplier s = null;
		String sql = "select * from zsupplier where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				s = new Supplier();
				s.setId(rs.getInt("id"));
				s.setSname(rs.getString("sname"));
				s.setTel(rs.getString("tel"));
				s.setRname(rs.getString("rname"));
				s.setEmail(rs.getString("email"));
				s.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	// 通过供货商名称获取供货商信息
	@Override
	public Supplier getBySname1(String name) {
		Supplier s = null;
		String sql = "select * from zsupplier where sname = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(name);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				s = new Supplier();
				s.setId(rs.getInt("id"));
				s.setSname(rs.getString("sname"));
				s.setTel(rs.getString("tel"));
				s.setRname(rs.getString("rname"));
				s.setEmail(rs.getString("email"));
				s.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	// 通过供货商名称获取供货商信息
		@Override
		public List<Supplier> getBySname(String name) {
			List<Supplier> list = new ArrayList<Supplier>();
			String sql = "select * from zsupplier where sname LIKE '%"+name+"%'";
			try {
				rs = super.executeQuery(sql, null);
				while (rs.next()) {
					Supplier s = new Supplier();
					s.setId(rs.getInt("id"));
					s.setSname(rs.getString("sname"));
					s.setTel(rs.getString("tel"));
					s.setRname(rs.getString("rname"));
					s.setEmail(rs.getString("email"));
					s.setAddress(rs.getString("address"));
					list.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}

	// 通过联系人获取供货商信息
	@Override
	public List<Supplier> getByRname(String name) {
		List<Supplier> list = new ArrayList<Supplier>();
		String sql = "select * from zsupplier where rname LIKE '%"+name+"%'";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Supplier s = new Supplier();
				s.setId(rs.getInt("id"));
				s.setSname(rs.getString("sname"));
				s.setTel(rs.getString("tel"));
				s.setRname(rs.getString("rname"));
				s.setEmail(rs.getString("email"));
				s.setAddress(rs.getString("address"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过地址获取供货商信息
	@Override
	public List<Supplier> getByAddress(String address) {
		List<Supplier> list = new ArrayList<Supplier>();
		String sql = "select * from zsupplier where address LIKE '%"+address+"%'";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Supplier s = new Supplier();
				s.setId(rs.getInt("id"));
				s.setSname(rs.getString("sname"));
				s.setTel(rs.getString("tel"));
				s.setRname(rs.getString("rname"));
				s.setEmail(rs.getString("email"));
				s.setAddress(rs.getString("address"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过邮件获取供货商信息
	@Override
	public Supplier getByEmail(String email) {
		Supplier s = null;
		String sql = "select * from zsupplier where email = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(email);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				s = new Supplier();
				s.setId(rs.getInt("id"));
				s.setSname(rs.getString("sname"));
				s.setTel(rs.getString("tel"));
				s.setRname(rs.getString("rname"));
				s.setEmail(rs.getString("email"));
				s.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	// 保存供货商信息
	@Override
	public int save(Supplier supplier) {
		String sql = "insert into zsupplier(sname,tel,rname,email,address) values(?,?,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(supplier.getSname());
		objs.add(supplier.getTel());
		objs.add(supplier.getRname());
		objs.add(supplier.getEmail());
		objs.add(supplier.getAddress());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 更新供货商信息
	@Override
	public int update(Supplier supplier) {
		String sql = "update zsupplier set sname=?,tel=?,rname=?,email=?,address=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(supplier.getSname());
		objs.add(supplier.getTel());
		objs.add(supplier.getRname());
		objs.add(supplier.getEmail());
		objs.add(supplier.getAddress());
		objs.add(supplier.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 删除供货商信息
	@Override
	public int delete(Supplier supplier) {
		String sql = "delete from zsupplier where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(supplier.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}
}

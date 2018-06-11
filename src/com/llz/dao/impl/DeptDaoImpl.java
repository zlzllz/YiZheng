package com.llz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.llz.dao.DeptDao;
import com.llz.entity.Dept;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午11:38:41
 */

public class DeptDaoImpl  extends BaseDaoImpl implements DeptDao{

	// 获取全部部门信息
	@Override
	public List<Dept> getAll() {
		List<Dept> list = new ArrayList<Dept>();
		String sql = "select * from zdept";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Dept d = new Dept();
				d.setId(rs.getInt("id"));
				d.setDname(rs.getString("dname"));
				d.setSalary(rs.getDouble("salary"));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过ID获取部门信息
	@Override
	public Dept getById(int id) {
		Dept d = null;
		String sql = "select * from zdept where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				d = new Dept();
				d.setId(rs.getInt("id"));
				d.setDname(rs.getString("dname"));
				d.setSalary(rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	// 通过部门名称获取部门信息
	@Override
	public Dept getByDname(String name) {
		Dept d = null;
		String sql = "select * from zdept where dname = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(name);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				d = new Dept();
				d.setId(rs.getInt("id"));
				d.setDname(rs.getString("dname"));
				d.setSalary(rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	// 新增部门信息
	@Override
	public int save(Dept dept) {
		String sql = "insert into zdept(dname,salary) values(?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(dept.getDname());
		objs.add(dept.getSalary());
		num = super.executeUpdate(sql,objs);
		return num;
	}

	// 更新部门信息
	@Override
	public int update(Dept dept) {
		String sql = "update zdept set dname =?,salary=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(dept.getDname());
		objs.add(dept.getSalary());
		objs.add(dept.getId());
		num = super.executeUpdate(sql,objs);
		return num;
	}

	// 删除部门信息
	@Override
	public int delete(Dept dept) {
		String sql = "delete from zdept where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(dept.getId());
		num = super.executeUpdate(sql, objs);		
		return num;
	}

}

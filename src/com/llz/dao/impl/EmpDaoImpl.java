package com.llz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.llz.dao.DeptDao;
import com.llz.dao.EmpDao;
import com.llz.entity.Dept;
import com.llz.entity.Emp;

/**
 * @author lilingzhi
 * @date 2017年5月11日 下午2:19:54
 */

public class EmpDaoImpl extends BaseDaoImpl implements EmpDao {
	DeptDao ddao = new DeptDaoImpl();

	// 获取全部职工信息
	@Override
	public List<Emp> getAll() {
		List<Emp> list = new ArrayList<Emp>();
		String sql = "select * from zemp";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt("id"));
				Dept d = ddao.getById(rs.getInt("d_id"));
				e.setDept(d);
				e.setEname(rs.getString("ename"));
				e.setSex(rs.getString("sex"));
				e.setAge(rs.getInt("age"));
				e.setTel(rs.getString("tel"));
				e.setJob(rs.getString("jobb"));
				e.setTime(rs.getDate("timee"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过ID获取职工信息
	@Override
	public Emp getById(int id) {
		Emp e = null;
		String sql = "select * from zemp where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				e = new Emp();
				e.setId(rs.getInt("id"));
				Dept d = ddao.getById(rs.getInt("d_id"));
				e.setDept(d);
				e.setEname(rs.getString("ename"));
				e.setSex(rs.getString("sex"));
				e.setAge(rs.getInt("age"));
				e.setTel(rs.getString("tel"));
				e.setJob(rs.getString("jobb"));
				e.setTime(rs.getDate("timee"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}
	
	// 通过性别获取职工信息
		@Override
		public List<Emp> getBySex(String sex) {
			List<Emp> list = new ArrayList<Emp>();
			String sql = "select * from zemp where sex = ?";
			List<Object> objs = new ArrayList<Object>();
			objs.add(sex);
			try {
				rs = super.executeQuery(sql, objs);
				while (rs.next()) {
					Emp e = new Emp();
					e.setId(rs.getInt("id"));
					Dept d = ddao.getById(rs.getInt("d_id"));
					e.setDept(d);
					e.setEname(rs.getString("ename"));
					e.setSex(rs.getString("sex"));
					e.setAge(rs.getInt("age"));
					e.setTel(rs.getString("tel"));
					e.setJob(rs.getString("jobb"));
					e.setTime(rs.getDate("timee"));
					list.add(e);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return list;
		}

	// 通过部门名称获取职工信息
	@Override
	public List<Emp> getByDname(String dname) {
		int d_id = ddao.getByDname(dname).getId();
		List<Emp> list = new ArrayList<Emp>();
		String sql = "select * from zemp where d_id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(d_id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Emp e = new Emp();
				e = new Emp();
				e.setId(rs.getInt("id"));
				Dept d = ddao.getById(rs.getInt("d_id"));
				e.setDept(d);
				e.setEname(rs.getString("ename"));
				e.setSex(rs.getString("sex"));
				e.setAge(rs.getInt("age"));
				e.setTel(rs.getString("tel"));
				e.setJob(rs.getString("jobb"));
				e.setTime(rs.getDate("timee"));
				list.add(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	// 通过职工姓名获取职工信息
	@Override
	public List<Emp> getByEname(String name) {
		List<Emp> list = new ArrayList<Emp>();
		String sql = "select * from zemp where ename LIKE '%" + name + "%'";
		// List<Object> objs = new ArrayList<Object>();
		// objs.add(name);
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt("id"));
				Dept d = ddao.getById(rs.getInt("d_id"));
				e.setDept(d);
				e.setEname(rs.getString("ename"));
				e.setSex(rs.getString("sex"));
				e.setAge(rs.getInt("age"));
				e.setTel(rs.getString("tel"));
				e.setJob(rs.getString("jobb"));
				e.setTime(rs.getDate("timee"));
				list.add(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
	// 通过职工姓名获取职工信息
	@Override
	public Emp getByEname1(String name) {
		Emp e = null;
		String sql = "select * from zemp where ename = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(name);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				e = new Emp();
				e.setId(rs.getInt("id"));
				Dept d = ddao.getById(rs.getInt("d_id"));
				e.setDept(d);
				e.setEname(rs.getString("ename"));
				e.setSex(rs.getString("sex"));
				e.setAge(rs.getInt("age"));
				e.setTel(rs.getString("tel"));
				e.setJob(rs.getString("jobb"));
				e.setTime(rs.getDate("timee"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	// 通过职位获取职工信息
	@Override
	public List<Emp> getByJob(String job) {
		List<Emp> list = new ArrayList<Emp>();
		String sql = "select * from zemp where jobb = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(job);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt("id"));
				Dept d = ddao.getById(rs.getInt("d_id"));
				e.setDept(d);
				e.setEname(rs.getString("ename"));
				e.setSex(rs.getString("sex"));
				e.setAge(rs.getInt("age"));
				e.setTel(rs.getString("tel"));
				e.setJob(rs.getString("jobb"));
				e.setTime(rs.getDate("timee"));
				list.add(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	// 通过日期获取职工信息
	@Override
	public List<Emp> getByDate(String date) {
		List<Emp> list = new ArrayList<Emp>();
		List<Object> objs = new ArrayList<Object>();
		String sql;
		if (date.length() > 10) {
			// 4/30/2017 - 5/7/2017
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
			
			sql = "select * from zemp where to_char(timee,'yyyy-mm-dd') between ? and ?";
			objs.add(t1);
			objs.add(t2);
		} else {
			// 精确日期查询
			String[] s = date.split("/");
			if(s[0].length()==1){
				s[0] = "0" + s[0];
			}
			if(s[1].length()==1){
				s[1] = "0" + s[1];
			}
			String t = s[2] + "-" + s[0] + "-" + s[1];
			sql = "select * from zemp where to_char(timee,'yyyy-mm-dd') = ?";
			objs.add(t);
		}
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				Emp e = new Emp();
				e = new Emp();
				e.setId(rs.getInt("id"));
				Dept d = ddao.getById(rs.getInt("d_id"));
				e.setDept(d);
				e.setEname(rs.getString("ename"));
				e.setSex(rs.getString("sex"));
				e.setAge(rs.getInt("age"));
				e.setTel(rs.getString("tel"));
				e.setJob(rs.getString("jobb"));
				e.setTime(rs.getDate("timee"));
				list.add(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

	// 新增职工信息
	@Override
	public int save(Emp emp) {
		String sql = "insert into zemp(d_id,ename,sex,age,tel,jobb) "
				+ "values(?,?,?,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(emp.getDept().getId());
		objs.add(emp.getEname());
		objs.add(emp.getSex());
		objs.add(emp.getAge());
		objs.add(emp.getTel());
		objs.add(emp.getJob());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 更新职工信息
	@Override
	public int update(Emp emp) {
		String sql = "update zemp set d_id=?,ename=?,sex=?,age=?,tel=?,jobb=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(emp.getDept().getId());
		objs.add(emp.getEname());
		objs.add(emp.getSex());
		objs.add(emp.getAge());
		objs.add(emp.getTel());
		objs.add(emp.getJob());
		objs.add(emp.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 删除职工信息
	@Override
	public int delete(Emp emp) {
		String sql = "delete from zemp where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(emp.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

}

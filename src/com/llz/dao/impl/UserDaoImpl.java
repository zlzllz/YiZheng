package com.llz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.llz.dao.UserDao;
import com.llz.entity.User;

/**
 * @author lilingzhi
 * @date 2017年5月12日 下午2:19:54
 */

public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	// 获取全部管理员信息
	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from zusers";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPass(rs.getString("pass"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过ID获取管理员信息
	@Override
	public User getById(int id) {
		User u = null;
		String sql = "select * from zusers where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPass(rs.getString("pass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	// 通过管理员姓名获取管理员信息
	@Override
	public User getByName(String name) {
		User u = null;
		String sql = "select * from zusers where name = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(name);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPass(rs.getString("pass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	// 新增管理员信息
	@Override
	public int save(User user) {
		String sql = "insert into zusers(name,pass) values(?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(user.getName());
		String password= DigestUtils.md5Hex(user.getPass().getBytes());
		objs.add(password);
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 更新管理员信息
	@Override
	public int update(User user) {
		String sql = "update zusers set name=?,pass=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(user.getName());
		objs.add(user.getPass());
		objs.add(user.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 删除管理员信息
	@Override
	public int delete(User user) {
		String sql = "delete from zusers where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(user.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

}

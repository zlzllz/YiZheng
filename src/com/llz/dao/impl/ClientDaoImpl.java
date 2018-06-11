package com.llz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.llz.dao.ClientDao;
import com.llz.entity.Client;

/**
 * @author lilingzhi
 * @date 2017年5月8日 下午4:07:44
 */

public class ClientDaoImpl extends BaseDaoImpl implements ClientDao {

	@Override
	public List<Client> getAll() {
		List<Client> list = new ArrayList<Client>();
		String sql = "select * from zclient";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setTel(rs.getString("tel"));
				c.setRname(rs.getString("rname"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过ID获取客户信息
	@Override
	public Client getById(int id) {
		Client c = null;
		String sql = "select * from zclient where id = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(id);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				c = new Client();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setTel(rs.getString("tel"));
				c.setRname(rs.getString("rname"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	// 通过客户名获取客户信息
	@Override
	public List<Client> getByCname(String name) {
		List<Client> list = new ArrayList<Client>();
		String sql = "select * from zclient where cname LIKE '%"+name+"%'";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setTel(rs.getString("tel"));
				c.setRname(rs.getString("rname"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过客户名获取客户信息
	@Override
	public Client getByCname1(String name) {
		Client c = null;
		String sql = "select * from zclient where cname = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(name);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				c = new Client();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setTel(rs.getString("tel"));
				c.setRname(rs.getString("rname"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	// 通过联系人姓名获取客户信息
	@Override
	public List<Client> getByRname(String name) {
		List<Client> list = new ArrayList<Client>();
		String sql = "select * from zclient where rname LIKE '%"+name+"%'";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setTel(rs.getString("tel"));
				c.setRname(rs.getString("rname"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过地址获取客户信息
	@Override
	public List<Client> getByAddress(String address) {
		List<Client> list = new ArrayList<Client>();
		String sql = "select * from zclient where address LIKE '%"+address+"%'";
		try {
			rs = super.executeQuery(sql, null);
			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setTel(rs.getString("tel"));
				c.setRname(rs.getString("rname"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过邮件获取用户信息
	@Override
	public Client getByEmail(String email) {
		Client c = null;
		String sql = "select * from zclient where email = ?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(email);
		try {
			rs = super.executeQuery(sql, objs);
			while (rs.next()) {
				c = new Client();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("cname"));
				c.setTel(rs.getString("tel"));
				c.setRname(rs.getString("rname"));
				c.setEmail(rs.getString("email"));
				c.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	// 新增用户信息
	@Override
	public int save(Client client) {
		String sql = "insert into zclient(cname,tel,rname,email,address) values(?,?,?,?,?)";
		List<Object> objs = new ArrayList<Object>();
		objs.add(client.getCname());
		objs.add(client.getTel());
		objs.add(client.getRname());
		objs.add(client.getEmail());
		objs.add(client.getAddress());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 更新用户信息
	@Override
	public int update(Client client) {
		String sql = "update zclient set cname =?,tel=?,rname=?,email=?,address=? where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(client.getCname());
		objs.add(client.getTel());
		objs.add(client.getRname());
		objs.add(client.getEmail());
		objs.add(client.getAddress());
		objs.add(client.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

	// 删除用户信息
	@Override
	public int delete(Client client) {
		String sql = "delete from zclient where id=?";
		List<Object> objs = new ArrayList<Object>();
		objs.add(client.getId());
		num = super.executeUpdate(sql, objs);
		return num;
	}

}

package com.llz.biz.impl;

import java.util.List;

import com.llz.biz.UserBiz;
import com.llz.dao.UserDao;
import com.llz.dao.impl.UserDaoImpl;
import com.llz.entity.User;

/**
 * @author lilingzhi
 * @date 2017年5月11日 下午2:27:44
 */

public class UserBizImpl implements UserBiz{

	UserDao udao = new UserDaoImpl();
	
	@Override
	public List<User> getAll() {
		return udao.getAll();
	}

	@Override
	public User getById(int id) {
		return udao.getById(id);
	}

	@Override
	public User getByName(String name) {
		return udao.getByName(name);
	}

	@Override
	public int save(User user) {
		return udao.save(user);
	}

	@Override
	public int update(User user) {
		return udao.update(user);
	}

	@Override
	public int delete(User user) {
		return udao.delete(user);
	}

}

package com.llz.dao;

import java.util.List;

import com.llz.entity.User;

/**
 * @author lilingzhi
 * @date 2017年5月11日 下午2:19:54
 */

public interface UserDao {
	
	public List<User> getAll();

	public User getById(int id);

	public User getByName(String name);

	public int save(User user);

	public int update(User user);

	public int delete(User user);
}

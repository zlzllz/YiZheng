package com.llz.biz;

import java.util.List;

import com.llz.entity.User;

/**
 * @author lilingzhi
 * @date 2017年5月11日 下午2:26:14
 */

public interface UserBiz {
	
	public List<User> getAll();

	public User getById(int id);

	public User getByName(String name);

	public int save(User user);

	public int update(User user);

	public int delete(User user);
}

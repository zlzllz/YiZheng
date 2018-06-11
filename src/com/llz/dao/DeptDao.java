package com.llz.dao;

import java.util.List;

import com.llz.entity.Dept;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午10:24:30
 */

public interface DeptDao {

	public List<Dept> getAll();

	public Dept getById(int id);

	public Dept getByDname(String name);

	public int save(Dept dept);

	public int update(Dept dept);

	public int delete(Dept dept);
}

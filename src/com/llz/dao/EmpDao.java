package com.llz.dao;

import java.util.List;

import com.llz.entity.Emp;

/**
 * @author lilingzhi
 * @date 2017年5月3日 下午7:23:38
 */

public interface EmpDao {
	public List<Emp> getAll();

	public Emp getById(int id);
	
	public List<Emp> getBySex(String sex);
	
	public List<Emp> getByDname(String dname);

	public List<Emp> getByEname(String name);
	
	public Emp getByEname1(String name);
	
	public List<Emp> getByJob(String job);
	
	public List<Emp> getByDate(String date);

	public int save(Emp emp);

	public int update(Emp emp);

	public int delete(Emp emp);
}

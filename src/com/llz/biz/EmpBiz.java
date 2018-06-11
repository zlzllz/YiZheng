package com.llz.biz;

import java.util.List;

import com.llz.entity.Emp;

/**
 * @author lilingzhi
 * @date 2017年5月15日 上午9:10:45
 */

public interface EmpBiz {
	
	public List<Emp> getAll();

	public Emp getById(int id);
	
	public int save(Emp emp);
	
	public int update(Emp emp);
	
	public int delete(Emp emp);
	
	public List<Emp> getByDname(String dname);

	public List<Emp> getByEname(String name);
	
	public Emp getByEname1(String name);
	
	public List<Emp> getBySex(String sex);
	
	public List<Emp> getByJob(String job);
	
	public List<Emp> getByDate(String date);

}

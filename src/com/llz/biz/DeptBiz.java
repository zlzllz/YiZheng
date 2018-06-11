package com.llz.biz;

import java.util.List;


import com.llz.entity.Dept;

/**
 * @author lilingzhi
 * @date 2017年5月15日 上午9:09:49
 */

public interface DeptBiz {

	public List<Dept> getAll();

	public Dept getById(int id);

	public Dept getByDname(String name);

	public int save(Dept dept);

	public int update(Dept dept);

	public int delete(Dept dept);
}

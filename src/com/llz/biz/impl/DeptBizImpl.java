package com.llz.biz.impl;

import java.util.List;

import com.llz.biz.DeptBiz;
import com.llz.dao.DeptDao;
import com.llz.dao.impl.DeptDaoImpl;
import com.llz.entity.Dept;

/**
 * @author lilingzhi
 * @date 2017年5月2日 下午3:54:20
 */

public class DeptBizImpl implements DeptBiz{

	DeptDao ddao = new DeptDaoImpl();
	
	@Override
	public List<Dept> getAll() {
		return ddao.getAll();
	}

	@Override
	public Dept getById(int id) {
		return ddao.getById(id);
	}

	@Override
	public Dept getByDname(String name) {
		return ddao.getByDname(name);
	}

	@Override
	public int save(Dept dept) {
		return ddao.save(dept);
	}

	@Override
	public int update(Dept dept) {
		return ddao.update(dept);
	}

	@Override
	public int delete(Dept dept) {
		return ddao.delete(dept);
	}

}

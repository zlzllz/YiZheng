package com.llz.biz.impl;

import java.util.List;

import com.llz.biz.EmpBiz;
import com.llz.dao.EmpDao;
import com.llz.dao.impl.EmpDaoImpl;
import com.llz.entity.Emp;

/**
 * @author lilingzhi
 * @date 2017年5月3日 下午7:24:31
 */

public class EmpBizImpl implements EmpBiz {

	EmpDao edao = new EmpDaoImpl();

	@Override
	public List<Emp> getAll() {
		return edao.getAll();
	}

	@Override
	public Emp getById(int id) {
		return edao.getById(id);
	}

	@Override
	public List<Emp> getByDname(String dname) {
		return edao.getByDname(dname);
	}

	@Override
	public List<Emp> getByEname(String name) {
		return edao.getByEname(name);
	}

	@Override
	public List<Emp> getByJob(String job) {
		return edao.getByJob(job);
	}

	@Override
	public List<Emp> getByDate(String date) {
		return edao.getByDate(date);
	}

	@Override
	public int save(Emp emp) {
		return edao.save(emp);
	}

	@Override
	public int update(Emp emp) {
		return edao.update(emp);
	}

	@Override
	public int delete(Emp emp) {
		return edao.delete(emp);
	}

	@Override
	public List<Emp> getBySex(String sex) {
		return edao.getBySex(sex);
	}

	@Override
	public Emp getByEname1(String name) {
		return edao.getByEname1(name);
	}

}

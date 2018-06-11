package com.llz.biz.impl;

import java.util.List;

import com.llz.biz.SupplierBiz;
import com.llz.dao.SupplierDao;
import com.llz.dao.impl.SupplierDaoImpl;
import com.llz.entity.Supplier;

/**
 * @author lilingzhi
 * @date 2017年5月2日 下午4:07:02
 */

public class SupplierBizImpl implements SupplierBiz {

	SupplierDao sdao = new SupplierDaoImpl();

	@Override
	public List<Supplier> getAll() {
		return sdao.getAll();
	}

	@Override
	public Supplier getById(int id) {
		return sdao.getById(id);
	}

	@Override
	public Supplier getBySname1(String name) {
		return sdao.getBySname1(name);
	}

	@Override
	public List<Supplier> getByRname(String name) {
		return sdao.getByRname(name);
	}

	@Override
	public List<Supplier> getByAddress(String address) {
		return sdao.getByAddress(address);
	}

	@Override
	public Supplier getByEmail(String email) {
		return sdao.getByEmail(email);
	}

	@Override
	public int save(Supplier supplier) {
		return sdao.save(supplier);
	}

	@Override
	public int update(Supplier supplier) {
		return sdao.update(supplier);
	}

	@Override
	public int delete(Supplier supplier) {
		return sdao.delete(supplier);
	}

	@Override
	public List<Supplier> getBySname(String name) {
		return sdao.getBySname(name);
	}

}

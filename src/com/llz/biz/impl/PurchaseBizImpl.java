package com.llz.biz.impl;

import java.util.List;

import com.llz.biz.PurchaseBiz;
import com.llz.dao.PurchaseDao;
import com.llz.dao.impl.PurchaseDaoImpl;
import com.llz.entity.Purchase;

/**
 * @author lilingzhi
 * @date 2017年5月8日 上午9:51:56
 */

public class PurchaseBizImpl implements PurchaseBiz {

	PurchaseDao pdao = new PurchaseDaoImpl();

	@Override
	public List<Purchase> getAll() {
		return pdao.getAll();
	}

	@Override
	public Purchase getById(int id) {
		return pdao.getById(id);
	}

	@Override
	public List<Purchase> getByS_id(int id) {
		return pdao.getByS_id(id);
	}

	@Override
	public List<Purchase> getByE_id(int id) {
		return pdao.getByE_id(id);
	}

	@Override
	public List<Purchase> getByJname(String name) {
		return pdao.getByJname(name);
	}

	@Override
	public List<Purchase> getByDate(String date) {
		return pdao.getByDate(date);
	}

	@Override
	public int save(Purchase purchase) {
		return pdao.save(purchase);
	}

	@Override
	public int update(Purchase purchase) {
		return pdao.update(purchase);
	}

	@Override
	public int delete(Purchase purchase) {
		return pdao.delete(purchase);
	}

}

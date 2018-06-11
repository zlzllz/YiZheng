package com.llz.dao;

import java.util.List;

import com.llz.entity.Purchase;

/**
 * @author lilingzhi
 * @date 2017年5月8日 上午9:51:44
 */

public interface PurchaseDao {
	public List<Purchase> getAll();

	public Purchase getById(int id);
	
	public List<Purchase> getByS_id(int id);
	
	public List<Purchase> getByE_id(int id);

	public List<Purchase> getByJname(String name);
	
	public List<Purchase> getByDate(String date);

	public int save(Purchase purchase);

	public int update(Purchase purchase);

	public int delete(Purchase purchase);
}

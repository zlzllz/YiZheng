package com.llz.biz;

import java.util.List;

import com.llz.entity.Purchase;

/**
 * @author lilingzhi
 * @date 2017年5月8日 上午9:52:04
 */

public interface PurchaseBiz {
	
	public List<Purchase> getAll();

	public Purchase getById(int id);
	
	public int save(Purchase purchase);
	
	public int update(Purchase purchase);
	
	public int delete(Purchase purchase);
	
	public List<Purchase> getByS_id(int id);
	
	public List<Purchase> getByE_id(int id);

	public List<Purchase> getByJname(String name);
	
	public List<Purchase> getByDate(String date);
}

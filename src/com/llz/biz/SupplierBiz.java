package com.llz.biz;

import java.util.List;

import com.llz.entity.Supplier;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午10:37:26
 */

public interface SupplierBiz {

	public List<Supplier> getAll();

	public Supplier getById(int id);

	public Supplier getBySname1(String name);
	
	public List<Supplier> getBySname(String name);
	
	public List<Supplier> getByRname(String name);
	
	public List<Supplier> getByAddress(String address);

	public Supplier getByEmail(String email);

	public int save(Supplier supplier);

	public int update(Supplier supplier);

	public int delete(Supplier supplier);
}

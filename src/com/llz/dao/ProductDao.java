package com.llz.dao;

import java.util.List;

import com.llz.entity.Product;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午10:26:39
 */

public interface ProductDao {
	public List<Product> getAll();

	public Product getById(int id);

	public Product getByPname1(String name);
	
	public List<Product> getByPname(String name);
	
	public List<Product> getByType(String type);

	public int save(Product product);

	public int update(Product product);

	public int delete(Product product);

	public List<Product> getPname();
}

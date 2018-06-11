package com.llz.biz;

import java.util.List;

import com.llz.entity.Product;

/**
 * @author lilingzhi
 * @date 2017年5月3日 下午3:29:15
 */

public interface ProductBiz {
	
	public List<Product> getAll();

	public Product getById(int id);
	
	public int save(Product product);
	
	public int update(Product product);
	
	public int delete(Product product);
	
	public Product getByPname1(String name);

	public List<Product> getByPname(String name);
	
	public List<Product> getByType(String type);

	public List<Product> getPname();
}

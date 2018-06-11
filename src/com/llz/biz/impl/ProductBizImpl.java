package com.llz.biz.impl;

import java.util.List;

import com.llz.biz.ProductBiz;
import com.llz.dao.ProductDao;
import com.llz.dao.impl.ProductDaoImpl;
import com.llz.entity.Product;

/**
 * @author lilingzhi
 * @date 2017年5月2日 下午4:01:33
 */

public class ProductBizImpl implements ProductBiz {

	ProductDao pdao = new ProductDaoImpl();

	@Override
	public List<Product> getAll() {
		return pdao.getAll();
	}

	@Override
	public Product getById(int id) {
		return pdao.getById(id);
	}

	@Override
	public List<Product> getByPname(String name) {
		return pdao.getByPname(name);
	}

	@Override
	public List<Product> getByType(String type) {
		return pdao.getByType(type);
	}

	@Override
	public int save(Product product) {
		return pdao.save(product);
	}

	@Override
	public int update(Product product) {
		return pdao.update(product);
	}

	@Override
	public int delete(Product product) {
		return pdao.delete(product);
	}

	@Override
	public List<Product> getPname() {
		return pdao.getPname();
	}

	@Override
	public Product getByPname1(String name) {
		return pdao.getByPname1(name);
	}

}

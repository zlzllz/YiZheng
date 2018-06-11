package com.llz.dao;

import java.util.List;

import com.llz.entity.Order;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午10:23:53
 */

public interface OrderDao {
	public List<Order> getAll();

	public Order getById(int id);
	
	public List<Order> getByC_id(int id);
	
	public List<Order> getByP_id(int id);
	
	public List<Order> getByE_id(int id);

	public List<Order> getByStatus(int status);// 1/0
	
	public List<Order> getByIspay(int pay);// 1/0
	
	public List<Order> getByDate(String date);

	public int save(Order o);

	public int update(Order o);

	public int delete(Order o);
}

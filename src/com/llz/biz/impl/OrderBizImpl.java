package com.llz.biz.impl;

import java.util.List;

import com.llz.biz.OrderBiz;
import com.llz.dao.OrderDao;
import com.llz.dao.impl.OrderDaoImpl;
import com.llz.entity.Order;

/**
 * @author lilingzhi
 * @date 2017年5月2日 下午3:59:33
 */

public class OrderBizImpl implements OrderBiz{

	OrderDao odao = new OrderDaoImpl();
	
	@Override
	public List<Order> getAll() {
		return odao.getAll();
	}

	@Override
	public Order getById(int id) {
		return odao.getById(id);
	}

	@Override
	public List<Order> getByC_id(int id) {
		return odao.getByC_id(id);
	}

	@Override
	public List<Order> getByP_id(int id) {
		return odao.getByP_id(id);
	}

	@Override
	public List<Order> getByE_id(int id) {
		return odao.getByE_id(id);
	}

	@Override
	public List<Order> getByStatus(int status) {
		return odao.getByStatus(status);
	}

	@Override
	public List<Order> getByIspay(int pay) {
		return odao.getByIspay(pay);
	}

	@Override
	public List<Order> getByDate(String date) {
		return odao.getByDate(date);
	}

	@Override
	public int save(Order o) {
		return odao.save(o);
	}

	@Override
	public int update(Order o) {
		return odao.update(o);
	}

	@Override
	public int delete(Order o) {
		return odao.delete(o);
	}

}

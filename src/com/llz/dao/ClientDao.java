package com.llz.dao;

import java.util.List;

import com.llz.entity.Client;

/**
 * @author lilingzhi
 * @date 2017年5月2日 上午10:24:44
 */

public interface ClientDao {

	public List<Client> getAll();

	public Client getById(int id);

	public List<Client> getByCname(String name);// 模糊查询
	
	public Client getByCname1(String name);// 精确查询
	
	public List<Client> getByRname(String name);
	
	public List<Client> getByAddress(String address);

	public Client getByEmail(String email);

	public int save(Client client);

	public int update(Client client);

	public int delete(Client client);
}

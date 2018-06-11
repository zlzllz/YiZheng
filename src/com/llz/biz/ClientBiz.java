package com.llz.biz;

import java.util.List;



import com.llz.entity.Client;
/**
 * @author lilingzhi
 * @date 2017年5月15日 上午9:08:58
 */

public interface ClientBiz {

	public List<Client> getAll();

	public Client getById(int id);

	public List<Client> getByCname(String name);
	
	public Client getByCname1(String name);// 精确查询
	
	public List<Client> getByRname(String name);
	
	public List<Client> getByAddress(String address);

	public Client getByEmail(String email);// 精确查询

	public int save(Client client);

	public int update(Client client);

	public int delete(Client client);
}

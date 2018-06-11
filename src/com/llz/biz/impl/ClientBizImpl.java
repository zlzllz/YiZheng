package com.llz.biz.impl;

import java.util.List;

import com.llz.biz.ClientBiz;
import com.llz.dao.ClientDao;
import com.llz.dao.impl.ClientDaoImpl;
import com.llz.entity.Client;

/**
 * @author lilingzhi
 * @date 2017年5月2日 下午3:51:59
 */

public class ClientBizImpl implements ClientBiz {

	ClientDao cdao = new ClientDaoImpl();

	@Override
	public List<Client> getAll() {
		return cdao.getAll();
	}

	@Override
	public Client getById(int id) {
		return cdao.getById(id);
	}

	@Override
	public List<Client> getByCname(String name) {
		return cdao.getByCname(name);
	}

	@Override
	public List<Client> getByRname(String name) {
		return cdao.getByRname(name);
	}

	@Override
	public List<Client> getByAddress(String address) {
		return cdao.getByAddress(address);
	}

	@Override
	public Client getByEmail(String email) {
		return cdao.getByEmail(email);
	}

	@Override
	public int save(Client client) {
		return cdao.save(client);
	}

	@Override
	public int update(Client client) {
		return cdao.update(client);
	}

	@Override
	public int delete(Client client) {
		return cdao.delete(client);
	}

	@Override
	public Client getByCname1(String name) {
		return cdao.getByCname1(name);
	}

}

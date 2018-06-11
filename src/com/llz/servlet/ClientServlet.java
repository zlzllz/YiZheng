package com.llz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.biz.ClientBiz;
import com.llz.biz.impl.ClientBizImpl;
import com.llz.entity.Client;
import com.llz.utils.InputCheck;

/**
 * @author lilingzhi
 * @date 2017年5月11日 上午9:28:28
 */

public class ClientServlet extends BaseServlet {
	ClientBiz cBiz = new ClientBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		cBiz.save(setValue(request, response));
		url = "/ClientServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Client> list = (List<Client>) cBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Client c = setValue(request, response);
		c.setId(id);
		cBiz.update(c);
		List<Client> list = (List<Client>) cBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Client c = new Client();
		c.setId(id);
		cBiz.delete(c);
		List<Client> list = (List<Client>) cBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	// 通过ID获取客户信息
	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Client> list = new ArrayList<Client>();
		String str = request.getParameter("param");
		if(InputCheck.ckeckInt(str)){
			int id = Integer.parseInt(str);
			list.add(cBiz.getById(id));
		}
		goShow(request, response, list);
		return url;
	}

	// 通过客户名获取客户信息
	public Object getByCname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String cname = request.getParameter("param");
		List<Client> list = cBiz.getByCname(cname);
		goShow(request, response, list);
		return url;
	}

	// 通过联系人姓名获取客户信息
	public Object getByRname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String rname = request.getParameter("param");
		List<Client> list = cBiz.getByRname(rname);
		goShow(request, response, list);
		return url;
	}

	// 通过地址获取客户信息
	public Object getByAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String address = request.getParameter("param");
		List<Client> list = cBiz.getByAddress(address);
		goShow(request, response, list);
		return url;
	}

	// 通过邮件获取用户信息
	public Object getByEmail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String email = request.getParameter("param");
		List<Client> list = new ArrayList<Client>();
		list.add(cBiz.getByEmail(email));
		goShow(request, response, list);
		return url;
	}

	public Client setValue(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String cname = request.getParameter("cname");
		String tel = request.getParameter("tel");
		String rname = request.getParameter("rname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		Client c = new Client(cname, tel, rname, email, address);
		return c;
	}

	public void goShow(HttpServletRequest request,
			HttpServletResponse response, List<Client> list)
			throws ServletException, IOException, SQLException {
		request.setAttribute("clients", list);
		url = request.getRequestDispatcher("/zclient/show.jsp");
	}
}

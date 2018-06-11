package com.llz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.g;

import com.llz.biz.ClientBiz;
import com.llz.biz.EmpBiz;
import com.llz.biz.OrderBiz;
import com.llz.biz.ProductBiz;
import com.llz.biz.UserBiz;
import com.llz.biz.impl.ClientBizImpl;
import com.llz.biz.impl.EmpBizImpl;
import com.llz.biz.impl.OrderBizImpl;
import com.llz.biz.impl.ProductBizImpl;
import com.llz.biz.impl.UserBizImpl;
import com.llz.entity.Client;
import com.llz.entity.Emp;
import com.llz.entity.Order;
import com.llz.entity.Product;
import com.llz.entity.User;
import com.llz.utils.InputCheck;

/**
 * @author lilingzhi
 * @date 2017年5月8日 上午11:57:24
 */

public class OrderServlet extends BaseServlet {
	OrderBiz oBiz = new OrderBizImpl();
	ClientBiz cBiz = new ClientBizImpl();
	ProductBiz pBiz = new ProductBizImpl();
	UserBiz uBiz = new UserBizImpl();
	EmpBiz eBiz = new EmpBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		oBiz.save(setValue(request, response));
		url = "/OrderServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		List<Order> list = (List<Order>) oBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		int ispay = Integer.parseInt(request.getParameter("ispay"));
		Order o = setValue(request, response);
		o.setId(id);
		o.setStatus(status);
		o.setIspay(ispay);
		oBiz.update(o);
		getValue(request, response);
		List<Order> list = (List<Order>) oBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Order o = new Order();
		o.setId(id);
		oBiz.delete(o);
		getValue(request, response);
		List<Order> list = (List<Order>) oBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	// 通过客户ID查询订单
	public Object getByC_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		int c_id = Integer.parseInt(request.getParameter("param"));
		List<Order> list = oBiz.getByC_id(c_id);
		goShow(request, response, list);
		return url;
	}

	// 通过商品ID查询订单
	public Object getByP_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		int p_id = Integer.parseInt(request.getParameter("param"));
		List<Order> list = oBiz.getByP_id(p_id);
		goShow(request, response, list);
		return url;
	}

	// 通过职工名称查询订单-添加订单的员工
	public Object getByE_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String ename = request.getParameter("param");
		List<Order> list = null ;
		List<Emp> emplist = eBiz.getByEname(ename);
		if(emplist != null){
			for(int i=0;i<emplist.size();i++){
				int e_id = emplist.get(i).getId();
				list = oBiz.getByE_id(e_id);
			}
		}
		getValue(request, response);
		goShow(request, response, list);
		return url;
	}

	// 通过商品名查询订单
	public Object getByPname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String pname = request.getParameter("pname");
		int p_id = pBiz.getByPname1(pname).getId();
		List<Order> list = oBiz.getByP_id(p_id);
		goShow(request, response, list);
		return url;
	}

	// 通过精确的客户名查询订单信息
	public Object getByCname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String cname = request.getParameter("cname");
		int c_id = cBiz.getByCname1(cname).getId();
		List<Order> list = oBiz.getByC_id(c_id);
		goShow(request, response, list);
		return url;
	}

	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		List<Order> list = new ArrayList<Order>();
		String str = request.getParameter("param");
		if(InputCheck.ckeckInt(str)){
			int id = Integer.parseInt(str);
			list.add(oBiz.getById(id));
		}
		goShow(request, response, list);
		return url;
	}

	// 通过订单状态查询订单信息
	public Object getByStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		int status = Integer.parseInt(request.getParameter("param"));
		List<Order> list = oBiz.getByStatus(status);
		goShow(request, response, list);
		return url;
	}

	// 通过订单是否支付查询订单信息
	public Object getByIspay(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		int ispay = Integer.parseInt(request.getParameter("param"));
		List<Order> list = oBiz.getByIspay(ispay);
		goShow(request, response, list);
		return url;
	}

	// 通过下单日期查询订单信息
	public Object getByDate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String time = request.getParameter("time");
		List<Order> list = oBiz.getByDate(time);
		goShow(request, response, list);
		return url;
	}

	// 获取用户名和商品名（原材料名）
	public Object getCP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String username = request.getParameter("username");
		getValue(request, response);
		url = request.getRequestDispatcher("/zorder/add.jsp?username="
				+ username);
		return url;
	}

	// 获取用户名和商品名（原材料名）以及客户名
	public Object getCPU(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		getValue(request, response);
		url = request.getRequestDispatcher("/zorder/update.jsp?id=" + id);
		return url;
	}

	public void getValue(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Client> clients = cBiz.getAll();
		request.setAttribute("cliens", clients);
		List<Product> producs = pBiz.getPname();
		request.setAttribute("producs", producs);
		List<User> us = uBiz.getAll();
		request.setAttribute("us", us);
	}

	public Order setValue(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String cname = request.getParameter("client");
		Client client = cBiz.getByCname1(cname);
		String pname = request.getParameter("product");
		Product product = pBiz.getByPname1(pname);
		String ename = request.getParameter("ename");
		Emp emp = eBiz.getByEname1(ename);
		int num = Integer.parseInt(request.getParameter("num"));
		int pay = Integer.parseInt(request.getParameter("pay"));
		Order o = new Order(client, product, emp, num, pay);
		return o;
	}

	public void goShow(HttpServletRequest request,
			HttpServletResponse response, List<Order> list)
			throws ServletException, IOException, SQLException {
		request.setAttribute("orders", list);
		url = request.getRequestDispatcher("/zorder/show.jsp");
	}

}

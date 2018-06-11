package com.llz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.biz.EmpBiz;
import com.llz.biz.PurchaseBiz;
import com.llz.biz.SupplierBiz;
import com.llz.biz.UserBiz;
import com.llz.biz.impl.EmpBizImpl;
import com.llz.biz.impl.PurchaseBizImpl;
import com.llz.biz.impl.SupplierBizImpl;
import com.llz.biz.impl.UserBizImpl;
import com.llz.entity.Emp;
import com.llz.entity.Order;
import com.llz.entity.Purchase;
import com.llz.entity.Supplier;
import com.llz.entity.User;
import com.llz.utils.InputCheck;

/**
 * @author lilingzhi
 * @date 2017年5月8日 下午12:01:33
 */

public class PurchaseServlet extends BaseServlet {
	PurchaseBiz pBiz = new PurchaseBizImpl();
	SupplierBiz sBiz = new SupplierBizImpl();
	EmpBiz eBiz = new EmpBizImpl();
	UserBiz uBiz = new UserBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		pBiz.save(setValue(request, response));
		url = "/PurchaseServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		List<Purchase> list = (List<Purchase>) pBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		Purchase p = setValue(request, response);
		p.setId(id);
		pBiz.update(p);
		List<Purchase> list = (List<Purchase>) pBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		Purchase p = new Purchase();
		p.setId(id);
		pBiz.delete(p);
		List<Purchase> list = (List<Purchase>) pBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	// 通过ID获取进货单信息
	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		List<Purchase> list = new ArrayList<Purchase>();
		String str = request.getParameter("param");
		if(InputCheck.ckeckInt(str)){
			int id = Integer.parseInt(str);
			list.add(pBiz.getById(id));
		}
		goShow(request, response, list);
		return url;
	}

	// 通过进货商ID获取进货单信息
	public Object getByS_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		List<Purchase> list = null;
		String str = request.getParameter("param");
		if(InputCheck.ckeckInt(str)){
			int id = Integer.parseInt(str);
			list = pBiz.getByS_id(id);
		}
		goShow(request, response, list);
		return url;
	}

	// 通过供货商名称获取进货单信息
	public Object getBySname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String sname = request.getParameter("sname");
		int s_id = sBiz.getBySname1(sname).getId();
		List<Purchase> list = pBiz.getByS_id(s_id);
		goShow(request, response, list);
		return url;
	}

	// 通过员工ID获取进货单信息
	public Object getByE_id(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String ename = request.getParameter("param");
		List<Purchase> list = null ;
		List<Emp> emplist = eBiz.getByEname(ename);
		if(emplist != null){
			for(int i=0;i<emplist.size();i++){
				int e_id = emplist.get(i).getId();
				list = pBiz.getByE_id(e_id);
			}
		}
		getValue(request, response);
		goShow(request, response, list);
		return url;
	}

	// 通过进货商名获取进货单信息
	public Object getByJname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String jname = request.getParameter("param");
		List<Purchase> list = pBiz.getByJname(jname);
		goShow(request, response, list);
		return url;
	}

	// 通过ID获取进货单信息
	public Object getByDate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String time = request.getParameter("time");
		List<Purchase> list = pBiz.getByDate(time);
		goShow(request, response, list);
		return url;
	}

	// 通过ID获取进货单信息
	public Object getSup(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String username = request.getParameter("username");
		getValue(request, response);
		url = request.getRequestDispatcher("/zpurchase/add.jsp?username="
				+ username);
		return url;
	}

	// 通过ID获取进货单信息
	public Object getSupU(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		getValue(request, response);
		url = request.getRequestDispatcher("/zpurchase/update.jsp?id=" + id);
		return url;
	}

	// 获取前台传过来的数据，并赋值
	public Purchase setValue(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String sname = request.getParameter("sname");
		Supplier supplier = sBiz.getBySname1(sname);
		String ename = request.getParameter("ename");
		Emp emp = eBiz.getByEname1(ename);
		String jname = request.getParameter("jname");
		int num = Integer.parseInt(request.getParameter("num"));
		double price = Double.parseDouble(request.getParameter("price"));
		Purchase p = new Purchase(supplier, emp, jname, num, price);
		return p;
	}

	// 跳转页面
	public void goShow(HttpServletRequest request,
			HttpServletResponse response, List<Purchase> list)
			throws ServletException, IOException, SQLException {
		request.setAttribute("purchases", list);
		url = request.getRequestDispatcher("/zpurchase/show.jsp");
	}
	
	public void getValue(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Supplier> sups = sBiz.getAll();
		request.setAttribute("sups", sups);
		List<User> us = uBiz.getAll();
		request.setAttribute("us", us);
	}
}

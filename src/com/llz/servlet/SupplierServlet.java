package com.llz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.biz.SupplierBiz;
import com.llz.biz.impl.SupplierBizImpl;
import com.llz.entity.Supplier;
import com.llz.utils.InputCheck;

/**
 * @author lilingzhi
 * @date 2017年5月8日 上午11:52:37
 */

public class SupplierServlet extends BaseServlet {
	SupplierBiz sBiz = new SupplierBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		sBiz.save(setValue(request, response));
		url = "/SupplierServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Supplier> list = (List<Supplier>) sBiz.getAll();
		gotoShow(request, response, list);
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Supplier s = setValue(request, response);
		s.setId(id);
		sBiz.update(s);
		List<Supplier> list = (List<Supplier>) sBiz.getAll();
		gotoShow(request, response, list);
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Supplier s = new Supplier();
		s.setId(id);
		sBiz.delete(s);
		List<Supplier> list = (List<Supplier>) sBiz.getAll();
		gotoShow(request, response, list);
		return url;
	}

	// 通过ID获取供货商信息
	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Supplier> list = new ArrayList<Supplier>();
		String str = request.getParameter("param");
		if(InputCheck.ckeckInt(str)){
			int id = Integer.parseInt(str);
			list.add(sBiz.getById(id));
		}
		gotoShow(request, response, list);
		return url;
	}

	// 通过供货商名称获取供货商信息
	public Object getBySname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String sname = request.getParameter("param");
		List<Supplier> list = sBiz.getBySname(sname);
		gotoShow(request, response, list);
		return url;
	}

	// 通过联系人姓名获取供货商信息
	public Object getByRname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String rname = request.getParameter("param");
		List<Supplier> list = sBiz.getByRname(rname);
		gotoShow(request, response, list);
		return url;
	}

	// 通过地址获取供货商信息
	public Object getByAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String address = request.getParameter("param");
		List<Supplier> list = sBiz.getByAddress(address);
		gotoShow(request, response, list);
		return url;
	}

	// 通过邮箱获取供货商信息
	public Object getByEmail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String email = request.getParameter("param");
		List<Supplier> list = new ArrayList<Supplier>();
		list.add(sBiz.getByEmail(email));
		gotoShow(request, response, list);
		return url;
	}

	// 获取前台页面传过来的值，赋值给对象
	public Supplier setValue(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String sname = request.getParameter("sname");
		String tel = request.getParameter("tel");
		String rname = request.getParameter("rname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		Supplier s = new Supplier(sname, tel, rname, email, address);
		return s;
	}

	// 页面跳转
	public void gotoShow(HttpServletRequest request,
			HttpServletResponse response, List<Supplier> list)
			throws ServletException, IOException, SQLException {
		request.setAttribute("suppliers", list);
		url = request.getRequestDispatcher("/zsupplier/show.jsp");
	}

}

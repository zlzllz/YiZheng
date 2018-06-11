package com.llz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.biz.DeptBiz;
import com.llz.biz.impl.DeptBizImpl;
import com.llz.entity.Dept;
import com.llz.utils.InputCheck;

/**
 * @author lilingzhi
 * @date 2017年5月8日 上午11:51:27
 */

public class DeptServlet extends BaseServlet {
	DeptBiz dBiz = new DeptBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String dname = request.getParameter("dname");
		double salary = Double.parseDouble(request.getParameter("salary"));
		Dept d = new Dept(dname, salary);
		dBiz.save(d);
		List<Dept> list = (List<Dept>) dBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Dept> list = (List<Dept>) dBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String dname = request.getParameter("dname");
		double salary = Double.parseDouble(request.getParameter("salary"));
		Dept d = new Dept(id, dname, salary);
		dBiz.update(d);
		List<Dept> list = (List<Dept>) dBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Dept d = new Dept();
		d.setId(id);
		dBiz.delete(d);
		List<Dept> list = (List<Dept>) dBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	// 通过ID获取部门信息
	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Dept> list = new ArrayList<Dept>();
		String str = request.getParameter("param");
		if(InputCheck.ckeckInt(str)){
			int id = Integer.parseInt(str);
			list.add(dBiz.getById(id));
		}
		goShow(request, response, list);
		return url;
	}

	// 通过部门名称获取部门信息
	public Object getByDname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String dname = request.getParameter("param");
		List<Dept> list = new ArrayList<Dept>();
		list.add(dBiz.getByDname(dname));
		goShow(request, response, list);
		return url;
	}
	
	public void goShow(HttpServletRequest request,
			HttpServletResponse response, List<Dept> list) throws ServletException, IOException,
			SQLException {
		request.setAttribute("depts", list);
		url = request.getRequestDispatcher("/zdept/show.jsp");
	}

}

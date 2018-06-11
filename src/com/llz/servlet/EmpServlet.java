package com.llz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.biz.DeptBiz;
import com.llz.biz.EmpBiz;
import com.llz.biz.impl.DeptBizImpl;
import com.llz.biz.impl.EmpBizImpl;
import com.llz.entity.Dept;
import com.llz.entity.Emp;
import com.llz.utils.InputCheck;

/**
 * @author lilingzhi
 * @date 2017年5月8日 上午11:50:09
 */

public class EmpServlet extends BaseServlet {
	EmpBiz eBiz = new EmpBizImpl();
	DeptBiz dBiz = new DeptBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		eBiz.save(setValue(request, response));
		url = "/EmpServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		List<Emp> list = (List<Emp>) eBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Emp e = setValue(request, response);
		e.setId(id);
		eBiz.update(e);
		getValue(request, response);
		List<Emp> list = (List<Emp>) eBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Emp e = new Emp();
		e.setId(id);
		eBiz.delete(e);
		getValue(request, response);
		List<Emp> list = (List<Emp>) eBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	// 通过ID获取职工信息
	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		List<Emp> list = new ArrayList<Emp>();
		String str = request.getParameter("param");
		if(InputCheck.ckeckInt(str)){
			int id = Integer.parseInt(str);
			list.add(eBiz.getById(id));
		}
		goShow(request, response, list);
		return url;
	}

	// 通过职工姓名查询职工信息
	public Object getByEname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String ename = request.getParameter("param");
		List<Emp> list = eBiz.getByEname(ename);
		goShow(request, response, list);
		return url;
	}

	// 通过职工性别查询职工信息
	public Object getBySex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String sex = request.getParameter("param");
		List<Emp> list = eBiz.getBySex(sex);
		goShow(request, response, list);
		return url;
	}

	// 通过职位查询职工信息
	public Object getByJob(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String job = request.getParameter("param");
		List<Emp> list = eBiz.getByJob(job);
		goShow(request, response, list);
		return url;
	}

	// 通过部门名称查询职工信息
	public Object getByDname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String dname = request.getParameter("dname");
		List<Emp> list = eBiz.getByDname(dname);
		goShow(request, response, list);
		return url;
	}

	// 通过入职时间查询职工信息
	public Object getByDate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		String time = request.getParameter("time");
		List<Emp> list = eBiz.getByDate(time);
		goShow(request, response, list);
		return url;
	}

	// 获取部门信息
	public Object getDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		getValue(request, response);
		url = request.getRequestDispatcher("/zemp/add.jsp");
		return url;
	}

	// 获取部门信息
	public Object getDeptU(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		getValue(request, response);
		url = request.getRequestDispatcher("/zemp/update.jsp?id=" + id);
		return url;
	}

	public Emp setValue(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String dname = request.getParameter("dept");
		Dept dept = dBiz.getByDname(dname);
		String ename = request.getParameter("ename");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String tel = request.getParameter("tel");
		String job = request.getParameter("job");
		Emp e = new Emp(dept, ename, sex, age, tel, job);
		return e;
	}

	public void goShow(HttpServletRequest request,
			HttpServletResponse response, List<Emp> list)
			throws ServletException, IOException, SQLException {
		request.setAttribute("emps", list);
		url = request.getRequestDispatcher("/zemp/show.jsp");
	}

	public void getValue(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Dept> depts = dBiz.getAll();
		request.setAttribute("deps", depts);
	}
}

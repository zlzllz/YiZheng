package com.llz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.llz.biz.UserBiz;
import com.llz.biz.impl.UserBizImpl;
import com.llz.entity.User;
import com.llz.utils.InputCheck;

/**
 * @author lilingzhi
 * @date 2017年5月11日 下午2:59:43
 */

public class UserServlet extends BaseServlet {
	UserBiz uBiz = new UserBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String password = DigestUtils.md5Hex(pass.getBytes());
		User u = new User(name, password);
		uBiz.save(u);
		url = "/UserServlet?tag=getAll";
		return url;
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<User> list = (List<User>) uBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String password = DigestUtils.md5Hex(pass.getBytes());
		User u = new User(id, name, password);
		uBiz.update(u);
		List<User> list = (List<User>) uBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		User u = new User();
		u.setId(id);
		uBiz.delete(u);
		List<User> list = (List<User>) uBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	// 通过ID获取管理员信息
	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String str = request.getParameter("param");
		List<User> list = new ArrayList<User>();
		if(InputCheck.ckeckInt(str)){
			int id = Integer.parseInt(str);
			list.add(uBiz.getById(id));
		}
		goShow(request, response, list);
		return url;
	}

	// 通过ID获取管理员信息
	public Object getByName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String name = request.getParameter("param");
		List<User> list = new ArrayList<User>();
		list.add(uBiz.getByName(name));
		goShow(request, response, list);
		return url;
	}

	public void goShow(HttpServletRequest request, HttpServletResponse response, List<User> list)
			throws ServletException, IOException, SQLException {
		request.setAttribute("users", list);
		url = request.getRequestDispatcher("/zusers/show.jsp");
	}
}

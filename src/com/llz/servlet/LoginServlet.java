package com.llz.servlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.llz.dao.UserDao;
import com.llz.dao.impl.UserDaoImpl;
import com.llz.entity.User;

/**
 * @author lilingzhi
 * @date 2017年5月12日 下午7:30:14
 */

public class LoginServlet extends BaseServlet {
	UserDao uDao = new UserDaoImpl();
	private Object url = null;

	// 登录验证
	public Object login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("name");
		// 加密
		String pass = request.getParameter("password");
		String password = DigestUtils.md5Hex(pass.getBytes());
		if (check(username, password)) {
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/zmin/index.jsp").forward(request,
					response);
		} else {
			request.setAttribute("err", "");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
		return null;
	}

	// 注册验证
	public Object register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String pass = request.getParameter("password");
		String pass2 = request.getParameter("password2");
		if (username != "" && pass != "" && pass2 != "") {
			if (pass.equals(pass2)) {
				// 两次输入的密码一致
				String password = DigestUtils.md5Hex(pass.getBytes());
				if (check1(username)) {
					request.setAttribute("remindname", "该用户名已存在！");
					request.getRequestDispatcher("/zmin/register.jsp").forward(
							request, response);
				} else {
					int num = add(username, password);
					if (num == 1) {
						// 记录当前登录的用户名
						request.getSession().setAttribute("username", username);
						request.getRequestDispatcher("/zmin/index.jsp")
								.forward(request, response);
					} else {
						request.getRequestDispatcher("/zmin/register.jsp")
								.forward(request, response);
					}
				}
			} else {
				request.setAttribute("remindpass", "两次输入密码不一致！");
				request.getRequestDispatcher("/zmin/register.jsp").forward(
						request, response);
			}
		} else {
			if (username == null) {
				request.setAttribute("remindname", "请输入用户名！");
				request.getRequestDispatcher("/zmin/register.jsp").forward(
						request, response);
			}
			if (pass == null) {
				request.setAttribute("remindpass0", "请输入密码！");
				request.getRequestDispatcher("/zmin/register.jsp").forward(
						request, response);
			}
			if (pass2 == null) {
				request.setAttribute("remindpass", "请确认输入密码！");
				request.getRequestDispatcher("/zmin/register.jsp").forward(
						request, response);
			}
			request.getRequestDispatcher("/zmin/register.jsp").forward(request, response);
		}
		return null;
	}

	// 验证用户是否存在
	private Boolean check(String username, String password) {
		User user = uDao.getByName(username);
		if (user != null) {
			if ((user.getName().equals(username))
					&& (user.getPass().equals(password))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private Boolean check1(String username) {
		User user = uDao.getByName(username);
		if (user != null) {
			if (user.getName().equals(username)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// 用户注册到数据库
	public int add(String username, String password) {
		return uDao.save(new User(username, password));
	}

	// 退出系统
	public Object logOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("username");
		request.getSession().invalidate();
		return "/login.jsp";
	}

}

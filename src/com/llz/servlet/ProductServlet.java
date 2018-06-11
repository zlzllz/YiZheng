package com.llz.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.llz.biz.ProductBiz;
import com.llz.biz.impl.ProductBizImpl;
import com.llz.entity.Product;
import com.llz.utils.InputCheck;

/**
 * @author lilingzhi
 * @date 2017年5月9日 下午5:42:45
 */

public class ProductServlet extends BaseServlet {
	ProductBiz pBiz = new ProductBizImpl();
	private Object url = null;

	public Object save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Product p = UploadServlet.save(request, response);
		pBiz.save(p);
		return "/ProductServlet?tag=getAll";
	}

	public Object getAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Product> list = (List<Product>) pBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Product p = UploadServlet.update(request, response);
		pBiz.update(p);
		List<Product> list = (List<Product>) pBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	public Object delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = new Product();
		p.setId(id);
		pBiz.delete(p);
		List<Product> list = (List<Product>) pBiz.getAll();
		goShow(request, response, list);
		return url;
	}

	// 通过ID获取商品信息
	public Object getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Product> list = new ArrayList<Product>();
		String str = request.getParameter("param");
		if(InputCheck.ckeckInt(str)){
			int id = Integer.parseInt(str);
			list.add(pBiz.getById(id));
		}
		goShow(request, response, list);
		return url;
	}

	// 通过商品名获取商品信息
	public Object getByPname(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String pname = request.getParameter("param");
		List<Product> list = pBiz.getByPname(pname);
		goShow(request, response, list);
		return url;
	}

	// 通过商品类型名获取商品信息
	public Object getByType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String type = request.getParameter("param");
		List<Product> list = pBiz.getByType(type);
		goShow(request, response, list);
		return url;
	}

	public void goShow(HttpServletRequest request,
			HttpServletResponse response, List<Product> list)
			throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("products", list);
		url = request.getRequestDispatcher("/zproduct/show.jsp");
	}

}

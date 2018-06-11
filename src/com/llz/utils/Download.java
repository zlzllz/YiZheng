package com.llz.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lilingzhi
 * @date 2017年5月8日 下午5:22:25
 * 下载数据类
 */

public class Download extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		response.setHeader("content-disposition", "attachment;filename="+name);
		
		String path = getServletContext().getRealPath("/file/"+name);
		File file = new File(path);
		InputStream inputStream = new FileInputStream(file);
		OutputStream outputStream = response.getOutputStream();
		int length;
		while((length = inputStream.read()) != -1){
			outputStream.write(length);
		}
		outputStream.close();
		inputStream.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}

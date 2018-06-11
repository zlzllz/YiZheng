package com.llz.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.llz.biz.ProductBiz;
import com.llz.biz.impl.ProductBizImpl;
import com.llz.entity.Product;

/**
 * @author lilingzhi
 * @date 2017年5月12日 下午7:19:35
 */

public class UploadServlet  {
	static Product p ;
	
	// 新增商品信息
	public static Product save( HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");// 解决文件名称乱码
		Product pp = new Product();
		
		if(upload.isMultipartContent(request)){
			try {
				List<FileItem> list = (List) upload.parseRequest(request);
				for(FileItem fileItem : list){
					if(fileItem.isFormField()){
						String key = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");// 设置编码格式
						// System.out.println(key+"------"+value);
						if(key.equals("pname")){
							pp.setPname(value);
						}else if(key.equals("type")){
							pp.setType(value);
						}else if(key.equals("unit")){
							pp.setUnit(value);
						}else{
							pp.setPrice(Double.parseDouble(value));
						}
					}else{
						String name = fileItem.getName();
						// String fieldName = fileItem.getFieldName();//img
						SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSS");
						String time = format.format(new Date());
						String tag = time + name;
						String path = request.getServletContext().getRealPath("/pictures");
						File file = new File(path,tag);
						pp.setImg(tag);
						fileItem.write(file);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else{
			System.out.println("没有上传文件");
		}
		return pp;
	}
	
	// 更新商品信息
	public static Product update( HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ProductBiz pBiz = new ProductBizImpl();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");// 解决文件名称乱码
		
		if(upload.isMultipartContent(request)){
			try {
				List<FileItem> list = (List) upload.parseRequest(request);
				for(FileItem fileItem : list){
					if(fileItem.isFormField()){
						String key = fileItem.getFieldName();
						String value = fileItem.getString("utf-8");
						if(key.equals("id")){
							p = pBiz.getById(Integer.parseInt(value));
						}else if(key.equals("pname")){
							p.setPname(value);
						}else if(key.equals("type")){
							p.setType(value);
						}else if(key.equals("unit")){
							p.setUnit(value);
						}else{
							p.setPrice(Double.parseDouble(value));
						}
					}else{
						String name = fileItem.getName();
						SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSS");
						String time = format.format(new Date());
						String tag = time + name;
						String path = request.getServletContext().getRealPath("/pictures");
						File file = new File(path,tag);
						p.setImg(tag);
						fileItem.write(file);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else{
			System.out.println("没有上传文件");
		}
		return p;
	}


}
   
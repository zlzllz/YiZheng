package com.llz.utils;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author lilingzhi
 * @date 2017年5月9日 上午8:40:11
 * 上传文件类
 */

public class UploadFile {
	public static void upload(HttpServletRequest request, HttpServletResponse response){

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		if (upload.isMultipartContent(request)) {
			try {
				List<FileItem> list = (List) upload.parseRequest(request);
				for (FileItem fileItem : list) {
					if (fileItem.isFormField()) {
						System.out.println("不是上传文件的表单元素！");
					} else {
						String fieldName = fileItem.getFieldName();
						/*SimpleDateFormat format = new SimpleDateFormat(
								"yyyyMMddhhmmssSS");
						String time = format.format(new Date());
						String tag = time + fieldName;*/
						// 创建存放图片的文件夹
						String separator = File.separator;
						String directory = ""+ request.getServletContext().getRealPath("/picture") +"";
						System.out.println("directory------------"+directory);
						File folder = new File(directory,"picture");
						System.out.println("folder------"+folder.getPath());
					    if (!folder.exists()) {  
					    	folder.mkdirs();  
					    }  
						File file = new File(fieldName);
						try {
							fileItem.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("没有上传文件。");
		}
	}
}

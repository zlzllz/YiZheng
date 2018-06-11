<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>client-add</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
	<link rel="stylesheet" href="<%=path %>/css/table_tr.css">
  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/ProductServlet?tag=update" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>" />
	<table>
	<tr><td colspan="2">修改商品信息</td></tr>
	<tr><td>商品名称:</td><td><input type="text" name="pname"/></td></tr>
	<tr><td>商品类型:</td><td>
							<select name="type">
								<option vlaue="玻璃">玻璃</option>
								<option vlaue="塑料">塑料</option>
								<option vlaue="聚合材料">聚合材料</option>
								<option vlaue="布">布</option>
								<option vlaue="纸">纸</option>
							</select>
						</td></tr>
	<tr><td>销售单位:</td><td><input type="text" name="unit"/></td></tr>
	<tr><td>销售价格:</td><td><input type="text" name="price"/></td></tr>
	<tr><td>商品图片:</td><td><input type="file" name="img" value="上传图片"/></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="提交" class="button"/>
		<input type="reset" class="button" value="重置"/>
	</td></tr>
	</table>
	</form>
  </body>
</html>

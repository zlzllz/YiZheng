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
	<form action="${pageContext.request.contextPath }/ClientServlet?tag=save" method="post">
	<table>
	<tr><td colspan="2">新增客户信息</td></tr>
	<tr><td>客户名称:</td><td><input type="text" name="cname"/></td></tr>
	<tr><td>客户电话:</td><td><input type="text" name="tel"/></td></tr>
	<tr><td>联系人:</td><td><input type="text" name="rname"/></td></tr>
	<tr><td>邮箱:</td><td><input type="text" name="email"/></td></tr>
	<tr><td>单位地址:</td><td><input type="text" name="address"/></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="提交" class="button"/>
		<input type="reset" class="button" value="重置"/>
	</td></tr>
	</table>
	</form>
  </body>
</html>

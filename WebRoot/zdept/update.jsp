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
	<form action="${pageContext.request.contextPath}/DeptServlet?tag=update" method="post">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>" />
	<table>
	<tr><td colspan="2">修改部门信息</td></tr>
	<tr><td>部门名称:</td><td><input type="text" name="dname"/></td></tr>
	<tr><td>部门薪水:</td><td><input type="text" name="salary"/></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="提交" class="button"/>
		<input type="reset" class="button" value="重置"/>
	</td></tr>
	</table>
	</form>
  </body>
</html>

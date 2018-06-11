<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<form action="${pageContext.request.contextPath}/OrderServlet?tag=update" method="post">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>" /><br/>
	<table>
	<tr><td colspan="2">修改订单信息</td></tr>
	<tr><td>客户</td><td>
	<select name="cname">
		<option>选择客户</option>
		<c:choose>
    	<c:when test="${not empty requestScope.cliens}">
    		<c:forEach var="c" items="${requestScope.cliens}" >
    			<option>${c.cname }</option>
    		</c:forEach>
    	</c:when>
    	</c:choose>
	</select>
	</td></tr>
	<tr><td>商品</td><td>
	<select name="pname">
		<option>选择商品</option>
		<c:choose>
    	<c:when test="${not empty requestScope.producs}">
    		<c:forEach var="p" items="${requestScope.producs}" >
    			<option>${p.pname }</option>
    		</c:forEach>
    	</c:when>
    	</c:choose>
	</select>
	</td></tr>
	<tr><td>职工名称:</td><td><input type="text" name="ename"/></td></tr>
	<tr><td>货品数量:</td><td><input type="text" name="num"/></td></tr>
	<tr><td>订单状态:</td><td><input type="text" name="status"/></td></tr>
	<tr><td>是否结帐:</td><td><input type="text" name="ispay"/></td></tr>
	<tr><td>结帐金额:</td><td><input type="text" name="pay"/></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="提交" class="button"/>
		<input type="reset" class="button" value="重置"/>
	</td></tr>
	</table>
	</form>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% String username = (String) request.getSession().getAttribute("username"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>order-add</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
	<link rel="stylesheet" href="<%=path %>/css/table_tr.css">
	<script type="text/javascript" src="ajax.js"></script>

  </head>
  
  <body>
	<form action="${pageContext.request.contextPath }/OrderServlet?tag=save" method="post">
	<input type="hidden" name="ename" value="<%=username %>"/>
	<table>
	<tr><td colspan="2">新增订单信息</td></tr>
	<tr><td>客户</td><td>
		<select name="client">
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
		<select name="product">
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
	<tr><td>商品数量:</td><td><input type="text" name="num"/></td></tr>
	<tr><td>订单账目:</td><td><input type="text" name="pay"/></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="提交" class="button"/>
		<input type="reset" class="button" value="重置"/>
	</td></tr>
	</table>
	</form>
  </body>
</html>

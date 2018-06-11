<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String username = (String) request.getSession().getAttribute("username");
System.out.println("username==========="+username);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>purchase-add</title>
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
	<form action="${pageContext.request.contextPath }/PurchaseServlet?tag=save" method="post">
	<input type="hidden" name="ename" value="<%=username %>"/>
	<table>
	<tr><td colspan="2">新增进货单信息</td></tr>
	<tr><td>供货商:</td><td>
		<select name="sname">
			<option>选择供货商</option>
			<c:choose>
    		<c:when test="${not empty requestScope.sups}">
    			<c:forEach var="s" items="${requestScope.sups}" >
    				<option>${s.sname }</option>
    			</c:forEach>
    		</c:when>
    		</c:choose>
		</select>
	</td></tr>
	<tr><td>进货名称:</td><td><input type="text" name="jname"/></td></tr>
	<tr><td>进货数量:</td><td><input type="text" name="num"/></td></tr>
	<tr><td>采购价格:</td><td><input type="text" name="price"/></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="提交" class="button"/>
		<input type="reset" class="button" value="重置"/>
	</td></tr>
	</table>
	</form>
  </body>
</html>

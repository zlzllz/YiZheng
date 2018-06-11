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
	<form action="${pageContext.request.contextPath}/PurchaseServlet?tag=update" method="post">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>" /><br/>
	<table>
	<tr><td colspan="2">修改进货单信息</td></tr>
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
	<tr><td>职工姓名:</td><td><input type="text" name="ename"/></td></tr>
	<tr><td>进货名称:</td><td><input type="text" name="jname"/></td></tr>
	<tr><td>进货数量:</td><td><input type="text" name="num"/></td></tr>
	<tr><td>进货价格:</td><td><input type="text" name="price"/></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="提交" class="button"/>
		<input type="reset" class="button" value="重置"/>
	</td></tr>
	</table>
	</form>
  </body>
</html>

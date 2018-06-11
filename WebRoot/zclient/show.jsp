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
    <title>client-show</title>
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
  	
    <select id="search" onchange="searchType(this)">
    	<option>请选择查询方式</option>
    	<option value="getAll">全部</option>
    	<option value="getById">ID</option>
    	<option value="getByCname">客户姓名</option>
    	<option value="getByRname">联系人姓名</option>
    	<option value="getByAddress">单位地址</option>
    	<option value="getByEmail">联系邮箱</option>
    </select>
    <input type="text" id="searchValue"/><input type="button" value="查询" onclick="search()" /><br/><br/>
    
    <div id="showdata" class="">
    <table>
    	<tr>
    		<td>ID</td>
    		<td>客户名称</td>
    		<td>客户电话</td>
    		<td>联系人</td>
    		<td>邮箱</td>
    		<td>单位地址</td>
    		<td>操作</td>
    	</tr>
    	<c:choose>
    	<c:when test="${not empty requestScope.clients}">
    		<c:forEach var="client" items="${requestScope.clients}" >
    			<tr>
    			<td>${client.id }</td>
    			<td>${client.cname }</td>
    			<td>${client.tel }</td>
    			<td>${client.rname }</td>
    			<td>${client.email }</td>
    			<td>${client.address }</td>
    			<td><a href="zclient/update.jsp?id=${client.id}" class="aa">修改</a>
    				<a href="${pageContext.request.contextPath}/ClientServlet?tag=delete&id=${client.id}"class="aa">删除</a>
    			</td>
    			</tr>
    		</c:forEach>
    	</c:when>
    	<c:otherwise>
    		<tr><td colspan="7">当前数据库没有数据</td></tr>
    	</c:otherwise>
    </c:choose>
    	
    </table>
    </div>
	
	<script type="text/javascript">
	var sType;
	function searchType(obj){
		sType = obj.value;//得到要调用的方法
	}
	function search(){
		var param = document.getElementById("searchValue").value;
		if((sType != "请选择查询方式") && (param != "")){
			var data = "tag="+sType+"&param="+param;
			//alert(data);
			location.href="${pageContext.request.contextPath}/ClientServlet?"+data;
		}
		if((sType == "getAll")){
			location.href="${pageContext.request.contextPath}/ClientServlet?tag="+sType;
		}
   	}
	</script>
  </body>
</html>

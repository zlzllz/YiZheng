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
    
    <title>order-show</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
	<link rel="stylesheet" href="<%=path %>/css/table_tr.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.3.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui-1.7.1.custom.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/daterangepicker.jQuery.js"></script>
	<link rel="stylesheet" href="<%=path %>/css/ui.daterangepicker.css" type="text/css" />
	<link rel="stylesheet" href="<%=path %>/css/redmond/jquery-ui-1.7.1.custom.css" type="text/css" title="ui-theme" />
	<script type="text/javascript">	
		$(function(){
			$('#rangeA').daterangepicker({arrows:true}); 
		});
	</script>
	<style type="text/css">
		#rangeA {width: 160px; height: 1.5em; display:block;}
	</style>

  </head>
  
  <body>
  	<input type="text" value="5/16/17" id="rangeA"/>
	<input type="button" onclick="getDate()" value="根据下单日期查询"/>
	
    <select id="search" onchange="searchType(this)">
    	<option>请选择查询方式</option>
    	<option value="getAll">全部</option>
    	<option value="getById">ID</option>
    	<option value="getByE_id">职工姓名</option>
    	<option value="getByStatus">订单状态</option>
    	<option value="getByIspay">是否结帐</option>
    </select>
    <input type="text" id="searchValue"/><input type="button" value="查询" onclick="search()"/>
    
    <select id="client" onchange="clientValue(this)">
    	<option>选择客户</option>
		<c:choose>
    	<c:when test="${not empty requestScope.cliens}">
    		<c:forEach var="c" items="${requestScope.cliens}" >
    			<option>${c.cname }</option>
    		</c:forEach>
    	</c:when>
    	</c:choose>
    </select>
    <input type="button" value="根据客户查询" onclick="searchClient()"/>
    
    <select id="product" onchange="productValue(this)">
    	<option>选择商品</option>
		<c:choose>
    	<c:when test="${not empty requestScope.producs}">
    		<c:forEach var="p" items="${requestScope.producs}" >
    			<option>${p.pname }</option>
    		</c:forEach>
    	</c:when>
    	</c:choose>
    </select>
    <input type="button" value="根据商品查询" onclick="searchProduct()"/>

	<select id="emp" onchange="empValue(this)">
    	<option>选择管理员</option>
		<c:choose>
    	<c:when test="${not empty requestScope.us}">
    		<c:forEach var="u" items="${requestScope.us}" >
    			<option>${u.name }</option>
    		</c:forEach>
    	</c:when>
    	</c:choose>
    </select>
    <input type="button" value="根据管理员查询" onclick="searchEmp()"/><br/><br/>
    
    <div id="showdata" class="">
    <table>
    	<tr>
    		<td>ID</td>
    		<td>客户姓名</td>
    		<td>商品名称</td>
    		<td>职工姓名</td>
    		<td>商品数量</td>
    		<td>订单状态</td>
    		<td>下单时间</td>
    		<td>是否结账</td>
    		<td>结账款</td>
    		<td>操作</td>
    	</tr>
    	<c:choose>
    	<c:when test="${not empty requestScope.orders}">
    		<c:forEach var="order" items="${requestScope.orders}" >
    			<tr>
    			<td>${order.id }</td>
    			<td>${order.client.cname }</td>
    			<td>${order.product.pname }</td>
    			<td>${order.emp.ename }</td>
    			<td>${order.num }</td>
    			<td>${order.status }</td>
    			<td>${order.time }</td>
    			<td>${order.ispay }</td>
    			<td>${order.pay }</td>
    			<td><a href="${pageContext.request.contextPath}/OrderServlet?tag=getCPU&id=${order.id}" class="aa">修改</a>
    				<a href="${pageContext.request.contextPath}/OrderServlet?tag=delete&id=${order.id}" class="aa">删除</a>
    			</td>
    			</tr>
    		</c:forEach>
    	</c:when>
    	<c:otherwise>
    		<tr><td colspan="10">当前数据库没有数据</td></tr>
    	</c:otherwise>
    </c:choose>
    	
    </table>
    </div>
	<script type="text/javascript">
	function getDate(){
		var timee = document.getElementById("rangeA").value; 
		location.href="${pageContext.request.contextPath}/OrderServlet?tag=getByDate&time="+timee;
	}
	
	var sType;
	function searchType(obj){
		sType = obj.value;//得到要调用的方法
	}
	function search(){
		var param = document.getElementById("searchValue").value;
		if((sType != "请选择查询方式") && (param != "")){
			var data = "tag="+sType+"&param="+param;
			//alert(data);
			location.href="${pageContext.request.contextPath}/OrderServlet?"+data;
   		}
   		if((sType == "getAll")){
			location.href="${pageContext.request.contextPath}/OrderServlet?tag="+sType;
		}
   	}
   	
   	var clientname ;
	function clientValue(obj){
		clientname = obj.value;
	}
	function searchClient(){
		if((clientname != null) && (clientname != "请选择查询方式")){
			var data = "tag=getByCname&cname="+clientname;
			location.href="${pageContext.request.contextPath}/OrderServlet?"+data;;
   		}
   	}
   	
   	var productname ;
	function productValue(obj){
		productname = obj.value;
	}
	function searchProduct(){
		if((productname != null) && (productname != "请选择查询方式")){
			var data = "tag=getByPname&pname="+productname;
			location.href="${pageContext.request.contextPath}/OrderServlet?"+data;;
   		}
   	}
   	
   	var ename ;
	function empValue(obj){
		ename = obj.value;
	}
	function searchEmp(){
		if((ename != null) && (ename != "请选择查询方式")){
			var data = "tag=getByE_id&param="+ename;
			location.href="${pageContext.request.contextPath}/OrderServlet?"+data;;
   		}
   	}	
	</script>
  </body>
</html>

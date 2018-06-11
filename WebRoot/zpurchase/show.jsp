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
    
    <title>purchase-show</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
	<link rel="stylesheet" href="<%=path %>/css/table_tr.css">
	<link rel="stylesheet" href="<%=path %>/css/ui.daterangepicker.css" type="text/css" />
	<link rel="stylesheet" href="<%=path %>/css/redmond/jquery-ui-1.7.1.custom.css" type="text/css" title="ui-theme" />
	<script type="text/javascript" src="<%=path %>/js/jquery-1.3.1.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery-ui-1.7.1.custom.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/daterangepicker.jQuery.js"></script>
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
  	<input type="text" value="5/20/17" id="rangeA" />
  	<input type="button" onclick="getDate()" value="根据日期查询"/>
  	
    <select id="search" onchange="searchType(this)">
    	<option>请选择查询方式</option>
    	<option value="getAll">全部</option>
    	<option value="getById">ID</option>
    	<option value="getByE_id">职工姓名</option>
    	<option value="getByJname">进货材料名称</option>
    </select>
    <input type="text" id="searchValue"/><input type="button" value="查询" onclick="search()"/>
    
    <select id="supplier" onchange="supValue(this)">
    	<option>选择供货商</option>
		<c:choose>
    	<c:when test="${not empty requestScope.sups}">
    		<c:forEach var="s" items="${requestScope.sups}" >
    			<option>${s.sname }</option>
    		</c:forEach>
    	</c:when>
    	</c:choose>
    </select>
    <input type="button" value="根据供货商查询" onclick="searchSup()"/>
    
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
    		<td>供货商ID</td>
    		<td>供货商</td>
    		<td>职工</td>
    		<td>进货名称</td>
    		<td>进货数量</td>
    		<td>采购价格</td>
    		<td>进货时间</td>
    		<td>操作</td>
    	</tr>
    	<c:choose>
    	<c:when test="${not empty requestScope.purchases}">
    		<c:forEach var="purchase" items="${requestScope.purchases}" >
    			<tr>
    			<td>${purchase.id }</td>
    			<td>${purchase.supplier.id }</td>
    			<td>${purchase.supplier.sname }</td>
    			<td>${purchase.emp.ename }</td>
    			<td>${purchase.jname }</td>
    			<td>${purchase.num }</td>
    			<td>${purchase.price }</td>
    			<td>${purchase.time }</td>
    			<td><a href="${pageContext.request.contextPath}/PurchaseServlet?tag=getSupU&id=${purchase.id}" class="aa">修改</a>
    				<a href="${pageContext.request.contextPath}/PurchaseServlet?tag=delete&id=${purchase.id}" class="aa">删除</a>
    			</td>
    			</tr>
    		</c:forEach>
    	</c:when>
    	<c:otherwise>
    		<tr><td colspan="8">当前数据库没有数据</td></tr>
    	</c:otherwise>
    </c:choose>
    	
    </table>
    </div>
	<script type="text/javascript">
	function getDate(){
		var timee = document.getElementById("rangeA").value; 
		window.location="${pageContext.request.contextPath}/PurchaseServlet?tag=getByDate&time="+timee;
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
			location.href="${pageContext.request.contextPath}/PurchaseServlet?"+data;
   		}
   		if((sType == "getAll")){
			location.href="${pageContext.request.contextPath}/PurchaseServlet?tag="+sType;
		}
   	}
   	
   	var supname ;
	function supValue(obj){
		supname = obj.value;
	}
	function searchSup(){
		if((supname != null) && (supname != "请选择查询方式")){
			var data = "tag=getBySname&sname="+supname;
			location.href="${pageContext.request.contextPath}/PurchaseServlet?"+data;;
   		}
   	}
   	
   	var ename ;
	function empValue(obj){
		ename = obj.value;
	}
	function searchEmp(){
		if((ename != null) && (ename != "请选择查询方式")){
			var data = "tag=getByE_id&param="+ename;
			location.href="${pageContext.request.contextPath}/PurchaseServlet?"+data;;
   		}
   	}
	</script>
  </body>
</html>

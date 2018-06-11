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
    <title>emp-show</title>
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
	<script type="text/javascript" src="<%=path %>/js/ajax.js"></script>
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
		.dateButton{margin-top:0px;}
	</style>
  </head>
  
  <body>
    <input type="text" value="5/20/17" id="rangeA" />
  	<input type="button" onclick="getDate()" value="根据入职时间查询" class="dateButton"/>
  	
    <select id="search" onchange="searchType(this)">
    	<option>请选择查询方式</option>
    	<option value="getAll">全部</option>
    	<option value="getById">ID</option>
    	<option value="getBySex">性别</option>
    	<option value="getByEname">职工姓名</option>
    	<option value="getByJob">职工职位</option>
    </select>
    <input type="text" id="searchValue"/><input type="button" value="查询" onclick="search()"/>
    
    <select id="dept" onchange="deptValue(this)">
    	<option>选择部门</option>
		<c:choose>
    	<c:when test="${not empty requestScope.deps}">
    		<c:forEach var="d" items="${requestScope.deps}" >
    			<option>${d.dname }</option>
    		</c:forEach>
    	</c:when>
    	</c:choose>
    </select>
    <input type="button" value="根据部门查询" onclick="searchDept()"/>
    
    <br/><br/>
    <div id="showdata" class="">
    <table>
    	<tr>
    		<td>ID</td>
    		<td>部门名称</td>
    		<td>职工姓名</td>
    		<td>职工性别</td>
    		<td>职工年龄</td>
    		<td>职工电话</td>
    		<td>职工职位</td>
    		<td>入职时间</td>
    		<td>操作</td>
    	</tr>
    	<c:choose>
    	<c:when test="${not empty requestScope.emps}">
    		<c:forEach var="emp" items="${requestScope.emps}" >
    			<tr>
    			<td>${emp.id }</td>
    			<td>${emp.dept.dname }</td>
    			<td>${emp.ename }</td>
    			<td>${emp.sex }</td>
    			<td>${emp.age }</td>
    			<td>${emp.tel }</td>
    			<td>${emp.job }</td>
    			<td>${emp.time }</td>
    			<td><a href="${pageContext.request.contextPath}/EmpServlet?tag=getDeptU&id=${emp.id}" class="aa">修改</a>
    				<a href="${pageContext.request.contextPath}/EmpServlet?tag=delete&id=${emp.id}" class="aa">删除</a>
    			</td>
    			</tr>
    		</c:forEach>
    	</c:when>
    	<c:otherwise>
    		<tr><td colspan="9">当前数据库没有数据</td></tr>
    	</c:otherwise>
    </c:choose>
    	
    </table>
    </div>
    
    <script type="text/javascript">
	function getDate(){
		var datee = document.getElementById("rangeA").value;
		//alert(datee);
		location.href="${pageContext.request.contextPath}/EmpServlet?tag=getByDate&time="+datee;
	}
	var sType;
	function searchType(obj){
		sType = obj.value;//得到要调用的方法
	}
	function search(){
		var param = document.getElementById("searchValue").value;
		if((sType != "请选择查询方式") && (param != "")){
			var data = "tag="+sType+"&param="+param;
			location.href="${pageContext.request.contextPath}/EmpServlet?"+data;
   		}
   		if((sType == "getAll")){
			location.href="${pageContext.request.contextPath}/EmpServlet?tag="+sType;
		}
   	}
   	var deptname ;
	function deptValue(obj){
		deptname = obj.value;
	}
	function searchDept(){
		if((deptname != null) && (deptname != "选择部门")){
			var data = "tag=getByDname&dname="+deptname;
			location.href="${pageContext.request.contextPath}/EmpServlet?"+data;;
   		}
   	}
	</script>
  </body>
</html>

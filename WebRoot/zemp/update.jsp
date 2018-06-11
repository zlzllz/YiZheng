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
	<form action="${pageContext.request.contextPath}/EmpServlet?tag=update" method="post">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>" />
	<table>
	<tr><td colspan="2">修改职工信息</td></tr>
	<tr><td>职工部门:</td><td>
		<select name="dept" onchange="deptValue(this)">
    		<option>选择部门</option>
			<c:choose>
    		<c:when test="${not empty requestScope.deps}">
    			<c:forEach var="d" items="${requestScope.deps}" >
    				<option>${d.dname }</option>
    			</c:forEach>
    		</c:when>
    		</c:choose>
    	</select>
    </td></tr>
	<tr><td>职工姓名:</td><td><input type="text" name="ename"/></td></tr>
	<tr><td>职工性别:</td><td>
							<select name="sex">
								<option value="女">女</option>
								<option value="男">男</option>
							</select>
						</td>
	</tr>
	<tr><td>年龄:</td><td><input type="text" name="age"/></td></tr>
	<tr><td>电话:</td><td><input type="text" name="tel"/></td></tr>
	<tr><td>职位:</td><td><input type="text" name="job"/></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="提交" class="button"/>
		<input type="reset" class="button" value="重置"/>
	</td></tr>
	</table>
	</form>
	
    <script type="text/javascript">
   	var deptname ;
	function deptValue(obj){
		deptname = obj.value;
	}
	function searchDept(){
		var data = "tag=getByDname&dname="+deptname;
		location.href="${pageContext.request.contextPath}/EmpServlet?"+data;;
   	}
	</script>
  </body>
</html>

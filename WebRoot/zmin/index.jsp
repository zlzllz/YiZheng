<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String username = (String) request.getSession().getAttribute("username");
if(username == null){
	username = "";
}
// System.out.println("index页面获取到的username="+username);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript">
function getUser(){
	var user = "<%=username %>";
	if(user == ""){
		alert("请先登录在使用本系统。");
		window.location.href="<%=path %>/login.jsp";
	}
}
getUser();
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>
</head>

<frameset rows="12%,78%,*" frameborder="1" framespacing="0" noresize>
	<frame src="<%=path %>/zmin/top.jsp" scrolling="no" noresize/>
	<frameset cols="10%,*">
		<frame src="<%=path %>/zmin/left.jsp?username=<%=username %>" scrolling="no" noresize/>
		<frame src="<%=path %>/zmin/right.jsp?username=<%=username %>" name='right' noresize/>
	</frameset>
	<frame src="<%=path %>/zmin/bottom.jsp" noresize/>
</frameset>
</html>
		
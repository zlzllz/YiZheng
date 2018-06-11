<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	String username = (String) request.getAttribute("username");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title>top</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/css/top.css">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/top.js"></script>
	<style type=text/css>
		body{
		background:url(images/4.jpg);
		background-size: 100% 100%;
	}
	</style>
</head>

<body>
	<div id="zhi"><h1 align="center"></h1></div>

	<div id="time">
		<div class="time_1"></div>
		<div class="time_2"></div>
		<div class="dian"></div>
		<div class="time_3"></div>
		<div class="time_4"></div>
		<div class="dian" id="dian"></div>
		<div class="time_5"></div>
		<div class="time_6"></div>
		<div class="s1"></div>
		<div class="date">
			<div class="date_left"></div>
			<div class="date_right"></div>
		</div>
		<div class="right">
			<div class="r_1"></div>
			<div class="r_2"></div>
			<div class="r_3"></div>
			<div class="r_4"></div>
			<div class="heng"></div>
			<div class="r_5"></div>
			<div class="r_6"></div>
			<div class="eng"></div>
			<div class="clear"></div>
			<div class="zhou"><span>星期</span><span></span>&nbsp;&nbsp;&nbsp;&nbsp;<span></span></div>
		</div>
		<div class="clear"></div>
	</div>
	
	<div id="tuichu">
	<a href="${pageContext.request.contextPath }/LoginServlet?tag=logOut" 
	onclick="tuichu()" class="aaa">退出登录</a>
	<a href="javascript: window.parent.right.history.go(0);" 
	class="aaa">刷新</a>
	</div>
	
<script type="text/javascript">
	function tuichu(){
		window.parent.location.href="login.jsp";
	}
</script>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String username = (String) request.getSession().getAttribute("username");
%>
<!DOCTYPE HTML>
<html lang=zh-cn>
<head>
<meta charset=utf-8>
<link rel="stylesheet" href="<%=path %>/css/index.css">
<style type="text/css">
	body{
		background:url(../images/6.jpg);
		background-size: 100% 230%;
	}
</style>
</head>
<body>
	<ul class="menu">
		<li><a href="#"><span><h3>&nbsp;&nbsp;&nbsp;&nbsp;菜&nbsp;单&nbsp;栏</h3></span></a></li>

		<li><input type="radio" name="tab1" id="tab1a" class="tabs">
			<label for="tab1a" class="open" accesskey="2"> <img
				src="<%=path %>/images/ico01.png" alt="" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门管理
		</label> <input type="radio" name="tab1" id="tab1ac" class="tabs close">
			<label for="tab1ac" class="close" accesskey="3"> <img
				src="<%=path %>/images/ico01.png" alt="">
		</label>
			<ul>
				<li><a target="right" href="<%=path %>/DeptServlet?tag=getAll">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核部门</a></li>
				<li><a target="right" href="<%=path %>/zdept/add.jsp">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加部门</a></li>
			</ul></li>

		<li><input type="radio" name="tab1" id="tab1b" class="tabs"
			checked="checked"><label for="tab1b" class="open"
			accesskey="4"><img src="<%=path %>/images/i07.png"
				alt="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;职工管理</label> 
				<input type="radio" name="tab1" id="tab1bc"
			class="tabs close"><label for="tab1bc" class="close"
			accesskey="5"><img src="<%=path %>/images/i07.png"
				alt=""></label>
			<ul>
				<li><a target="right" href="<%=path %>/EmpServlet?tag=getAll" title="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查询职工</a></li>
				<li><a target="right" href="<%=path %>/EmpServlet?tag=getDept" title="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加职工</a></li>
			</ul></li>

		<li><input type="radio" name="tab1" id="tab1c" class="tabs"><label
			for="tab1c" class="open" accesskey="6"><img
				src="<%=path %>/images/icon13.png" alt="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;供货商管理</label> <input
			type="radio" name="tab1" id="tab1cc" class="tabs close"><label
			for="tab1cc" class="close" accesskey="7"><img
				src="<%=path %>/images/icon13.png" alt=""></label>
			<ul>
				<li><a target="right" href="<%=path %>/SupplierServlet?tag=getAll" title="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核供货商</a></li>
				<li><a target="right" href="<%=path %>/zsupplier/add.jsp" title="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加供货商</a></li>
			</ul></li>

		<li><input type="radio" name="tab1" id="tab1d" class="tabs"><label
			for="tab1d" class="open" accesskey="8"><img
				src="<%=path %>/images/icon13.png" alt="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户管理</label> <input
			type="radio" name="tab1" id="tab1dc" class="tabs close"><label
			for="tab1dc" class="close" accesskey="9"><img
				src="<%=path %>/images/icon13.png" alt=""></label>
			<ul>
				<li><a target="right" href="<%=path %>/ClientServlet?tag=getAll" title="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户审核</a></li>
				<li><a target="right" href="<%=path %>/zclient/add.jsp" title="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加客户</a></li>
			</ul></li>

		<li><input type="radio" name="tab1" id="tab1e" class="tabs"><label
			for="tab1e" class="open" accesskey="F"><img
				src="<%=path %>/images/i04.png" alt="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;进货单管理</label> <input
			type="radio" name="tab1" id="tab1ec" class="tabs close"><label
			for="tab1ec" class="close" accesskey="G"><img
				src="<%=path %>/images/i04.png" alt=""></label>
			<ul>
				<li><a target="right" href="<%=path %>/PurchaseServlet?tag=getAll">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核进货单</a></li>
				<li><a target="right" href="<%=path %>/PurchaseServlet?tag=getSup&username=<%=username%>">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加进货单</a></li>
			</ul></li>

		<li><input type="radio" name="tab1" id="tab1f" class="tabs"><label
			for="tab1f" class="open" accesskey="F"><img
				src="<%=path %>/images/icon16.png" alt="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品管理</label> <input
			type="radio" name="tab1" id="tab1fc" class="tabs close"><label
			for="tab1fc" class="close" accesskey="G"><img
				src="<%=path %>/images/icon16.png" alt=""></label>
			<ul>
				<li><a target="right" href="<%=path %>/ProductServlet?tag=getAll">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品查询</a></li>
				<li><a target="right" href="<%=path %>/zproduct/add.jsp">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加商品</a></li>
			</ul></li>

		<li><input type="radio" name="tab1" id="tab1g" class="tabs"><label
			for="tab1g" class="open" accesskey="F"><img
				src="<%=path %>/images/icon17.png" alt="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单管理</label> <input
			type="radio" name="tab1" id="tab1gc" class="tabs close"><label
			for="tab1gc" class="close" accesskey="G"><img
				src="<%=path %>/images/icon17.png" alt=""></label>
			<ul>
				<li><a target="right" href="<%=path %>/OrderServlet?tag=getAll">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核订单</a></li>
				<li><a target="right" href="<%=path %>/OrderServlet?tag=getCP&username=<%=username%>">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加订单</a></li>
			</ul></li>

		<li><input type="radio" name="tab1" id="tab1h" class="tabs"><label
			for="tab1h" class="open" accesskey="F"><img
				src="<%=path %>/images/icon11.png" alt="">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理员管理</label> <input
			type="radio" name="tab1" id="tab1hc" class="tabs close"><label
			for="tab1hc" class="close" accesskey="G"><img
				src="<%=path %>/images/icon11.png" alt=""></label>
			<ul>
				<li><a target="right" href="<%=path %>/UserServlet?tag=getAll">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查询管理员</a></li>
				<li><a target="right" href="<%=path %>/zusers/add.jsp">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新增管理员</a></li>
			</ul></li>

	</ul>
</body>
</html>

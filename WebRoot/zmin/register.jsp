<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String reminname = (String) request.getAttribute("remindname");
if(reminname == null){
	reminname = "";
}
String reminpass0 = (String) request.getAttribute("remindpass0");
if(reminpass0 == null){
	reminpass0 = "";
}
String reminpass = (String) request.getAttribute("remindpass");
if(reminpass == null){
	reminpass = "";
}
request.removeAttribute("remindname");
request.removeAttribute("remindpass0");
request.removeAttribute("remindpass");
%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <base href="<%=basePath%>">
    
    <title>register</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
	<link rel="stylesheet" href="<%=path %>/css/pintuer.css">
	<link rel="stylesheet" href="<%=path %>/css/admin.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/passCheck.css" />
	<style type=text/css>
		#passwordStrengthDiv{height:7px; margin:6px 0 8px 100px}
		body{
		background:url(images/2-1.jpg);
		background-size: 100% 130%;
	}
	</style>
	<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=path %>/js/ajax.js"></script>
	<script type="text/javascript" src="<%=path %>/js/pintuer.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.passwordStrength.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#pass1').passwordStrength();
	});
	</script>
  </head>
  
  <body onloadstart="">
  <div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height:150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
																				<!-- onsubmit="return check()" -->
				<form action="${pageContext.request.contextPath }/LoginServlet?tag=register" method="post" >
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>用户注册</h1>
						</div>
						<div class="panel-body"
							style="padding:30px; padding-bottom:10px; padding-top:10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="name"  
									id="username" placeholder="注册账号" data-validate="required:请填写账号" />
										<span class="icon icon-user margin-small" id="nameMess"></span>
								</div>
								<!-- <span id="nameMess"></span> -->
								<font color="red" id="v1"><%=reminname %></font>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										placeholder="登录密码" data-validate="required:请填写密码" id="pass1"/>
										<span class="icon icon-key margin-small"></span>
								</div>
								<font color="red" id="v2"><%=reminpass0 %></font>
								<div id="passwordStrengthDiv" class="is0"></div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password2" 
										placeholder="确认密码" data-validate="required:请确认密码&nbsp;" id="pass2"/>
										<span class="icon icon-key margin-small"></span>
								</div>
								<font color="red" style="margin-top:3px;"><%=reminpass %></font>
							</div>
							<div>
								<input type="submit"
									class="button button-block bg-main text-big input-big"
									value="注册">&nbsp;
								<input type="reset"
									class="button button-block bg-main text-big input-big"
									value="重置">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	function myrefresh(){
		var v1 = "<%=reminname %>";
		var v2 = "<%=reminpass0 %>";
		var v3 = "<%=reminpass %>";
		// alert(v1+"--"+v2+"--"+v3);
		if((va != "") || (va != "") || (va != "")){
			<%
			reminname = "";
			reminpass0 = "";
			reminpass = "";
			%>
   			window.location.href="register.jsp";
		}
	}
	setTimeout('myrefresh()',4000); //指定1秒刷新一次
	</script>
  </body>
</html>

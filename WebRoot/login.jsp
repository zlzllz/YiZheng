<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>login</title>
<link href="<%=path %>/css/jquery.idcode.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css" type="text/css">
<script type="text/javascript">
	function toRegister(){
		window.location.href="zmin/register.jsp";
	}
</script>
<style type=text/css>
	body{
		background:url(images/2-1.jpg);
		background-size: 100% 138%;
	}
</style>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height:150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="${pageContext.request.contextPath }/LoginServlet?tag=login" method="post" onsubmit=" return begin()">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
						<h1>用户登录</h1>
						</div>
						<div class="panel-body"
							style="padding:30px; padding-bottom:10px; padding-top:10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="name"
										placeholder="登录账号" data-validate="required:请填写账号" id="name"/><span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"  id="pass1"
										placeholder="登录密码" data-validate="required:请填写密码" /><span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" id ="Txtidcode" style="width:255px;height:38px;"/>
									&nbsp;<span id="idcode" style="width:70px;height:38px;"></span>
								</div>
							</div>
							<div>
								<input type="submit" value="登录"
									class="button button-block bg-main text-big input-big" />&nbsp;&nbsp;&nbsp;
								<input type=button value="注册" onclick="toRegister()"
									class="button button-block bg-main text-big input-big" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
<script src="<%=path %>/js/jquery-1.12.3.min.js"></script>
<!--//引用idcode插件-->
<script src="<%=path %>/js/jquery.idcode.js"></script>
<script>
    $.idcode.setCode();  //加载生成验证码方法
    function begin(){
	    var IsBy = $.idcode.validateCode();  //调用返回值，返回值结果为true或者false
	        /* if(IsBy){
	            alert("验证码输入正确")
	        }else {
	            alert("请重新输入")
	        } */
	    return IsBy;
    }
</script>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>errorPage</title>
    <link rel="stylesheet" href="<%=path %>/css/error.css">
  </head>
  <body>
    <div class="container">
      <h2>当前访问用户过多，请稍后再试。</h2>
      <p>错误原因可能如下：</p>
      <ul>
        <li>网络信号差</li>
        <li>请求资源不存在</li>
        <li>输入的网址不正确</li>
        <li>数据输入不合格</li>
      </ul>
	<p><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="goto1()" value="返回首页" class="aa"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="goto2()" value="返回上一页" class="aa"/>
	</p>
    </div>
<script type="text/javascript">
function goto1(){
	window.location.href="<%=path %>/zmin/index.jsp";
}

function goto1(){
	window.history.go(-1);
}
</script>
  </body>
</html>

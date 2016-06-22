<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>有你，就好</title>
<%@include file="../../js.jsp"%>
<link rel="icon" href="<%=request.getContextPath()%>/resources/images/favicon.ico" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/consumer/login/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function refreshImg(){
        $ ('#validCodeImg').get (0).src = $ ('#validCodeImg').get (0).src+"?temp=" + Math.random ();
}

</script>
</head>
<body>
	<div class="login-box">
		<h1>100mone.com</h1>
		<form method="post" action="<%=request.getContextPath()%>/consumer/login.do">
			<div class="name">
				<label>登录名：</label> <input type="text" name="username" />
			</div>
			<div class="password">
				<label>密　码：</label> <input type="password" name="password" maxlength="16" tabindex="2" />
			</div>
			<div class="code">
				<label>验证码：</label> <input type="text" name="" maxlength="4" id="code" tabindex="3" />
				<div class="codeImg">
					<img src="<%=request.getContextPath()%>/consumer/validateCode.do" id="validCodeImg" onclick="refreshImg()" />
				</div>
			</div>
			<div class="remember">
				<p>&nbsp;</p>
				<p>&nbsp;</p>
			</div>
			<div class="login">
				<button type="submit" tabindex="5">登录</button>
			</div>
		</form>
	</div>
	<div class="centre">
		新用户&nbsp;<a href="<%=request.getContextPath()%>/consumer/register.do">注册</a>&nbsp;这里
	</div>
	<div class="bottom">
		©2014 Leting <a href="javascript:;" target="_blank">关于</a> <span>ICP证号</span>
	</div>
	<div class="screenbg">
		<ul>
			<li><a href="javascript:;"><img src="<%=request.getContextPath()%>/resources/images/2.jpg"></a></li>
		</ul>
	</div>
	<div style="text-align: center;"></div>
</body>
</html>

<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../js.jsp"%>
<title>100MONE欢迎您！</title>
</head>

<body>
	<%@include file="home/header.jsp"%>


	<div style="height: 90px;">
		<form action="#" method="post">
			用户名：<input type="text" name="user.username" /> 密码：<input type="text"
				name="user.plain_text" /> 邮箱：<input type="text" name="user.email" />
			手机号：<input type="text" name="user.mobile_phone" />
		</form>
	</div>
	<%@include file="home/footer.jsp"%>
</body>
</html>
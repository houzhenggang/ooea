<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../js.jsp"%>
<title>100MONE欢迎您！</title>
<link href="<%=request.getContextPath()%>/resources/css/register.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<%@include file="home/header.jsp"%>
	<div id="centre">
		<%@include file="home/centre.jsp"%>
		<div class="centre-left"></div>
		<div class="centre-right">
			<form action="#" method="post">
				<table>
					<tr>
						<td class="t-left">用户名</td>
						<td><span>*</span><input type="text" name="user.username" /></td>
					</tr>
					<tr>
						<td class="t-left">密码</td>
						<td><span>*</span><input type="password" name="user.plain_text" /></td>
					</tr>
					<tr>
						<td class="t-left">邮箱</td>
						<td><span>*</span><input type="text" name="user.email" /></td>
					</tr>
					<tr>
						<td class="t-left">手机号</td>
						<td><span>*</span><input type="text" name="user.mobile_phone" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="home/footer.jsp"%>
</body>
</html>
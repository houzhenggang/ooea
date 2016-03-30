<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../../js.jsp"%>
<title>欢迎您！</title>
<link href="<%=request.getContextPath()%>/resources/css/register.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/comsumer/consumer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-2.2.0.min.js"></script>
</head>
<body>
	<%@include file="../header.jsp"%>

	<%@include file="../footer.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Treasury</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/jquery.js"></script>
</head>
<div class="site-title">Treasury Manager</div>
<div class="header-panel">
	<div class="header-tab">
		<a href="${pageContext.request.contextPath}/users">Users</a>
	</div>
	<div class="header-tab">
		<a href="${pageContext.request.contextPath}/payments">Payments</a>
	</div>
	<div class="header-tab">
		<a href="#">Dashboard</a>
	</div>
</div>

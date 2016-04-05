<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
<%@include file="Header.jsp" %>
<form action="create" method="post">
	<div align="center" class="users-table">
		<div class="row">
			<input name="name" type="text" placeholder="Name"/>
		</div>
		<div class="row">
			<input name="flatNo" type="text" placeholder="Flat No"/>
		</div>
		<div class="row">
			<input name="contactNo" type="text" placeholder="Contact No"/>
		</div>
		<div class="row">
			<button type="submit">Add</button>
		</div>
	</div>
</form>
<c:if test="${message!=null}">
	<div class="message">${message}</div>
</c:if>
</body>
</html>
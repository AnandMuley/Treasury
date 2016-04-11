<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<div class="users-container">
		<form action="${pageContext.request.contextPath}/users/create"
			method="post">
			<div align="center" class="users-table">
				<div class="row">
					<input name="name" type="text" placeholder="Name" />
				</div>
				<div class="row">
					<input name="flatNo" type="text" placeholder="Flat No" />
				</div>
				<div class="row">
					<input name="contactNo" type="text" placeholder="Contact No" />
				</div>
				<div class="row">
					<button type="submit">Add</button>
				</div>
			</div>
		</form>
		<c:if test="${message!=null}">
			<div class="message">${message}</div>
		</c:if>
	</div>
	<c:if test="${fn:length(users)>0}">
		<div class="users-table-container">
			<table>
				<thead>
					<tr>
						<td>Sr.No</td>
						<td>Name</td>
						<td>FlatNo</td>
						<td>ContactNo</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user" varStatus="stat">
						<tr>
							<td>${stat.index+1}</td>
							<td>${user.name}</td>
							<td>${user.flatNo}</td>
							<td>${user.contactNo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
</body>
</html>
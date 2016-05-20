<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Users.js"></script>
</head>
<body>
	<%@include file="Header.jsp"%>
	<div class="users-container">
		<c:if test="${userDto.validationErrors.size()>0}">
			<div class="error-container">
				<c:forEach items="${userDto.validationErrors}" var="errorMsg">
					<div class="msg">${errorMsg}</div>
				</c:forEach>
			</div>
		</c:if>
		<form id="usrAddEditFrm" action="${pageContext.request.contextPath}/users/create" method="post">
			<input id="userID" type="hidden" name="id" value="0"/>
			<input id="usrEditLink" type="hidden" value="${pageContext.request.contextPath}/users/save"/>
			<input id="usrAddLink" type="hidden" value="${pageContext.request.contextPath}/users/create"/>
			<div align="center" class="users-table">
				<div class="row">
					<input value="${userDto.name}" required="required" id="name" name="name" type="text" placeholder="Name"/>
				</div>
				<div class="row">
					<input value="${userDto.flatNo}" id="flatNo" name="flatNo" type="text" placeholder="Flat No"/>
				</div>
				<div class="row">
					<input value="${userDto.contactNo}" required="required" id="contactNo" name="contactNo" type="text" placeholder="Contact No"/>
				</div>
				<div class="row">
					<input id="area" value="${userDto.area}" required="required" name="area" type="text" placeholder="Area in Sq.Ft"/>
				</div>
				<div class="row">
					<button id="addBtn" type="button">ADD</button>
					<button id="saveBtn" type="button">SAVE</button>
				</div>
			</div>
		</form>
		<c:if test="${message!=null}">
			<div class="message">${message}</div>
		</c:if>
	</div>
	<form id="userDelFrm" action="${pageContext.request.contextPath}/users/delete" method="post">
		<input id="uid" type="hidden" name="id" value="0"/>
	</form>
	<c:if test="${fn:length(users)>0}">
		<div class="users-panel-container">
			<div class="panel-header">Existing Users</div>
			<c:forEach items="${users}" var="user" varStatus="stat">
				<div class="panel-item">
					<div class="name">${user.name}</div>
					<div class="contact-no"><span>Mob:</span> ${user.contactNo}</div>
					<div class="flat-no"><span>Flat No:</span> ${user.flatNo}</div>
					<div class="actions-panel">
						<div class="edit" title="${user.name}|${user.flatNo}|${user.contactNo}|${user.id}|${user.area}">
							<img width="20" alt="" src="${pageContext.request.contextPath}/resources/images/document_edit.png">
						</div>
						<div class="delete" title="${user.id}">
							<img width="20" alt="" src="${pageContext.request.contextPath}/resources/images/delete.png">
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>
<%-- 	<table border="1">
			<c:forEach items="${moycoms}" var="moycom" varStatus="stat">
					<c:if test="${stat.index%4==0 && stat.index!=0}">
						<tr>
					</c:if>
						<td>${moycom['information']}</td>
					<c:if test="${stat.index%4==0 && stat.index!=0}">
						</tr>
					</c:if>
			 </c:forEach>
    </table>  --%>
	
	<%-- <div class="edit-user-container">
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
	</div> --%>
</body>
</html>
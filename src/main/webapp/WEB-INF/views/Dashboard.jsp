<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
<%@include file="Header.jsp" %>
</head>
<body>
<div class="date-panel">
	<div class="label">Start Date</div>
	<div class="value">${dashboardDto.startDt}</div>
</div>

<div class="amount-panel">
	<div class="label">Expected Amount</div>
	<div class="value">&#x20B9; ${dashboardDto.expectedAmount}</div>
</div>
<c:if test="${fn:length(dashboardDto.userDtos)>0}">
	<div class="finance-table-title">Finances Dues</div>
	<table class="finance-table">
		<thead>
			<tr>
				<td>Sr.No</td>
				<td>Name</td>
				<td>Amount Due</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dashboardDto.userDtos}" var="user" varStatus="stat">
			<tr>
				<td width="10%">${stat.index+1}</td>
				<td width="60%">${user.name}</td>
				<td>${user.amountDue}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<c:if test="${fn:length(dashboardDto.userDtos)==0}">
	<div style="top: 30px;position: relative;" align="center">No details</div>
</c:if>
</body>
</html>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reports</title>
<%@include file="Header.jsp" %>
</head>
<body>
<div class="payment-transactions-container">
	<table>
		<thead>
			<tr>
				<td>Sr.No</td>
				<td>Name</td>
				<td>Amount</td>
				<td>PaymentDt</td>
				<td>Mode</td>
				<td>From</td>
				<td>To</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${report.paymentDtos}" var="payment" varStatus="stat">
				<tr>
					<td>${stat.index+1}</td>
					<td>${payment.name}</td>
					<td>${payment.amount}</td>
					<td>${payment.paymentDt}</td>
					<td>${payment.mode}</td>
					<td>${payment.fromDateDto.monthName}-${payment.fromDateDto.year}</td>
					<td>${payment.toDateDto.monthName}-${payment.toDateDto.year}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>
</body>
</html>
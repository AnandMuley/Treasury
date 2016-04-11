<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
<%@include file="Header.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Payment.js"></script>
</head>
<body>
<div align="center" class="payments-container">
<div align="center" class="payments-table">
	<form action="${pageContext.request.contextPath}/payments/add" method="post">
			<div class="row">
				<select id="usersel" name="userId">
					<option value="">Select User</option>
					<c:forEach items="${users}" var="user">
						<option value="${user.id}">${user.name}</option>		
					</c:forEach>
				</select>
			</div>
			<div class="row">
				<div class="col-3" style="padding-top: 8px;">
					<span class="text-label">Mode</span>			
				</div>
				<div class="col-7" style="text-align: left;">
					<select id="mode" name="mode">
						<option value="select">Select Mode</option>
						<option value="cheque">Cheque</option>
						<option value="cash">Cash</option>
						<option value="netbanking">Net Banking</option>
					</select>
				</div>
				<br clear="all">
			</div>
			<div class="row">
					<input name="paymentDt" type="text" placeholder="Payment Date"/>
			</div>
			<div class="row">
					<input name="amount" type="text" placeholder="Amount"/>
			</div>
			<div id="cheque">
				<div class="row">
					<input name="chequeDto.bankDetails" type="text" placeholder="Bank or Branch Name"/>
				</div>
				<div class="row">
					<input name="chequeDto.chequeNo" type="text" placeholder="Cheque No"/>
				</div>
				<div class="row">
					<input name="chequeDto.chequeDt" type="text" placeholder="Submitted Date"/>
				</div>
			</div>
			<div id="netbanking">
				<div class="row">
					<input name="netBankingDto.referenceNo" type="text" placeholder="Reference No"/>
				</div>
				<div class="row">
					<input name="netBankingDto.accountNo" type="text" placeholder="Account No"/>
				</div>
				<div class="row">
					<input name="netBankingDto.bankDetails" type="text" placeholder="Bank Details"/>
				</div>
			</div>
			<div id="cash">
				<!-- Do nothing -->
			</div>
			<div class="row">
					<button type="submit">Add</button>
			</div>
	</form>
</div>
	<c:if test="${message!=null}">
		<div class="payment-message">${message}</div>
	</c:if>
</div>
</body>
</html>
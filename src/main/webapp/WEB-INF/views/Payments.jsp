<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
<%@include file="Header.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Payment.js"></script>
</head>
<body>
<form action="payments/add" method="post">
	<div align="center" class="payments-table">
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
		<div id="cheque">
			<div class="row">
				<input name="chequeDto.date" type="text" placeholder="Date"/>
			</div>
			<div class="row">
				<input name="chequeDto.bankDetails" type="text" placeholder="Bank or Branch Name"/>
			</div>
			<div class="row">
				<input name="chequeDto.chequeNo" type="text" placeholder="Cheque No"/>
			</div>
			<div class="row">
				<input name="chequeDto.amount" type="text" placeholder="Amount"/>
			</div>
			<div class="row">
				<input name="chequeDto.submittedDt" type="text" placeholder="Submitted Date"/>
			</div>
			<div class="row">
				<button type="submit">Add</button>
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
				<input name="netBankingDto.date" type="text" placeholder="Date"/>
			</div>
			<div class="row">
				<input name="netBankingDto.amount" type="text" placeholder="Amount"/>
			</div>
			<div class="row">
				<input name="netBankingDto.bankDetails" type="text" placeholder="Bank Details"/>
			</div>
			<div class="row">
				<button type="submit">Add</button>
			</div>
		</div>
		<div id="cash">
			<div class="row">
				<input name="cashDto.date" type="text" placeholder="Date"/>
			</div>
			<div class="row">
				<input name="cashDto.amount" type="text" placeholder="Amount"/>
			</div>
			<div class="row">
				<button type="submit">Add</button>
			</div>
		</div>
	</div>
</form>
<c:if test="${message!=null}">
	<div class="message">${message}</div>
</c:if>
</body>
</html>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payments</title>
<%@include file="Header.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Payment.js"></script>
</head>
<body>
<div class="payments-error-msg-container">
	<c:if test="${paymentDto.validationErrors.size()>0}">
		<div class="error-container">
			<c:forEach items="${paymentDto.validationErrors}" var="errorMsg">
				<div class="msg">${errorMsg}</div>
			</c:forEach>
		</div>
	</c:if>
</div>
<div class="user-paydetails-container">
	
</div>
<div align="center" class="payments-container">
<div align="center" class="payments-table">
	<form action="${pageContext.request.contextPath}/payments/add" method="post">
			<div class="row">
				<select id="usersel" name="userId">
					<option value="">Select User</option>
					<c:forEach items="${users}" var="user">
						<c:choose>
							<c:when test="${user.id==paymentDto.userId}">
								<option selected="selected" value="${user.id}">${user.name}</option>
							</c:when>
							<c:otherwise>
								<option value="${user.id}">${user.name}</option>							
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="row text-label">From Date</div>
			<div class="row">
				<select id="fromMonth" name="fromDateDto.month">
					<option selected="selected" value="${paymentDto.fromDateDto.month}">${paymentDto.fromDateDto.monthName}</option>
					<option value="1">Jan</option>
					<option value="2">Feb</option>
					<option value="3">Mar</option>
					
					<option value="4">Apr</option>
					<option value="5">May</option>
					<option value="6">Jun</option>
					
					<option value="7">Jul</option>
					<option value="8">Aug</option>
					<option value="9">Sep</option>
					
					<option value="10">Oct</option>
					<option value="11">Nov</option>
					<option value="12">Dec</option>
				</select>
				<select id="fromYear" name="fromDateDto.year">
					<option selected="selected" value="${paymentDto.fromDateDto.year}">${paymentDto.fromDateDto.year}</option>
					<option value="2015">2015</option>
					<option value="2016">2016</option>
				</select>
			</div>
			<div class="row text-label">To Date</div>
			<div class="row">
				<select id="toMonth" name="toDateDto.month">
					<option selected="selected" value="${paymentDto.toDateDto.month}">${paymentDto.toDateDto.monthName}</option>
					<option value="1">Jan</option>
					<option value="2">Feb</option>
					<option value="3">Mar</option>
					
					<option value="4">Apr</option>
					<option value="5">May</option>
					<option value="6">Jun</option>
					
					<option value="7">Jul</option>
					<option value="8">Aug</option>
					<option value="9">Sep</option>
					
					<option value="10">Oct</option>
					<option value="11">Nov</option>
					<option value="12">Dec</option>
				</select>
				<select id="toYear" name="toDateDto.year">
					<option selected="selected" value="${paymentDto.toDateDto.year}">${paymentDto.toDateDto.year}</option>
					<option value="2015">2015</option>
					<option value="2016">2016</option>
				</select>
			</div>
			<div class="row">
				<div class="col-3" style="padding-top: 8px;">
					<span class="text-label">Mode</span>			
				</div>
				<div class="col-7" style="text-align: left;">
					<select id="mode" name="mode">
						<c:if test="${paymentDto.mode!=null}">
							<option selected="selected" value="${paymentDto.mode}">${paymentDto.mode}</option>
						</c:if>
						<option value="cash">Cash</option>
						<option value="cheque">Cheque</option>
						<option value="netbanking">Net Banking</option>
					</select>
				</div>
				<br clear="all">
			</div>
			<div class="row">
					<input value="${paymentDto.paymentDt}" name="paymentDt" type="text" placeholder="Payment Date"/>
			</div>
			<div class="row">
					<input value="${paymentDto.amount}" name="amount" type="text" placeholder="Amount"/>
			</div>
			<div id="cheque">
				<div class="row">
					<input value="${paymentDto.chequeDto.bankDetails}" name="chequeDto.bankDetails" type="text" placeholder="Bank or Branch Name"/>
				</div>
				<div class="row">
					<input value="${paymentDto.chequeDto.chequeNo}" name="chequeDto.chequeNo" type="text" placeholder="Cheque No"/>
				</div>
				<div class="row">
					<input name="chequeDto.chequeDt" type="text" placeholder="Submitted Date"/>
				</div>
			</div>
			<div id="netbanking">
				<div class="row">
					<input value="${paymentDto.netBankingDto.referenceNo}" name="netBankingDto.referenceNo" type="text" placeholder="Reference No"/>
				</div>
				<div class="row">
					<input value="${paymentDto.netBankingDto.accountNo}" name="netBankingDto.accountNo" type="text" placeholder="Account No"/>
				</div>
				<div class="row">
					<input value="${paymentDto.netBankingDto.bankDetails}" name="netBankingDto.bankDetails" type="text" placeholder="Bank Details"/>
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
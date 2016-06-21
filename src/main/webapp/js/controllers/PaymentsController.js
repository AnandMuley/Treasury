controllers.controller('PaymentsController',
		['$scope','PaymentResource','LoginService','$rootScope',
		 function($scope,Payment,loginService,$rootScope){

	loginService.isUserLoggedIn();
	
	function createNewPayment(){
		return new Payment({
			mode:'cash',
			residentId:'select',
			fromDateDto:null,
			toDateDto:null,
			mode:'paymentMode'});
	}

	$scope.payment = createNewPayment();
	
	$scope.loadBalanceCard = function(){
		var createdBy = $rootScope.auth.id;
		var residentId = $scope.payment.residentId;
		var balanceRes = createNewPayment();
		var balance = balanceRes.$balance({residentId:residentId,createdBy:createdBy},function(data){
			$scope.balance = data;
		});
	}
	
	
	$scope.savePayment = function(){
		$scope.payment.toDateDto.year = $scope.payment.fromDateDto.year;
		$scope.payment.$save(function(){
			$scope.message = "Details saved successfully !";
			$scope.payment = createNewPayment();
		});
	}
	
}]);
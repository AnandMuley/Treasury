controllers.controller('PaymentsController',
		['$scope','PaymentResource','LoginService',
		 function($scope,Payment,loginService){
	
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
	
	$scope.savePayment = function(){
		$scope.payment.toDateDto.year = $scope.payment.fromDateDto.year;
		$scope.payment.$save(function(){
			$scope.message = "Details saved successfully !";
			$scope.payment = createNewPayment();
		});
	}
	
}]);
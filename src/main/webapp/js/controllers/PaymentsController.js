controllers.controller('PaymentsController',
		['$scope','PaymentResource','LoginService',
		 function($scope,Payment,loginService){
	
	loginService.isUserLoggedIn();
			
	$scope.payment = new Payment({
		mode:'cash',
		residentId:'select',
		fromDateDto:null,
		toDateDto:null,
		mode:'paymentMode'});
	
	$scope.savePayment = function(){
		$scope.payment.toDateDto.year = $scope.payment.fromDateDto.year;
		$scope.payment.$save(function(){
			$scope.message = "Details saved successfully !";
		});
	}
	
}]);
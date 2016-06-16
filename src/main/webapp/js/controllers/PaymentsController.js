controllers.controller('PaymentsController',['$scope','PaymentResource',function($scope,Payment){
	
	$scope.payment = new Payment({
		mode:'cash',
		userId:'select',
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
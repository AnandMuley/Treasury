controllers.controller('PaymentsController',['$scope',function($scope){
	
	$scope.payment = {
			mode:'cash',
			userId:'select',
			fromMonth:'from',
			toMonth:'to',
			mode:'default'
	};
	
}]);
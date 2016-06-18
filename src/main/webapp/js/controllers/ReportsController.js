controllers.controller('ReportsController',
		['$scope','ReportsResource','LoginService',
		 function($scope,Report,loginService){

	loginService.isUserLoggedIn();
			
	var paymentReports = Report.query(function(){
		$scope.reports = paymentReports;
	});
	
}]);
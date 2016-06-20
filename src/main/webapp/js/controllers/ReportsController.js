controllers.controller('ReportsController',
		['$scope','ReportResource','LoginService','$rootScope',
		 function($scope,Report,loginService,$rootScope){

	loginService.isUserLoggedIn();
			
	var paymentReports = Report.query({createdBy:$rootScope.auth.id},function(){
		$scope.reports = paymentReports;
	});
	
}]);
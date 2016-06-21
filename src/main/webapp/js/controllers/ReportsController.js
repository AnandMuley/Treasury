controllers.controller('ReportsController',
		['$scope','ReportResource','LoginService','$rootScope',
		 function($scope,Report,loginService,$rootScope){

	loginService.isUserLoggedIn();
			
	var paymentReports = Report.query({createdBy:$rootScope.auth.id},function(){
		$scope.reports = paymentReports;
	});
	
	$scope.findTotal = function(){
		var tot = 0;
		var paymentDtos = $scope.reports.paymentDtos;
		for(var i=0;i<paymentDtos.length;i++){
			var report = paymentDtos[i];
			if(report.name.toLowerCase().indexOf($scope.filterText.toLowerCase())!=-1){
				tot = tot + report.amount;
			}
		}
		$scope.total=tot;
	}

}]);
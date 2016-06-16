controllers.controller('ReportsController',['$scope','ReportsResource',function($scope,Report){

	var paymentReports = Report.query(function(){
		$scope.reports = paymentReports;
	});
	
}]);
controllers.controller('DuesController',['$scope','DuesResource',function($scope,Dues){
	
	var allDues = Dues.query(function(){
		$scope.dues = allDues;
	});
	
}]);
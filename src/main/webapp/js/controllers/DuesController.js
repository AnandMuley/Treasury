controllers.controller('DuesController',
		['$scope','DuesResource','LoginService',
		 function($scope,Dues,loginService){
			
	loginService.isUserLoggedIn();
	
	var allDues = Dues.query(function(){
		$scope.dues = allDues;
	});
	
}]);
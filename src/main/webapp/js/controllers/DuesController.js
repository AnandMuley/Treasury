controllers.controller('DuesController',
		['$scope','DuesResource','LoginService','$rootScope',
		 function($scope,Dues,loginService,$rootScope){
			
	loginService.isUserLoggedIn();
	
	var allDues = Dues.query({createdBy:$rootScope.auth.id},function(){
		$scope.dues = allDues;
	});
	
}]);
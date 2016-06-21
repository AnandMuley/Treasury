controllers.controller('LoginController',
		['$scope','UsersResource','$rootScope','$location','$rootScope','LoginService',
		 function($scope,User,$rootScope,$location,$rootScope,loginService){

	$scope.user = new User();
	$scope.success = false;
			
	$scope.save = function(){
		$scope.user.$save(function(){
			$scope.message = "Registration successful !";
			$scope.user = new User();
		});
	}
	
	$scope.authUser = function(){
		var username = $scope.user.username;
		var password = $scope.user.password;
		$scope.user.$findUser({username:username,password:password},function(value,responseHeaders){
				if(value.id!=null){
					$rootScope.authenticated=true;
					$rootScope.auth = {
							id:value.id
					}
					loginService.addAuthCookie(value);
					$location.path('/residents');
					$scope.success=true;
				}else{
					$scope.message = "Invalid Credentials !";
				}
		});
	}
	
}]);
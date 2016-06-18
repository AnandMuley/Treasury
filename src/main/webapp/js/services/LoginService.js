services.service('LoginService',
		['$location','$rootScope',function($location,$rootScope){
	
	this.isUserLoggedIn = function(){
		if($rootScope.authenticated==false||$rootScope.authenticated==undefined){
			$location.path('/');
		}
	}
	
}]);
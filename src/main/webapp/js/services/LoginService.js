services.service('LoginService',
		['$location','$rootScope','$cookies',
		 function($location,$rootScope,$cookies){
	const COOKIE_AUTH = "auth";
			
	this.addAuthCookie = function(user){
		var expiryDate = new Date();
		expiryDate.setMinutes(expiryDate.getMinutes()+15);
		$cookies.putObject(COOKIE_AUTH,user,{expires:expiryDate});
	}
			
	this.removeAuthCookie = function(){
		$cookies.remove(COOKIE_AUTH);
	}
	
	this.isUserLoggedIn = function(){
		var auth = $cookies.getObject(COOKIE_AUTH);
		if(auth!=undefined){
			$rootScope.authenticated = true;
			$rootScope.auth = {
					id:auth.id
			};
		}else{
			$rootScope.authenticated = false;
			$location.path('/');
		}
	}
	
}]);
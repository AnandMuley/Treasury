controllers.controller('SettingsController',
		['$scope','SettingsResource','$rootScope','LoginService',
		 function($scope,Setting,$rootScope,loginService){

	loginService.isUserLoggedIn();
			
	$scope.setting = Setting.query({createdBy:$rootScope.auth.id});
	
	$scope.save = function(){
		if($scope.setting.createdBy!=undefined){
			$scope.setting.$update({createdBy:$rootScope.auth.id},function(value){
				$scope.message = "Details saved successfully !";
			});
		}else{
			$scope.setting.createdBy = $rootScope.auth.id;
			$scope.setting.$save({createdBy:$rootScope.auth.id},function(value){
				$scope.message = "Setting created successfully !";
			});
		}
		
	}
	
}]);
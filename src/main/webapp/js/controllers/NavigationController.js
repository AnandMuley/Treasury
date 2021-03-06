controllers.controller('NavigationController',
		['$scope','$location','$rootScope','LoginService',
		 function($scope,$location,$rootScope,loginService){
	
	$scope.tabs = [{
		name : 'residents',
		path : 'residents'
	},{
		name : 'payments',
		path : 'payments'
	},{
		name : 'reports',
		path : 'reports'
	},{
		name : 'dues',
		path : 'dues'
	},{
		name : 'settings',
		path : 'settings'
	}];
	
	$scope.getSelectedTab = function(path){
		var len=$scope.tabs.length;
		for(var i=0;i<len;i++){
			if($scope.tabs[i].path==path){
				return i;
			}
		}
		return 0;
	}
	
	$scope.selectedTab = $scope.getSelectedTab($location.path().substring(1,$location.path().length));
	
	$scope.loadView = function(tab){
		$location.path(tab.path);
	}
	
	$scope.logout = function(){
		$rootScope.authenticated=false;
		loginService.removeAuthCookie();
		$location.path('/');
	}
	
}]);
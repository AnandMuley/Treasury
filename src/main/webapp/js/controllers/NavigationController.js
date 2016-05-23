controllers.controller('NavigationController',['$scope',function($scope){
	$scope.currentTab = '';
	$scope.changeTab = function(tabname){
		$scope.currentTab = tabname;
	}
}]);
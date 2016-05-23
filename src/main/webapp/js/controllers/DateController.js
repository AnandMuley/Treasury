controllers.controller('DateController',['$scope',function($scope){
	
	$scope.months = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	
	$scope.years = [];
	
	function populateYears(){
		for(var i=2016;i<2026;i++){
			$scope.years.push(i);
		}
	}
	
	populateYears();
	
}]);
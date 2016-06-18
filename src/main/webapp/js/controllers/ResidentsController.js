controllers.controller('ResidentsController',
		['$scope','ResidentResource','LoginService',
		 function($scope,Resident,loginService){
	
	loginService.isUserLoggedIn();
			
	$scope.resident = {};
	$scope.modeTypes = {
			add:{title:'Add Resident',type:'add'},
			edit:{title:'Edit Resident',type:'edit'}
	}
	$scope.modeType = $scope.modeTypes['add'];
	
	var residents = Resident.query(function(){
		$scope.residents = residents;
	});
	
	$scope.resetmodeType = function(){
		$scope.modeType = $scope.modeTypes['add'];
		$scope.resident = {};
	}
	
	$scope.update = function(){
		$id = $scope.resident.id;
		$scope.resident.$update({residentId:$id},$scope.resident);
	}
	
	$scope.loadResidents = function(){
		var residents = Resident.query(function(){
			$scope.residents = residents;
		});
	}
	
	$scope.delete = function(resident,$event){
		$event.stopPropagation();
		$id = resident.id;
		resident.$delete({residentId:$id},function(){
			$scope.loadResidents();
		});
	}
	
	$scope.switchToEditmodeType = function(editingResident){
		$scope.modeType = $scope.modeTypes['edit'];
		$scope.resident = editingResident;
	}
	
	$scope.add = function(){
		var newResident = new Resident({
			name:$scope.resident.name,
			flatNo:$scope.resident.flatNo,
			contactNo:$scope.resident.contactNo,
			area : $scope.resident.area});
		newResident.$save({},function(){
			$scope.resident = {};
			$scope.loadResidents();
		});
	}
	
}]);
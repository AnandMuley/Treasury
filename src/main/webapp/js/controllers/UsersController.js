controllers.controller('UsersController',['$scope','UsersResource',function($scope,User){
	
	$scope.user = {};
	$scope.modeTypes = {
			add:{title:'Add User',type:'add'},
			edit:{title:'Edit User',type:'edit'}
	}
	$scope.modeType = $scope.modeTypes['add'];
	
	var users = User.query(function(){
		$scope.users = users;
	});
	
	$scope.resetmodeType = function(){
		$scope.modeType = $scope.modeTypes['add'];
		$scope.user = {};
	}
	
	$scope.update = function(){
		$id = $scope.user.id;
		$scope.user.$update({userId:$id},$scope.user);
	}
	
	$scope.loadUsers = function(){
		var users = User.query(function(){
			$scope.users = users;
		});
	}
	
	$scope.delete = function(user,$event){
		$event.stopPropagation();
		$id = user.id;
		user.$delete({userId:$id},function(){
			$scope.loadUsers();
		});
	}
	
	$scope.switchToEditmodeType = function(editingUser){
		$scope.modeType = $scope.modeTypes['edit'];
		$scope.user = editingUser;
	}
	
	$scope.add = function(){
		var newUser = new User({
			name:$scope.user.name,
			flatNo:$scope.user.flatNo,
			contactNo:$scope.user.contactNo,
			area : $scope.user.area});
		newUser.$save({},function(){
			$scope.user = {};
			$scope.loadUsers();
		});
	}
	
}]);
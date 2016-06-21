controllers.controller('ImageController',['$scope',function($scope){
	
	$scope.getImage = function(resident){
		var image = "UserImgm.png";
		if(resident.gender=="m"){
			image = "UserImgm.png";
		}else if(resident.gender=="f"){
			image = "UserImgf.png";
		}
		return image;
	}
	
}]);
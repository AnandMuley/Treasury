var app = angular.module('Treasury',['ngRoute']);

app.config(['$routeProvider',function($routeProvider){
	$routeProvider.when('/',{
		templateUrl : 'views/Home.html',
		controller : 'HomeController'
	});
}]);
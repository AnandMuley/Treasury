var app = angular.module('Treasury',['ngRoute','ngMaterial','TreasuryServices','TreasuryControllers']);
var services = angular.module('TreasuryServices',['ngResource']);
var controllers = angular.module('TreasuryControllers',[]);

app.config(['$routeProvider','$mdIconProvider',function($routeProvider,$mdIconProvider){
	$routeProvider.when('/',{
		templateUrl : 'views/Users.html',
		controller : 'UsersController'
	}).when('/payments',{
		templateUrl : 'views/Payments.html',
		controller : 'PaymentsController'
	}).when('/users',{
		redirectTo : '/'
	});
	
	$mdIconProvider.iconSet('social','img/icons/sets/social-icons.svg',24).defaultIconSet('img/icons/sets/core-icons.svg');
	
}]).value('TreasuryRestPrefix','http://localhost:8090/Treasury/rest/');
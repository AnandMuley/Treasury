var app = angular.module('Treasury',['ngRoute','TreasuryServices','TreasuryControllers']);
var services = angular.module('TreasuryServices',['ngResource']);
var controllers = angular.module('TreasuryControllers',[]);

app.config(['$routeProvider',function($routeProvider){
	$routeProvider.when('/',{
		templateUrl : 'views/Users.html',
		controller : 'UsersController'
	}).when('/payments',{
		templateUrl : 'views/Payments.html',
		controller : 'PaymentsController'
	}).when('/users',{
		redirectTo : '/'
	});
}]).value('TreasuryRestPrefix','http://localhost:8090/Treasury/rest/');
var app = angular.module('Treasury',['ngRoute','ngMaterial','TreasuryServices','TreasuryControllers']);
var services = angular.module('TreasuryServices',['ngResource']);
var controllers = angular.module('TreasuryControllers',[]);

app.config(['$routeProvider','$mdIconProvider','$mdThemingProvider',
            function($routeProvider,$mdIconProvider,$mdThemingProvider){
	$routeProvider.when('/',{
		templateUrl : 'views/Users.html',
		controller : 'UsersController'
	}).when('/payments',{
		templateUrl : 'views/Payments.html',
		controller : 'PaymentsController'
	}).when('/users',{
		redirectTo : '/'
	}).when('/reports',{
		templateUrl:'views/Reports.html',
		controller : 'ReportsController'
	});
	
//	$mdIconProvider.iconSet('social','img/icons/sets/social-icons.svg',24).defaultIconSet('img/icons/sets/core-icons.svg');
	
	$mdThemingProvider.theme('default').primaryPalette('teal',{
		'default':'500',
		'hue-1':'300',
		'hue-2':'700',
		'hue-3':'A100'
	}).accentPalette('amber').warnPalette('red');
	
}]).value('TreasuryRestPrefix','http://localhost:8090/Treasury/rest/');
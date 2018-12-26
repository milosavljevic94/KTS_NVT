var app = angular.module('app',[require('angular-route')]);

app.config(function($routeProvider) {
	$routeProvider.when('/',
	{
		templateUrl: 'index.html'
	})
});
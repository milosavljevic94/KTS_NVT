var app = angular.module('app',['ngRoute', 'ngMap']);

app.config(function($routeProvider) {
	$routeProvider.when('/',
	{
		templateUrl: 'partials/welcome.html'
	})
});
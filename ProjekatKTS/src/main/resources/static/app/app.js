var app = angular.module('app',['ngRoute', 'ngMap']);

app.config(function($routeProvider) {
	$routeProvider.when('/',
	{
		templateUrl: 'partials/welcome.html'
	}).when('/addPolazak',
	{
		templateUrl: 'partials/addPolazak.html'
	}).when('/addStajaliste',
	{
		templateUrl: 'partials/addStajaliste.html'
	}).when('/addLinija',
	{
		templateUrl: 'partials/addLinija.html'
	}).when('/registracija',
	{
		templateUrl: 'partials/registracija.html'
	})
});
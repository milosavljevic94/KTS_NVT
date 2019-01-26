var app = angular.module('app',['ngRoute', 'ngMap']);

app.config(function($routeProvider) {
	$routeProvider.otherwise({redirectTo:'/'});
	
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
		templateUrl: 'partials/registracija.html',
	}).when('/prijava',
	{
		templateUrl: 'partials/prijava.html',
	}).when('/cenovnik',
	{
		templateUrl: 'partials/displayCenovnik.html'
	}).when('/korisnici',
	{
		templateUrl: 'partials/displayKorisnici.html'
	}).when('/korisnikDetails',
	{
		templateUrl: 'partials/korisnikDetails.html'
	})
});
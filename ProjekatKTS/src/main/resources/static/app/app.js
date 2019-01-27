var app = angular.module('app',['ngRoute', 'ngMap']);

app.config(function($routeProvider) {
	$routeProvider.otherwise({redirectTo:'/'});
	
	$routeProvider.when('/',
	{
		templateUrl: 'partials/welcome.html'
	}).when('/addPolazak',
	{
		resolve: {
			"check": function($location, $rootScope) {
				if($rootScope.tipKorisnika!=="zaposleni") {
					$location.path('/');
				}
			}
		},

		templateUrl: 'partials/addPolazak.html'
	}).when('/addStajaliste',
	{
		resolve: {
			"check": function($location, $rootScope) {
				if($rootScope.tipKorisnika!=="zaposleni") {
					$location.path('/');
				}
			}
		},

		templateUrl: 'partials/addStajaliste.html'
	}).when('/addLinija',
	{

		resolve: {
			"check": function($location, $rootScope) {
				if($rootScope.tipKorisnika!=="zaposleni") {
					$location.path('/');
				}
			}
		},

		templateUrl: 'partials/addLinija.html'
	}).when('/registracija',
	{
		resolve: {
			"check": function($location, $rootScope) {
				if($rootScope.tipKorisnika!=undefined) {
					$location.path('/');
				}
			}
		},

		templateUrl: 'partials/registracija.html',
	}).when('/prijava',
	{
		resolve: {
			"check": function($location, $rootScope) {
				if($rootScope.tipKorisnika!=undefined) {
					$location.path('/');
				}
			}
		},

		templateUrl: 'partials/prijava.html',
	}).when('/cenovnik',
	{
		resolve: {
			"check": function($location, $rootScope) {
				if($rootScope.tipKorisnika==undefined) {
					$location.path('/');
				}
			}
		},

		templateUrl: 'partials/displayCenovnik.html'
	}).when('/korisnici',
	{
		resolve: {
			"check": function($location, $rootScope) {
				if($rootScope.tipKorisnika!=="zaposleni") {
					$location.path('/');
				}
			}
		},

		templateUrl: 'partials/displayKorisnici.html'
	}).when('/korisnikDetails',
	{
		resolve: {
			"check": function($location, $rootScope) {
				if($rootScope.tipKorisnika!=="zaposleni") {
					$location.path('/');
				}
			}
		},

		templateUrl: 'partials/korisnikDetails.html'
	})
});
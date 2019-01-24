app.controller('registracijaKontroler', function($scope, $http, $rootScope, $location, $window) {

	$scope.registracija = function(korisnik) {
		korisnik.tip = "gradjanin";
		return $http.post('api/korisnik/registracija', korisnik);
	};
});
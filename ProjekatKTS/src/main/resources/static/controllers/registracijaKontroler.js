app.controller('registracijaKontroler', function($scope, $http, $rootScope, $location, $window) {

	$scope.registracija = function(korisnik) {
		korisnik.tip = "gradjanin";
		var data = $http.post('api/korisnik/registracija', korisnik);
		if (data !== null) {
			$window.location.replace("http://localhost:8080/#!/");
		} else {
			console.log("Registracija nije uspela");
		}
	};
});
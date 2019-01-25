app.controller('prijavaKontroler', function($scope, $http, $rootScope, $location, $window) {

	$scope.prijava = function(korisnik) {
		var data = $http.post('api/korisnik/login', korisnik);
		if (data !== null) {
			$window.location.replace("http://localhost:8080/#!/");
		} else {
			console.log("Prijava nije uspela");
		}
	};
});
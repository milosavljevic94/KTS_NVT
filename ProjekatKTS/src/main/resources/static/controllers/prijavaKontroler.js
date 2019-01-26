app.controller('prijavaKontroler', function($scope, $http, $rootScope, $location, $window) {

	$scope.prijava = function(korisnik) {
		$http.post('api/korisnik/login', korisnik)
		.then(function(response) {
				console.log(response.data)
				$window.location.replace("http://localhost:8080/#!/"); 
            }, function(error) {
                 console.log(error.data);
                 document.getElementById("error").innerHTML = "Prijava nije uspela, pokušajte ponovo.";
            });
	};
});
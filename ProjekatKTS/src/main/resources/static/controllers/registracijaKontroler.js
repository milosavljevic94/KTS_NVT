app.controller('registracijaKontroler', function($scope, $http, $rootScope, $location, $window) {
	
	function init() {
    	console.log('registracijaKontroler.Init');
    }
    
	//init();
	
	$scope.registracija = function(korisnik) {
		korisnik.tip = "KORISNIK";
		console.log(korisnik);
		return $http.post('api/korisnik/registracija', korisnik);
	};
});
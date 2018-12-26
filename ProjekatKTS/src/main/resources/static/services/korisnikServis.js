app.factory('korisnikFactory', function($http) {
	
	var factory = {};
	factory.login = function(loginRequestDTO) {
		return $http.post('/api/korisnik/login', loginRequestDTO);
	};
	
	factory.registracija = function(registracijaDTO) {
		return $http.post('/api/korisnik/registracija', registracijaDTO);
	};

	factory.sviKorisnici = function() {
		return $http.get('/api/korisnik/sviKorisnici');
	};
	
	factory.getKorisnik = function(idKorisnika) {
		return $http.get('/api/korisnik/'+ idKorisnika);
	};
	
	factory.getKorisnikByEmail = function(emailKorisnika) {
		return $http.get('/api/korisnik/'+emailKorisnika);
	};
	
	return factory;
	
});
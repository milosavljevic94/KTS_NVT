app.factory('zaposleniFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/api/zaposleni/all');
	};
	
	factory.getZaposleni = function(idZaposlenog) {
		return $http.get('/api/zaposleni/'+idZaposlenog);
	};

	/*factory.addZaposleni = function(zaposleni) {
		return $http.post('/api/zaposleni/add', zaposleni);
	};*/
	
	factory.updateZaposleni = function(zaposleni) {
		return $http.put('/api/zaposleni/update', zaposleni);
	};
	
	factory.deleteZaposleni = function(idZaposlenog) {
		return $http.delete('/api/zaposleni/'+idZaposlenog);
	};
	
	return factory;
	
});
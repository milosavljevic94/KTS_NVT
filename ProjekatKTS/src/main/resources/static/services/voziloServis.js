app.factory('voziloFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/api/vozilo/all');
	};
	
	factory.getVozilo = function(idVozila) {
		return $http.get('/api/vozilo/'+idVozila);
	};

	factory.addVozilo = function(vozilo) {
		return $http.post('/api/vozilo/add', vozilo);
	};
	
	factory.updateVozilo = function(vozilo) {
		return $http.put('/api/vozilo/update', vozilo);
	};
	
	factory.deleteVozilo = function(idVozila) {
		return $http.delete('/api/vozilo/'+idVozila);
	};
	
	return factory;
	
});
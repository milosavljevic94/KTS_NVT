app.factory('kartaFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/api/karta/all');
	};
	
	factory.getKarta = function(idKarte) {
		return $http.get('/api/karta/'+idKarte);
	};

	factory.addKarta = function(karta) {
		return $http.post('/api/karta/add', karta);
	};
	
	factory.updateKarta = function(karta) {
		return $http.put('/api/karta/update', karta);
	};
	
	factory.deleteKarta = function(idKarte) {
		return $http.delete('/api/karta/'+idKarte);
	};
	
	return factory;
	
});
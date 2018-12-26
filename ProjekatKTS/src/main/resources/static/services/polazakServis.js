app.factory('polazakFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/api/polazak/all');
	};
	
	factory.getPolazak = function(idPolaska) {
		return $http.get('/api/polazak/'+idPolaska);
	};

	factory.addPolazak = function(polazak) {
		return $http.post('/api/polazak/add', polazak);
	};
	
	factory.updatePolazak = function(polazak) {
		return $http.put('/api/polazak/update', polazak);
	};
	
	factory.deletePolazak = function(idPolaska) {
		return $http.delete('/api/polazak/'+idPolaska);
	};
	
	return factory;
	
});
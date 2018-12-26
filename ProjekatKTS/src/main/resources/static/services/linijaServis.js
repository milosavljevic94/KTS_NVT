app.factory('linijaFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/api/linija/all');
	};
	
	factory.getLinija = function(idLinije) {
		return $http.get('/api/linija/'+idLinije);
	};

	factory.addLinija = function(linija) {
		return $http.post('/api/linija/add', linija);
	};
	
	factory.updateLinija = function(linija) {
		return $http.put('/api/linija/update', linija);
	};
	
	factory.deleteLinija = function(idLinije) {
		return $http.delete('/api/linija/'+idLinije);
	};
	
	return factory;
	
});
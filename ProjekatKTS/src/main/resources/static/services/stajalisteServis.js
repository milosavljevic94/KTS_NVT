app.factory('stajalisteFactory', function($http) {
	
	var factory = {};
	factory.getAll = function() {
		return $http.get('/api/stajaliste/all');
	};
	
	factory.getStajaliste = function(idStajalista) {
		return $http.get('/api/stajaliste/'+idStajalista);
	};

	factory.addStajaliste = function(stajaliste) {
		return $http.post('/api/stajaliste/add', stajaliste);
	};
	
	factory.updateStajaliste = function(stajaliste) {
		return $http.put('/api/stajaliste/update', stajaliste);
	};
	
	factory.deleteStajaliste = function(idStajalista) {
		return $http.delete('/api/stajaliste/'+idStajalista);
	};
	
	return factory;
	
});
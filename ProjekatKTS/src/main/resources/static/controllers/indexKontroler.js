app.controller('indexKontroler', function($scope, polazakFactory, $http, $rootScope, $location, $window) {
	
	$scope.polasci = [{id:32, dan:"subota", vreme:"14:45"}];
	
    function init() {
    	/*console.log('polazakKontroler.Init');
        polazakFactory.getAll().success(function (data2) {
        	$scope.polasci = data2;
		});*/
    };
    
	init();
	
});
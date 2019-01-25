app.controller('indexKontroler', function($scope, polazakFactory, stajalisteFactory, linijaFactory, $http, $rootScope, $location, $window) {
	
    function init() {
    	console.log('indexKontroler.Init');
        polazakFactory.getAll().then(function (data1) {
        	$scope.polasci = data1.data;
		});
        stajalisteFactory.getAll().then(function (data2) {
			$scope.stajalista = data2.data;
		});
        linijaFactory.getAll().then(function (data3) {
        	$scope.linije = data3.data;
		});
        
      //Ovo simulira tip trenutnog korisnika, zamenice se kad budemo imali logovanje.
		$scope.tipUlogovanogKorisnika = "penzioner";
    }
    
	init();

	$scope.refresh = function() {
        polazakFactory.getAll().then(function (data1) {
        	$scope.polasci = data1.data;
		});
        stajalisteFactory.getAll().then(function (data2) {
        	$scope.stajalista = data2.data;
		});
        linijaFactory.getAll().then(function (data3) {
        	$scope.linije = data3.data;
		});
	}
	
	$scope.login = function() {
		$window.location.replace("http://localhost:8080/#!/prijava");
	}
	
	$scope.registracija = function() {
		$window.location.replace("http://localhost:8080/#!/registracija");
	}

	$scope.submitLinijaDisplay = function() {
		
		$scope.selektovanaLinija;
		$scope.selektovaniDan;

		$scope.polasciZaPrikazTemp = [];
		
		
		for(var i=0; i<angular.fromJson($scope.selektovanaLinija).polasci.length; i++) {
			if(angular.fromJson($scope.selektovanaLinija).polasci[i].dan===$scope.selektovaniDan) {
				$scope.polasciZaPrikazTemp.push(angular.fromJson($scope.selektovanaLinija).polasci[i]);
			}
		}

		//$scope.refresh();
	};
	
});
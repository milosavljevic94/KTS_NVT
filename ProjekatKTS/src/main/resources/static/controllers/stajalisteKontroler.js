app.controller('stajalisteKontroler', function($scope, stajalisteFactory, $http, $rootScope, $location, $window) {
	
	$scope.stajalista = [{id:32, naziv:"naziv1", lokacijaX:"22.2", lokacijaY:"32.2", adresa:"Cara Dusana"}];
	
    function init() {
    	console.log('stajalisteKontroler.Init');
        stajalisteFactory.getAll().then(function (data2) {
        	$scope.stajalista = data2;
		});
    }
    
	init();
	
	/*$scope.refresh = function(){
		stajalisteFactory.getAll()
	          .success(function(data2){
	        	  $scope.stajalista = data2;
	          });
	}*/
	
	
	$scope.addStajaliste = function(stajaliste) {
		stajalisteFactory.addStajaliste(stajaliste).then(function(data) {
			//$scope.refresh();
			toast('Stajaliste ' + stajaliste.naziv + " dodato.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			toast("Stajaliste sa unetim nazivom vec postoji.");
		});	
	};
	
	$scope.updateStajaliste = function(stajaliste) {
		stajalisteFactory.updateStajaliste(stajaliste).then(function(data) {
			//$scope.refresh();
			toast('Stajaliste ' + stajaliste.naziv + " azurirano.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			toast("Greska pri azuriranju stajalista.");
		});	
	};
	
	$scope.deleteStajaliste = function(stajaliste) {
		stajalisteFactory.deleteStajaliste(stajaliste).then(function(data) {
			//$scope.refresh();
			toast('Stajaliste ' + stajaliste.naziv + " obrisano.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			toast("Greska pri brisanju stajalista.");
		});	
	};
	
	/*$scope.back = function() {
		$location.path('/displayAllStajalista');
		//$window.history.back();
	};*/
	
	$scope.saveChanges = function() {
		$scope.updateStajaliste($rootScope.detailViewStajaliste);
		$location.path('/displayAllStajalista');
		//$scope.refresh();
	};
	
	$scope.submit = function() {
		//$rootScope je vidljivo globalno
		$scope.stajaliste.id;
		$scope.stajaliste.naziv;
        $scope.stajaliste.lokacijaX;
        $scope.stajaliste.lokacijaY;
		$scope.stajaliste.adresa;
		
		$scope.addStajaliste($scope.stajaliste);
		$location.path('/displayAllStajalista');
		//$scope.refresh();
	};
});
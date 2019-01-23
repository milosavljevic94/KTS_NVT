app.controller('zaposleniKontroler', function($scope, polazakFactory, stajalisteFactory, linijaFactory, $http, $rootScope, $location, $window) {
	
    function init() {
    	console.log('zaposleniKontroler.Init');
        polazakFactory.getAll().then(function (data) {
        	$scope.polasci = data;
		});
        stajalisteFactory.getAll().then(function (data2) {
        	$scope.stajalista = data2;
		});
        linijaFactory.getAll().then(function (data3) {
        	$scope.linije = data3;
		});
    }
    
	init();
	
	/*$scope.refresh = function(){
		stajalisteFactory.getAll()
	          .success(function(data2){
	        	  $scope.stajalista = data2;
	          });
	}*/
	
	
	$scope.addPolazak = function(polazak) {
		polazakFactory.addPolazak(polazak).then(function(data) {
			//$scope.refresh();
			//toast("Polazak dodat.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			//toast("Greska pri unosu polaska.");
		});	
	};
	
	$scope.addStajaliste = function(stajaliste) {
		stajalisteFactory.addStajaliste(stajaliste).then(function(data) {
			//$scope.refresh();
			//toast('Stajaliste ' + stajaliste.naziv + " dodato.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			//toast("Stajaliste sa unetim nazivom vec postoji.");
		});	
	};
	
	$scope.updatePolazak = function(polazak) {
		polazakFactory.updatePolazak(polazak).then(function(data) {
			//$scope.refresh();
			//toast("Polazak azuriran.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			//toast("Greska pri azuriranju polaska.");
		});	
	};
	
	$scope.updateStajaliste = function(stajaliste) {
		stajalisteFactory.updateStajaliste(stajaliste).then(function(data) {
			//$scope.refresh();
			//toast('Stajaliste ' + stajaliste.naziv + " azurirano.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			//toast("Greska pri azuriranju stajalista.");
		});	
	};
	
	$scope.deletePolazak = function(polazak) {
		polazakFactory.deletePolazak(polazak).then(function(data) {
			//$scope.refresh();
			//toast("Polazak obrisan.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			//toast("Greska pri brisanju polaska.");
		});	
	};
	
	$scope.deleteStajaliste = function(stajaliste) {
		stajalisteFactory.deleteStajaliste(stajaliste).then(function(data) {
			//$scope.refresh();
			//toast('Stajaliste ' + stajaliste.naziv + " obrisano.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			//toast("Greska pri brisanju stajalista.");
		});	
	};
	
	/*$scope.back = function() {
		$location.path('/displayAllStajalista');
		//$window.history.back();
	};*/
	
	$scope.saveChangesPolazak = function() {
		//$scope.updatePolazak($rootScope.detailViewPolazak);
		//$location.path('/displayAllPolasci');
		//$scope.refresh();
	};
	
	$scope.saveChangesStajaliste = function() {
		//$scope.updateStajaliste($rootScope.detailViewStajaliste);
		//$location.path('/displayAllStajalista');
		//$scope.refresh();
	};
	
	$scope.submitPolazak = function() {
		//$rootScope je vidljivo globalno
		$scope.polazak.dan;
        $scope.polazak.vreme;
		
		$scope.addPolazak($scope.polazak);
		//$location.path('/displayAllPolasci');
		//$scope.refresh();
	};
	
	$scope.submitStajaliste = function() {
		//$rootScope je vidljivo globalno
		$scope.stajaliste.naziv;
        $scope.stajaliste.lokacijaX;
        $scope.stajaliste.lokacijaY;
		$scope.stajaliste.adresa;
		
		$scope.addStajaliste($scope.stajaliste);
		//$location.path('/displayAllStajalista');
		//$scope.refresh();
	};
});
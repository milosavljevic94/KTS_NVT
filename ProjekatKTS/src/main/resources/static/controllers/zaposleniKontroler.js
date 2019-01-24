app.controller('zaposleniKontroler', function($scope, polazakFactory, stajalisteFactory, linijaFactory, $http, $rootScope, $location, $window) {

    function init() {
    	console.log('zaposleniKontroler.Init');
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
    
	init();
	
	  $scope.stajalistaFields = { fields: [] };
	  $scope.polasciFields = { fields: [] };
	  
	  $scope.addStajalisteField = function() {
			$scope.stajalistaFields.fields.push('');
		  }
	  $scope.addPolazakField = function() {
			$scope.polasciFields.fields.push('');
		  }
	
	$scope.refresh = function(){
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
	
	$scope.addLinija = function(linija) {
		linijaFactory.addLinija(linija).then(function(data) {
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
	
	$scope.updateLinija = function(linija) {
		linijaFactory.updateLinija(linija).then(function(data) {
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
	
	$scope.deleteLinija = function(linija) {
		linijaFactory.deleteLinija(linija).then(function(data) {
			//$scope.refresh();
			//toast("Polazak obrisan.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			//toast("Greska pri brisanju polaska.");
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
	
	$scope.saveChangesLinija = function() {
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
	
	$scope.submitLinija = function() {
		//$rootScope je vidljivo globalno
		$scope.linija.broj;
        $scope.linija.naziv;
		$scope.linija.stajalista = [];
		$scope.linija.polasci = [];
		$scope.linija.tip;
		$scope.temp = {};
		$scope.temp.stajalista = [];
		$scope.temp.polasci = [];
		
		for(var i=0; i<$scope.stajalistaFields.fields.length; i++) {
			if(!$scope.stajalistaFields.fields[i]!=="") {
				$scope.temp.stajalista = angular.fromJson($scope.stajalistaFields.fields[i]);
				$scope.linija.stajalista.push($scope.temp.stajalista);
			}
		}
		for(var i=0; i<$scope.polasciFields.fields.length; i++) {
			if(!$scope.polasciFields.fields[i]!=="") {
				$scope.temp.polasci = angular.fromJson($scope.polasciFields.fields[i]);
				$scope.linija.polasci.push($scope.temp.polasci);
			}
		}
		
		$scope.addLinija($scope.linija);
		//$location.path('/displayAllStajalista');
		$scope.refresh();
	};
});
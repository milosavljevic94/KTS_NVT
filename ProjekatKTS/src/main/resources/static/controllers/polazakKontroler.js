app.controller('polazakKontroler', function($scope, polazakFactory, $http, $rootScope, $location, $window) {
	
	//$scope.polasci = [{id:32, dan:"subota", vreme:"14:45"}];
	
    function init() {
    	console.log('polazakKontroler.Init');
        polazakFactory.getAll().then(function (data2) {
        	$scope.polasci = data2;
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
			toast('Polazak ' + polazak.id + " dodat.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			toast("Greska pri unosu polaska.");
		});	
	};
	
	$scope.updatePolazak = function(polazak) {
		polazakFactory.updatePolazak(polazak).then(function(data) {
			//$scope.refresh();
			toast('Polazak ' + polazak.id + " azuriran.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			toast("Greska pri azuriranju polaska.");
		});	
	};
	
	$scope.deletePolazak = function(polazak) {
		polazakFactory.deletePolazak(polazak).then(function(data) {
			//$scope.refresh();
			toast('Polazak ' + polazak.naziv + " obrisan.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			toast("Greska pri brisanju stajalista.");
		});	
	};
	
	$scope.detailViewPolazak = function(polazak) {
		if(polazak==undefined) {
            //za ovo treba da se napravi nekakav kuki, koji cuva podatke stajalista koje se trenutno gleda, u slucaju da se odradi refresh stranice
		}
		else {
			$rootScope.detailViewPolazak = polazak;
			//$location.path('/stajalisteDetails');
		}
		
	};
	
	/*$scope.back = function() {
		$location.path('/displayAllStajalista');
		//$window.history.back();
	};*/
	
	$scope.saveChanges = function() {
		$scope.updatePolazak($rootScope.detailViewPolazak);
		$location.path('/displayAllPolasci');
		//$scope.refresh();
	};
	
	$scope.submit = function() {
		//$rootScope je vidljivo globalno
		$scope.polazak.id;
		$scope.polazak.dan;
        $scope.polazak.vreme;
		
		$scope.addPolazak($scope.polazak);
		$location.path('/displayAllPolasci');
		//$scope.refresh();
	};
});
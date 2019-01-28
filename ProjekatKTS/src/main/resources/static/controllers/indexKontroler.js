app.controller('indexKontroler', function($scope, polazakFactory, stajalisteFactory, linijaFactory, kartaFactory, $http, $rootScope, $location, $window) {
   
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
        kartaFactory.getAll().then(function (data4) {
            $scope.karte = data4.data;
        });

        $rootScope.karteTrenutnogKorisnika = [];
        if($rootScope.korisnik!=undefined) {
            for(var i=0; i<angular.fromJson($scope.karte).length; i++) {
                if($scope.karte[i].vlasnik===$rootScope.korisnik.id) {
                    $rootScope.karteTrenutnogKorisnika.push($scope.karte[i]);
                }
            }
        }
       
        if ($rootScope.korisnik == undefined)
            $scope.tipUlogovanogKorisnika = "gradjanin";
        else {
            $scope.tipUlogovanogKorisnika = $rootScope.korisnik.tip;
            console.log($scope.tipUlogovanogKorisnika);
        }
    }
   
    init();
 
    $rootScope.refresh = function() {
        polazakFactory.getAll().then(function (data1) {
            $scope.polasci = data1.data;
        });
        stajalisteFactory.getAll().then(function (data2) {
            $scope.stajalista = data2.data;
        });
        linijaFactory.getAll().then(function (data3) {
            $scope.linije = data3.data;
        });
        kartaFactory.getAll().then(function (data4) {
            $scope.karte = data4.data;
        });

        $rootScope.karteTrenutnogKorisnika = [];
        if($rootScope.korisnik!=undefined) {
            for(var i=0; i<angular.fromJson($scope.karte).length; i++) {
                if($scope.karte[i].vlasnik===$rootScope.korisnik.id) {
                    $rootScope.karteTrenutnogKorisnika.push($scope.karte[i]);
                }
            }
        }
    };
   
    $scope.login = function() {
        $window.location.assign("http://localhost:8080/#!/prijava");
    }
   
    $scope.registracija = function() {
        $window.location.assign("http://localhost:8080/#!/registracija");
    }
   
    $scope.odjava = function() {
        $rootScope.korisnik = undefined;
        $rootScope.tipKorisnika = undefined;
        //document.getElementById("korisnikStatus").innerHTML = "";
        $window.location.assign("http://localhost:8080/#!");
    }
    
    $scope.updateKarta = function(karta) {
        karta.vaziOd = new Date();
        karta.vaziDo = new Date();
        if(karta.tip==="jednokratna") {
            karta.vaziDo.setTime(karta.vaziDo.getTime() + (1000*60*60));
        } else if(karta.tip==="dnevna") {
            karta.vaziDo.setTime(karta.vaziDo.getTime() + (1000*60*60*24));
        }
        karta.aktivirana = true;
		kartaFactory.updateKarta(karta).then(function(data) {
		    $rootScope.refresh();
		    //toast("Polazak azuriran.");
		}).catch(function (response) {
			//$notify.error(response.msg);
			//toast("Greska pri azuriranju polaska.");
		});	
	};
	
	$scope.back = function() {
		//$location.path('/displayKorisnici');
        $window.history.back();
	};
 
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

    $scope.addKarta = function(karta) {
		kartaFactory.addKarta(karta).then(function(data) {
		}).catch(function (response) {
			toast("Greska prilikom unosa komentara.");
		});	
	}
 
    $scope.kupiKartu = function(tipKarte) {
        
        $scope.karta = {};
        $scope.karta.tip = tipKarte;
        $scope.karta.vlasnik = $rootScope.korisnik.id;

	    if(tipKarte==="jednokratna") {
	        $scope.karta.aktivirana = false;
	        $scope.karta.vaziOd = null;
	        $scope.karta.vaziDo = null;
	        $scope.karta.cena = 100;
	    } else if(tipKarte==="dnevna") {
	        $scope.karta.aktivirana = false;
	        $scope.karta.vaziOd = null;
	        $scope.karta.vaziDo = null;
	        $scope.karta.cena = 250;
	    } else if(tipKarte==="mesecnaSkolska") {
	        $scope.karta.aktivirana = true;
	        $scope.karta.vaziOd = new Date();
	        $scope.karta.vaziDo = new Date();
	        $scope.karta.vaziDo.setMonth($scope.karta.vaziDo.getMonth()+1);
	        $scope.karta.cena = 1650;
	    } else if(tipKarte==="godisnjaSkolska") {
	        $scope.karta.aktivirana = true;
	        $scope.karta.vaziOd = new Date();
	        $scope.karta.vaziDo = new Date();
	        $scope.karta.vaziDo.setYear($scope.karta.vaziDo.getFullYear()+1);
	        $scope.karta.cena = 13500;
	    } else if(tipKarte==="mesecnaPenzionerska") {
	        $scope.karta.aktivirana = true;
	        $scope.karta.vaziOd = new Date();
	        $scope.karta.vaziDo = new Date();
	        $scope.karta.vaziDo.setMonth($scope.karta.vaziDo.getMonth()+1);
	        $scope.karta.cena = 1950;
	    } else if(tipKarte==="godisnjaPenzionerska") {
	        $scope.karta.aktivirana = true;
	        $scope.karta.vaziOd = new Date();
	        $scope.karta.vaziDo = new Date();
	        $scope.karta.vaziDo.setYear($scope.karta.vaziDo.getFullYear()+1);
	        $scope.karta.cena = 18000;
	    } else if(tipKarte==="mesecna") {
	        $scope.karta.aktivirana = true;
	        $scope.karta.vaziOd = new Date();
	        $scope.karta.vaziDo = new Date();
	        $scope.karta.vaziDo.setMonth($scope.karta.vaziDo.getMonth()+1);
	        $scope.karta.cena = 3400;
	    } else if(tipKarte==="godisnja") {
	        $scope.karta.aktivirana = true;
	        $scope.karta.vaziOd = new Date();
	        $scope.karta.vaziDo = new Date();
	        $scope.karta.vaziDo.setYear($scope.karta.vaziDo.getFullYear()+1);
	        $scope.karta.cena = 28000;
	    }
	
        $scope.addKarta($scope.karta);
        $rootScope.refresh();
        //$location.path('/mojeKarte');
    };
    
    $scope.kartaDetails = function(karta) {
		
		$rootScope.detailViewKarta = karta;
		$location.path('/kartaDetails');
	}
   
});
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
       
        if ($rootScope.korisnik == undefined)
            $scope.tipUlogovanogKorisnika = "gradjanin";
        else {
            $scope.tipUlogovanogKorisnika = $rootScope.korisnik.tip;
            console.log($scope.tipUlogovanogKorisnika);
        }
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
 
        $scope.kupiKartu = function(tipKarte) {
       
            $scope.karta = {};
            $scope.karta.tip = tipKarte;
            $scope.karta.idVlasnik = $rootScope.korisnik.id;
 
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
 
        kartaFactory.addKarta($scope.karta);
        //$scope.refresh();
    };
 
 
   
});
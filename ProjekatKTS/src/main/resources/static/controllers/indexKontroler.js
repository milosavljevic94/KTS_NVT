app.controller('indexKontroler', function($scope, polazakFactory, stajalisteFactory, linijaFactory, $http, $rootScope, $location, $window) {
	
	$scope.polasci = [{id:32, dan:"subota", vreme:"15:45"},{id:33, dan:"subota", vreme:"14:45"},{id:34, dan:"radni dan", vreme:"14:45"}];
	$scope.stajalista = [{id:42, naziv:"stajaliste1", lokacijaX:"22.2", lokacijaY:"32.2", adresa:"Cara Dusana"},{id:43, naziv:"stajaliste2", lokacijaX:"25.2", lokacijaY:"38.2", adresa:"Cara Lazara"},
		{id:44, naziv:"stajaliste3", lokacijaX:"23.2", lokacijaY:"42.2", adresa:"Gajeva"}];
	$scope.linije = [{id:52, broj:"1", naziv:"Zeleznicka - Centar", stajalista: $scope.stajalista, polasci: $scope.polasci, tip: "autobus"}, {id:53, broj:"2", naziv:"Zeleznicka - Novo Naselje", stajalista: $scope.stajalista, polasci: $scope.polasci, tip: "autobus"},
		{id:54, broj:"3", naziv:"Zeleznicka - Klisa", stajalista: $scope.stajalista, polasci: $scope.polasci, tip: "autobus"}];
    function init() {
    	/*console.log('polazakKontroler.Init');
        polazakFactory.getAll().success(function (data2) {
        	$scope.polasci = data2;
		});*/
    };
    
	init();
	
});
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	  $scope.motCle="";
	   $scope.charger=function(){
		    $http.get("http://localhost:8000/gestionproduit/dali/produit/produitparMC?mc="+$scope.motCle)
		     .then(function(response) {
		    	 $scope.produits = response.data;
	          });
		
		};
});
(function () {
    angular.module('myApp').controller("loginCtrl", function ($scope, $location, $http) {
    $scope.user={
    	nombre: "",
    	clave: ""
    };
    $scope.submit=function(){
    	var nombre=$scope.user.nombre;
    	var clave=$scope.user.clave;
    	if(nombre=='admin' && clave=='admin'){
    		$location.path('/')
    	}
    }
    console.log("Login");
   
});
})();
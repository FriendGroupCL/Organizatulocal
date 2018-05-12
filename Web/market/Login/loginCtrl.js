(function () {
    angular.module('myApp').controller("loginCtrl", function ($scope, $location, $http) {
    if(Boolean(localStorage.getItem("sesion"))==true){ $location.path('/') }
    document.body.className = document.body.className.replace("fixed-nav sticky-footer bg-dark","");
    document.getElementById("cont").className=document.getElementById("cont").className.replace("content-wrapper","");
    $scope.user={
    	nombre: "",
    	clave: ""
    };
    
    $scope.submit=function(){
    	var nombre=$scope.user.nombre;
    	var clave=$scope.user.clave;
    	if(nombre=='admin' && clave=='admin'){
            localStorage.setItem("sesion", true);
    		$location.path('/')
    	}
    }
    console.log("Login");
   
});
})();
(function () {
    angular.module('myApp').controller("inicioCtrl", function ($scope, $location, $http) {
        
    //document.getElementById("login").style.display = "none";
    //document.getElementById("todo").style.display = "block";
    console.log("home controller reached");
    //var parametros=[];
    $.getJSON("http://localhost:8080/organizatulocal/webresourse/Categoria", function (data) {
                  $scope.categorias=[];
                  
                  for (i = 0; i < data.length; i++) {
                      var categoria={};
                      
                      categoria=data[i];
                      $scope.categorias.push(categoria);
                     //$scope.categorias = JSON.stringify(data);
                  }
                  console.log($scope.categorias);
                  //localStorage.setItem('configuracion.portal.' + ambiente, JSON.stringify(parametros));
               });
    //console.log(JSON.stringify($scope.categorias));
});
})();
(function () {
    angular.module('myApp').controller("inicioCtrl", function ($scope, $location, $http) {
    if(Boolean(localStorage.getItem("sesion"))!=true){ $location.path('/login') }
    //document.getElementById("login").style.display = "none";
    //document.getElementById("todo").style.display = "block";
    
    console.log("home controller reached");
    
      var req = {
                    method: 'PUT',
                    url: "http://localhost:8080/OrganizaTuLocal_API/webresources/Categorias/1",
                    data:{
                    "descripcion": "Productos no perecibles",
                    "id": 1,
                    "nombre": "Abarrotes",
                    "productoBarraList": [],
                    "productoEspecialList": []
                    }
                }
                $http(req).then(function (response) {
                    console.log(JSON.stringify(response))
                });
    $scope.logout=function(){
        localStorage.removeItem("sesion");
        $('#exampleModal').modal('hide');
    }
    //console.log(JSON.stringify($scope.categorias));
});
})();
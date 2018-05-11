(function () {
    angular.module('myApp').controller("inicioCtrl", function ($scope, $location, $http) {
        
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
    //console.log(JSON.stringify($scope.categorias));
});
})();
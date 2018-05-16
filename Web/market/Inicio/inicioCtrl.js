(function () {
    angular.module('myApp').controller("inicioCtrl", function ($scope, $location, $http) {
    if(Boolean(localStorage.getItem("sesion"))!=true){ $location.path('/login') }
    //document.getElementById("login").style.display = "none";
    //document.getElementById("todo").style.display = "block";
    
    console.log("home controller reached");
    
      /*var req = {
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
                });*/
   $scope.rol={};
        
   $scope.local={};
   $scope.getRol=function(){
                $http.get("http://localhost:21970/API_ORGANIZATULOCAL/webresources/Rol/1")
                    .then(function (response) {
                    //console.log(JSON.stringify(response));
                    if (response){
                           //$scope.rol=JSON.stringify(response.data);
                           var myJSON = JSON.stringify(response.data); //este metodo se utiliza al haber 1 solo objeto retornado
                            //console.log("RESPUESTA:"+myJSON);

                            $scope.dataObj = JSON.parse(myJSON); 
                            console.log("MI OBJETO");
                            console.log($scope.dataObj);
                            
                            $scope.rol={
                               "descripcion":$scope.dataObj.descripcion,
                               "id":$scope.dataObj.id,
                               "nombre":$scope.dataObj.nombre,
                               "permisoList":$scope.dataObj.permisoList,
                               "usuarioList":$scope.dataObj.usuarioList
                            }
                            //console.log("id : "+$scope.dataObj.id);
                           
                       }
                    var req2 = {
                    method: 'GET',
                    url: "http://localhost:21970/API_ORGANIZATULOCAL/webresources/Local/1",
                    }
                    $http(req2).then(function (response) {

                        //console.log(JSON.stringify(response));
                        if (response){
                               var myJSON2=JSON.stringify(response.data);
                               $scope.dataObj2 = JSON.parse(myJSON);
                               
                               $scope.local={
                                      "estado": $scope.dataObj2.estado,
                                      "id":$scope.dataObj2.id,
                                      "localHasPlanList":$scope.dataObj2.localHasPlanList,
                                      "productoBarraList":$scope.dataObj2.productoBarraList,
                                      "productoEspecialList":$scope.dataObj2.productoEspecialList,
                                      "razonSocial":$scope.dataObj2.razonSocial,
                                      "rut":$scope.dataObj2.rut,
                                      "usuarioList":$scope.dataObj2.usuarioList,
                                      "ventaList":$scope.dataObj2.ventaList
                               }
                               console.log("eso "+$scope.local+"Ejate "+$scope.rol);
                           }
                        $http({   
                              method: 'POST',
                              url: 'http://localhost:21970/API_ORGANIZATULOCAL/webresources/Usuario',
                              data : { 

                                        "nombre": "Fermin Mariante",
                                        "correo": "jotacardenas90@gmail.com",
                                        "clave": "janoncho90",
                                        "estado": 1,
                                        "localId": $scope.local,
                                        "rolId": $scope.rol
                                     }
                           }).then(function(response){
                                 // success callback
                                   if (response){
                                       console.log("Respuesta " + JSON.stringify(response));
                                   }

                               }, 
                               function(response){
                                 // failure callback
                               }
                            );
                    });
                });
   }
   $scope.getLocal=function(){
       /*var req = {
                    method: 'GET',
                    url: "http://localhost:21970/API_ORGANIZATULOCAL/webresources/Local/1",
                }
                $http(req).then(function (response) {
                     
                    //console.log(JSON.stringify(response));
                    if (response){
                           $scope.local=JSON.stringify(response.data);
                           
                       }
                });*/
   }    
   
   //$scope.getLocal();    
        
    $scope.Envio=function(){
        $scope.getRol();
        //console.log("Roles "+$scope.rol);
        //console.log("Locales "+$scope.local);
    }
    
        
    $scope.logout=function(){
        localStorage.removeItem("sesion");
        $('#exampleModal').modal('hide');
    }
    //console.log(JSON.stringify($scope.categorias));
});
})();
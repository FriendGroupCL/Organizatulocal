var app = angular.module("Organizatulocal",[]);
app.controller("PrimerController", function($scope,$http){
    
    $scope.nombre="ANGULAR ES EL MEJOR";
    //var url="http://localhost:8080/OrganizaTuLocal_API/webresources/Categorias"
    
    //obtener datos
    $scope.ObtenerCategorias = function(){
        
        $http({   
                  method: 'GET',
                  url: 'http://localhost:8080/OrganizaTuLocal_API/webresources/Categorias'
               }).then(function (response){
            
                        var myJSON = JSON.stringify(response.data);
                        //console.log("RESPUESTA:"+myJSON);
                  
                        $scope.dataObj = JSON.parse(myJSON);
                        console.log($scope.dataObj);
             for (var item in $scope.dataObj){
                 console.log("ID CATEGORIA "+$scope.dataObj[item].id + "     NOMBRE CATEGORIA "+$scope.dataObj[item].nombre);
	// código a repetir por el bucle.
	// dentro de este código la variable "propiedad" contiene la propiedad actual
    // actual en cada uno de los pasos de la iteración.
}
            
               },function (error){

               });
    };
    
    //enviar datos
    $scope.EnviarDatos = function(){
        
       //var data = { "nombre":"ROl PRUEBA 2","descripcion":"ROL DE PRUEBA 2" };
        
        $http({   
                  method: 'POST',
                  url: 'http://localhost:8080/OrganizaTuLocal_API/webresources/Usuarios',
                  data : { 
                            "nombre":"Fermin Mariante",
                            "correo":"jotacardenas90@gmail.com",
                            "clave":"janoncho90",
                            "estado": 1,
                            "rol_id": 1,
                            "local_id": 1
                           
                         }
               }).then(function(response){
                     // success callback
                       if (response){
                           console.log("ENVIADO SATISFACTORIAMENTE" + response.data);
                       }

                   }, 
                   function(response){
                     // failure callback
                   }
                );
    };
    
    
    
     $scope.CrearRol = function(){
        
       //var data = { "nombre":"ROl PRUEBA 2","descripcion":"ROL DE PRUEBA 2" };
        
        $http({   
                  method: 'POST',
                  url: 'http://localhost:8080/API_ORGANIZATULOCAL/webresources/Rol',
                  data : { 
                            "nombre":"Vendedor",
                            "descripcion":"Rol que se le asigna a un usuario para acceder a todas las funcionalidades asociadas a ventas de un local"
                           
                         }
               }).then(function(response){
                     // success callback
                       if (response){
                           
                           console.log("RESPUESTA DEL SERVIDOR" + JSON.stringify(response.data));
                       }

                   }, 
                   function(response){
                     // failure callback
                   }
                );
    };
    //enviar datos local
    $scope.CrearLocal = function(){
        
       //var data = { "nombre":"ROl PRUEBA 2","descripcion":"ROL DE PRUEBA 2" };
        
        $http({   
                  method: 'POST',
                  url: 'http://localhost:8080/API_ORGANIZATULOCAL/webresources/Local',
                  data : { 
                            
                            "rut": "99999999-9",
                            "razonSocial": "Wensenlao",
                            "estado": 1
                         }
               }).then(function(response){
                     // success callback
                       if (response){
                           console.log("Respuesta " + JSON.stringify(response.data));
                       }

                   }, 
                   function(response){
                     // failure callback
                   }
                );
    };
    
    $scope.local={};
    $scope.rol={};
    $scope.dataObj;
    $scope.CrearUsuario = function(){
        
        
        var JsonLocal;
        var JsonRol;
        
        //obteniendo los datos del local
        $http({   
                  method: 'GET',
                  url: 'http://localhost:8080/API_ORGANIZATULOCAL/webresources/Local/1',
               }).then(function(response){
                     // success callback
                       if (response){
                           
                           //$scope.local = JSON.stringify(response.data);
                           $scope.local = JSON.stringify(response.data);
                           console.log("DATOS DEL LOCAL  "+$scope.local);
                           //var jsonparselocal = JSON.parse(JsonLocal);
                           //$scope.dataObj = JSON.parse(response);
                           //console.log("respuesta como un stringify " + $scope.local);
                           //console.log("datos de jsonparselocal " + jsonparselocal[0]);
                       }

                   }, 
                   function(response){
                     // failure callback
                   }
                );
        
        //obteniendo los datos del rol
        $http({   
                  method: 'GET',
                  url: 'http://localhost:8080/API_ORGANIZATULOCAL/webresources/Rol/1',
               }).then(function(response){
                     // success callback
                       if (response){
                           
                           //$scope.local = JSON.stringify(response.data);
                           $scope.rol = JSON.stringify(response.data);
                           $scope.dataObj = JSON.parse($scope.rol);
                           //console.log("respuesta como un stringify " + $scope.local);
                           console.log("DATOS DEL ROLCITO " + $scope.dataObj.nombre + "DESCRIPCION "+ $scope.dataObj.descripcion);
                       }

                   }, 
                   function(response){
                     // failure callback
                   }
                );
        
        console.log("LOCAL DE SCOPE"+ $scope.local);
        //Enviando los datos
        $http({   
                  method: 'POST',
                  url: 'http://localhost:8080/API_ORGANIZATULOCAL/webresources/Usuario',
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
    };
    
    $scope.ObtenerLocal = function(id){
        
       //var data = { "nombre":"ROl PRUEBA 2","descripcion":"ROL DE PRUEBA 2" };
        
        $http({   
                  method: 'GET',
                  url: 'http://localhost:8080/API_ORGANIZATULOCAL/webresources/Local/'+id,
               }).then(function(response){
                     // success callback
                       if (response){
                           console.log("Respuesta " + JSON.stringify(response.data));
                           $scope.LOCALL = JSON.stringfy(response.data);
                       }

                   }, 
                   function(response){
                     // failure callback
                   }
                );
    };
    
    
    $scope.ActualizarDatos = function(){
        
       var id= 6;
       //var data = {"id": id, "nombre":"VAMOS A VER","descripcion":"PROBEMOS SI MI TEORÍA ES CIERTA :V" };
        
       $http({   
                  method: 'PUT',
                  url: 'http://localhost:8080/OrganizaTuLocal_API/webresources/Roles/'+id,
                  data : {
                            "id": id, 
                            "nombre":"VAMOS A VER",
                            "descripcion":"PROBEMOS SI MI TEORÍA ES CIERTA :V"
                         }
               }).then(function(response){
                     // success callback
                      
                        console.log("ACTUALIZADO SATISFACTORIAMENTE" + JSON.stringify(response.data));
                        //var myJSON = JSON.stringify(response.data);
                        //console.log("RESPUESTA:"+myJSON);
                        //$scope.ServerResponse = response;
                        //$scope.dataObj = JSON.parse(myJSON);
                        //console.log($scope.ServerResponse);
                       

                   }, 
                   function(response){
                     // failure callback
                   }
                );
    };
});
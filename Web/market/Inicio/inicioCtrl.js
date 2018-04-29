(function () {
    angular.module('myApp').controller("inicioCtrl", function ($scope, $location, $http) {
        
    document.getElementById("login").style.display = "none";
    document.getElementById("todo").style.display = "block";
    console.log("home controller reached");
   
});
})();
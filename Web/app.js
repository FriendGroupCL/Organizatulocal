(function () {
    
    angular.module('myApp', ['ui.router','oc.lazyLoad'])
    .config(function ($stateProvider, $locationProvider, $ocLazyLoadProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/");
            $stateProvider
                
                .state("home", {
                    url: "/",
                    templateUrl: "market/Inicio/inicio.html",
                    controller: 'inicioCtrl',
                    resolve: { // Any property in resolve should return a promise and is executed before the view is loaded
                        loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                            // you can lazy load files for an existing module
                            return $ocLazyLoad.load('market/Inicio/inicioCtrl.js');
                        }]
                    }
                })
        
                .state("login", {
                        url: "/login",
                        templateUrl: "market/Login/login.html",
                        controller: 'loginCtrl',
                        resolve: { // Any property in resolve should return a promise and is executed before the view is loaded
                            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                                        // you can lazy load files for an existing module
                            return $ocLazyLoad.load('market/Login/loginCtrl.js');
                            }]
                        }
                        
                    })
        
        
    });
        

}());

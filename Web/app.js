(function () {
    
    angular.module('myApp', ['ui.router','oc.lazyLoad'])
    .config(function ($stateProvider, $locationProvider, $ocLazyLoadProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/");
            $stateProvider
                .state("home", {
                    url: "/",
                    templateUrl: "view/inicio.html",
                    controller: 'inicioCtrl',
                    resolve: { // Any property in resolve should return a promise and is executed before the view is loaded
                        loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                            // you can lazy load files for an existing module
                            return $ocLazyLoad.load('controllers/inicioCtrl.js');
                        }]
                    }
                })
        
        
    });
        

}());

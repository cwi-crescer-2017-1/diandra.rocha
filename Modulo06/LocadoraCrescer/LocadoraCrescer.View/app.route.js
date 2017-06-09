app.config(function($routeProvider) {

    $routeProvider
        .when("/home", {
            templateUrl: "/Home/home.html"
        })
        .when("/login", {
            controller: "LoginController",
            templateUrl: "/Login/login.html"
        })
        .when("/administrativa", {
            controller: "AdministrativaController",
            templateUrl: "/administrativa/administrativa.html",
            resolve: {
                autenticado: function(authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise({
            redirectTo: "/home"
        });
});
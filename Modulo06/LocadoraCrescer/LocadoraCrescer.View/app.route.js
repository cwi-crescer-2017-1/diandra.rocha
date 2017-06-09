app.config(function($routeProvider) {

    $routeProvider
        .when("/home", {
            controller: "HomeController",
            templateUrl: "/Home/home.html"
        })
        .when("/login", {
            controller: "LoginController",
            templateUrl: "/Login/login.html"
        })
        .when("/reserva", {
            controller: "ReservaController",
            templateUrl: "/Reserva/reserva.html",
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
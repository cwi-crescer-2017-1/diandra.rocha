locadora.config(function($routeProvider) {
    $routeProvider
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'views/login.html'
        })
        .when('/reserva', {
            controller: 'ReservaController',
            templateUrl: 'views/reserva.html',
            resolve: {
                autenticado: function(authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/cliente', {
            controller: 'ClienteController',
            templateUrl: 'views/cliente.html',
            resolve: {
                autenticado: function(authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/produto', {
            controller: 'ProdutoController',
            templateUrl: 'views/produto.html',
            resolve: {
                autenticado: function(authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .otherwise({
            redirectTo: '/login'
        });
});
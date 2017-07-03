imovie.config(function($routeProvider) {
    $routeProvider
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'views/login.html'
        })
        .when('/cadastro', {
            controller: 'CadastroController',
            templateUrl: 'views/cadastro.html',
        })
        .when('/dashboard', {
            controller: 'DashboardController',
            templateUrl: 'views/dashboard.html',
            resolve: {
                autenticado: function(authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/perfil', {
            controller: 'PerfilController',
            templateUrl: 'views/perfil.html',
            resolve: {
                autenticado: function(authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/postPorId/:id', {
            controller: 'PostPorIdController',
            templateUrl: 'views/postPorId.html',
            resolve: {
                autenticado: function(authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/usuarios', {
            controller: 'UsuariosController',
            templateUrl: 'views/usuarios.html',
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
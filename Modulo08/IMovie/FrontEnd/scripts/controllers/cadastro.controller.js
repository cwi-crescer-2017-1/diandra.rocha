imovie.controller('CadastroController', function($scope, authService, $location, toastr, cadastroService) {

    $scope.novoUsuario = {};

    function confirmar(novoUsuario) {
        cadastroService.cadastrar(novoUsuario).then(function(response) {
                var toast = toastr.success('Usuário cadastrado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                $scope.novoUsuario = {};
                $location.path('/login');
            },

            function(response) {
                var toast = toastr.error('Usuário não cadastrado', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    };
});
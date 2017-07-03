imovie.controller('UsuariosController', function($scope, authConfig, authService, toastr, $location, usuarioService, postService) {
    $scope.menu = 1;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.usuarios = [];
    buscarTodos();

    function buscarTodos() {
        usuarioService.listarTodos().then(function(response) {
                var toast = toastr.success('Usuários carregados com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                $scope.usuarios = response.data;
            },

            function(response) {
                var toast = toastr.error('Usuários não carregados', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    };


});
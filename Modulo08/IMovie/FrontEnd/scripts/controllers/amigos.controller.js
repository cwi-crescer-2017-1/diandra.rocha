imovie.controller('AmigosController', function($scope, authConfig, authService, toastr, $location, usuarioService, postService) {
    $scope.menu = 4;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.amigos = [];
    $scope.removerAmigo = removerAmigo;
    listarAmigosDoUsuario();

    function listarAmigosDoUsuario() {
        usuarioService.listarAmigosDoUsuario().then(function(response) {
                var toast = toastr.success('Amigos carregados com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                $scope.amigos = response.data;
            },

            function(response) {
                var toast = toastr.error('Amigos não carregados', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    };

    function removerAmigo(id) {
        usuarioService.excluirAmigo(id).then(function(response) {
                var toast = toastr.success('Usuário removido com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                listarAmigosDoUsuario();
            },

            function(response) {
                var toast = toastr.error('Usuário não removido', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    }
});
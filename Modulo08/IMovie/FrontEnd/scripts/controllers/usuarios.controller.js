imovie.controller('UsuariosController', function($scope, authConfig, authService, toastr, $location, usuarioService, postService) {
    $scope.menu = 1;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.usuarios = [];
    $scope.amigosDoUsuario = [];
    $scope.convidarAmigo = convidarAmigo;

    buscarTodos();
    listarAmigosDoUsuario();

    function listarAmigosDoUsuario() {
        usuarioService.listarAmigosDoUsuario().then(function(response) {
                var toast = toastr.success('Amigos carregados com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                $scope.amigosDoUsuario = response.data;
            },

            function(response) {
                var toast = toastr.error('Amigos não carregados', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    };

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

    function convidarAmigo(id) {
        usuarioService.convidarAmigo(id).then(function(response) {
                var toast = toastr.success('Usuário convidado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            },

            function(response) {
                var toast = toastr.error('Usuários não convidado', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    }

    function estaNaListaDeAmigos(id) {

    }

});
imovie.controller('UsuariosController', function($scope, authConfig, authService, toastr, $location, usuarioService, postService) {
    $scope.menu = 1;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.usuarios = [];
    $scope.amigosDoUsuario = [];
    $scope.convidarAmigo = convidarAmigo;
    $scope.estaNaListaDeAmigos = estaNaListaDeAmigos;
    $scope.pendentesDeUsuario = [];
    $scope.estaNaListaDePendentes = estaNaListaDePendentes;

    buscarTodos();
    listarAmigosDoUsuario();
    listarPendentesDoUsuario();

    function listarAmigosDoUsuario() {
        usuarioService.listarAmigosDoUsuario().then(function(response) {
                $scope.amigosDoUsuario = response.data;
            },

            function(response) {
                var toast = toastr.error('Amigos não carregados', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    };

    function listarPendentesDoUsuario() {
        usuarioService.listarSolicitacoes().then(function(response) {
                $scope.pendentesDeUsuario = response.data;
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
                buscarTodos();
            },

            function(response) {
                var toast = toastr.error('Usuários não convidado', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    }

    function estaNaListaDeAmigos(id) {
        return $scope.amigosDoUsuario.some(e => e.idusuario === id);
    }

    function estaNaListaDePendentes(id) {
        return $scope.pendentesDeUsuario.some(e => e.idusuario === id);
    }

});
imovie.controller('PerfilController', function($scope, authConfig, authService, toastr, $location, usuarioService, postService) {
    $scope.menu = 2;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.atualizarPerfil = atualizarPerfil;
    $scope.aceitarAmigo = aceitarAmigo;
    $scope.deletarPost = deletarPost;
    $scope.solicitacoes = [];
    buscarFeed();
    listarSolicitacoes();

    function listarSolicitacoes() {
        usuarioService.listarSolicitacoes().then(function(response) {
                var toast = toastr.success('Solicitações carregadas com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                $scope.solicitacoes = response.data;
            },

            function(response) {
                var toast = toastr.error('Solicitações não carregadas', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    }

    function buscarFeed() {
        postService.meuFeed().then(function(response) {
                var toast = toastr.success('Feed carregado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                $scope.posts = response.data.content;
                $scope.comentarios = response.data.content;
            },

            function(response) {
                var toast = toastr.error('Feed não carregado', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    };

    function aceitarAmigo(id) {
        usuarioService.aceitarAmigo(id).then(function(response) {
                var toast = toastr.success('Usuário aceito com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            },

            function(response) {
                var toast = toastr.error('Usuário não aceito', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    }

    function atualizarPerfil(usuario) {
        usuario.senha = usuario.senha;
        usuarioService.atualizarPerfil(usuario).then(function(response) {
                var toast = toastr.success('Usuário alterado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                $scope.usuario = response.data.usuario;
            },

            function(response) {
                var toast = toastr.error('Usuário não alterado', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    }

    function deletarPost(id) {
        usuarioService.deletarPost(id).then(function(response) {
                var toast = toastr.success('Post deletado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            },

            function(response) {
                var toast = toastr.error('Post não deletado', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    }
});
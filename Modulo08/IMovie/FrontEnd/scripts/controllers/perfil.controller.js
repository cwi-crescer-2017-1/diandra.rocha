imovie.controller('PerfilController', function($scope, authConfig, authService, toastr, $location, usuarioService, postService) {
    $scope.menu = 2;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    buscarFeed();

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


});
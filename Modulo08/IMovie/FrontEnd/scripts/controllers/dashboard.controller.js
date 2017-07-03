imovie.controller('DashboardController', function($scope, authConfig, authService, toastr, $location, postService, usuarioService) {
    $scope.menu = 3;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.comentarios = [];
    $scope.posts = [];

    buscarPosts();

    function buscarPosts() {
        postService.feed().then(function(response) {
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
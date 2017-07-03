imovie.controller('DashboardController', function($scope, authConfig, authService, toastr, $location, postService, usuarioService) {

    $scope.comentarios = [];
    $scope.posts = [];

    function buscarPosts() {
        postService.feed().then(function(response) {
                var toast = toastr.success('Feed carregado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                $scope.posts = response.data;
                $scope.comentarios = response.data;
            },

            function(response) {
                var toast = toastr.error('Feed não carregado', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    };

});
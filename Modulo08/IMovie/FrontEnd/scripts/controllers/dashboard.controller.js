imovie.controller('DashboardController', function($scope, authConfig, authService, toastr, $location, comentarioService, curtidaService, postService, usuarioService) {
    $scope.menu = 3;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.comentarios = [];
    $scope.posts = [];
    $scope.likes = 0;
    $scope.novoPost = {};

    buscarPosts();

    function buscarPosts() {
        postService.feed().then(function(response) {
                var toast = toastr.success('Feed carregado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                $scope.posts = response.data.content;
                $scope.comentarios = response.data.content;
                $scope.likes = response.data.content.lentgh();
            },

            function(response) {
                var toast = toastr.error('Feed não carregado', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    };

    function salvar(novoPost) {
        postService.salvarPost(novoPost).then(function(response) {
                var toast = toastr.success('Post postado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                buscarPosts();
            },

            function(response) {
                var toast = toastr.error('Post não postado', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            });
    };

    function curtir(id) {
        curtidaService.curtir(id).then(function(response) {
                var toast = toastr.success('Curtido com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                buscarPosts();

            },
            function(response) {
                var toast = toastr.error('Não foi possivel curtir', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            }
        )
    };

    function descurtir(id) {
        curtidaService.descurtir(id).then(function(response) {
                var toast = toastr.success('Descurtido com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                buscarPosts();

            },
            function(response) {
                var toast = toastr.error('Não foi possivel descurtir', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            }
        )
    };

    function comentar(id, comentario) {
        curtidaService.descurtir(id, comentario).then(function(response) {
                var toast = toastr.success('Comentado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                buscarPosts();

            },
            function(response) {
                var toast = toastr.error('Não foi possivel comentar', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            }
        )
    };

    function descomentar(id) {
        curtidaService.descomentar(id).then(function(response) {
                var toast = toastr.success('Descomentado com sucesso', 'Imovie');
                toastr.refreshTimer(toast, 2000);
                buscarPosts();

            },
            function(response) {
                var toast = toastr.error('Não foi possivel descomentar', 'Imovie');
                toastr.refreshTimer(toast, 2000);
            }
        )
    };
});
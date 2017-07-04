imovie.controller('PerfilDetalhesController', function($scope, authService, $location, toastr, usuarioService, postService, $routeParams) {
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.usuarioBuscar = {};
    $scope.postsUsuario = [];

    var id = parseFloat($routeParams.id);

    obterPorId(id);

    function obterPorId(id) {
        usuarioService.obterPorId(id).then(function(response) {
            $scope.usuarioBuscar = response.data;
        })
    }

    function buscarFeed(id) {
        postService.feedAlheio(id).then(function(response) {
            $scope.postsUsuario = response.data.content;
        })
    }
});
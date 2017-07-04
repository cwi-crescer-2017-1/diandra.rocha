imovie.controller('PerfilDetalhesController', function($scope, authService, $location, toastr, usuarioService, postService, $routeParams) {
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.usuarioBuscar = {};
    $scope.postsUsuario = [];

    var ID = parseInt($routeParams.idusuario);

    obterPorId(ID);
    buscarFeed(ID);

    function obterPorId(ID) {
        usuarioService.obterPorId(ID).then(function(response) {
            $scope.usuarioBuscar = response.data;
        })
    }

    function buscarFeed(ID) {
        postService.feedAlheio(ID).then(function(response) {
            $scope.postsUsuario = response.data.content;
        })
    }
});
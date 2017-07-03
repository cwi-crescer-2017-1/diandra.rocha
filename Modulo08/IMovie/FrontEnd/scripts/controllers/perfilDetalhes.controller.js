imoveis.controller('PerfilDetalhesController', function($scope, authService, $location, toastr, usuarioService, postService, $routeParams) {
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.usuarioBuscar = {};

    var id = parseInt($routeParams.id);

    obterPorId(id);

    function obterPorId(id) {
        usuarioService.obterPorId(id).then(function(response) {
            $scope.usuarioBuscar = response.data;
        })
    }


});
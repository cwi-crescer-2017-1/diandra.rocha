locadora.controller('ReservaDetalhesController', function($scope, authService, $location, toastr, reservaService, clienteService, produtoService, $routeParams) {
    $scope.menu = 1;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.reserva = {};

    var id = parseInt($routeParams.id);

    obterPorId(id);

    function obterPorId(id) {
        reservaService.getReservaPorId(id).then(function(response) {
            $scope.reserva = response.data.dados;
        })
    }


});
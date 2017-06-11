locadora.controller('ClienteController', function($scope, authService, $location, toastr, clienteService) {
    $scope.menu = 3;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.cliente = {};
    $scope.criar = criar;

    function criar(cliente) {
        clienteService.criar(cliente).then(
            function(response) {
                var t = toastr.success('Cliente cadastrado com sucesso', 'Locadora Crescer');
                toastr.refreshTimer(t, 2000);
                $scope.cliente = {};
            },
            function(response) {
                var t = toastr.error('Erro ao cadastrar cliente!', 'Locadora Crescer');
                toastr.refreshTimer(t, 2000);
            }
        )
    }
});
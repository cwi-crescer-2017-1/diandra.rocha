locadora.controller('RelatorioAtrasoController', function($scope, authService, toastr, relatorioService) {
    $scope.menu = 4;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.reservasAtrasadas = [];

    buscarRelatorio();

    function buscarRelatorio() {
        relatorioService.relatorioAtrasos().then(function(response) {
                var toast = toastr.success('Relatório gerado com sucesso', 'Locadora Crescer');
                toastr.refreshTimer(toast, 2000);
                reservasAtrasadas = response.data.dados;
            },
            function(response) {
                var toast = toastr.info('Falha no relatório!', 'Locadora Crescer');
                toastr.refreshTimer(toast, 2000);
            });
    }
});
locadora.controller('RelatorioGeralController', function($scope, authService, $location, toastr, relatorioService) {
    $scope.menu = 5;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.reservasRelatorio = [];
    $scope.relatorioValorTotal = 0;
    $scope.quantidadeTotal = 0;

    $scope.buscarRelatorioGeral = buscarRelatorioGeral;

    function buscarRelatorioGeral(data) {
        var dataRel = data.toJSON();
        relatorioService.relatorioGeral(dataRel).then(function(response) {
                var toast = toastr.success('Relatório gerado com sucesso', 'Locadora Crescer');
                toastr.refreshTimer(toast, 2000);
                $scope.reservasRelatorio = response.data.dados.Lista;
                $scope.relatorioValorTotal = response.data.dados.Resultado;
                $scope.quantidadeTotal = response.data.dados.QuantidadeTotal;
            },
            function(response) {
                var toast = toastr.info('Falha no relatório!', 'Locadora Crescer');
                toastr.refreshTimer(toast, 2000);
            });
    }

});
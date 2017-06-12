locadora.controller('ReservaController', function($scope, authService, $location, toastr, reservaService, clienteService, produtoService) {
    $scope.menu = 1;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

    $scope.confirmar = confirmar;
    $scope.buscar = buscar;
    $scope.buscarParaDevolver = buscarParaDevolver;

    $scope.reservaModel = {};

    $scope.nomeCliente = "";

    function confirmar(reservaModel) {
        $scope.reservaModel.cliente = $scope.clienteAtual;
        reservaService.criar(reservaModel).then(function(response) {
                var toast = toastr.success('Reserva cadastrada com sucesso', 'Locadora Crescer');
                toastr.refreshTimer(toast, 2000);
                $scope.reservaModel = {};
                $location.path('/reserva/' + response.data.dados.Id);
            },

            function(response) {
                var mensagensDeErro = response.data.mensagens;
                for (let i = 0; i < mensagensDeErro.length; i++) {
                    var toast = toastr.error(mensagensDeErro[i], 'Locadora Crescer');
                    toastr.refreshTimer(toast, 2000);
                }

            });


    };

    function buscar(clienteReserva) {
        clienteService.getClientePorCpf(clienteReserva.cpf).then(function(response) {
                var toast = toastr.success('Cliente encontrado com sucesso', 'Locadora Crescer');
                toastr.refreshTimer(toast, 2000);
                $scope.nomeCliente = response.data.dados.Nome + " " + response.data.dados.Sobrenome;
                $scope.clienteAtual = response.data.dados.CPF;
            },
            function(response) {
                var toast = toastr.info('Cliente ainda não cadastrado!', 'Locadora Crescer');
                toastr.refreshTimer(toast, 2000);
                $location.path("/cliente");

            });
    }

    function buscarParaDevolver(reservaDevolucao) {
        reservaService.devolver(reservaDevolucao.idreserva).then(function(response) {
                var toast = toastr.success('Reserva devolvida com sucesso', 'Locadora Crescer');
                toastr.refreshTimer(toast, 2000);
            },
            function(response) {
                var toast = toastr.info('Reserva não encontrada!', 'Locadora Crescer');
                toastr.refreshTimer(toast, 2000);
            });
    }


    $scope.produtos = [];
    $scope.pacotes = [];
    $scope.opcionais = [];

    iniciar();

    function iniciar() {
        ListarProdutos();
        ListarPacotes();
        ListarOpcionais();
    }

    function ListarProdutos() {
        produtoService.getTodosOsProdutos().then(function(response) {
            $scope.produtos = response.data.dados;
        });
    }

    function ListarPacotes() {
        produtoService.getTodosOsPacotes().then(function(response) {
            $scope.pacotes = response.data.dados;
        });
    }

    function ListarOpcionais() {
        produtoService.getTodosOsOpcionais().then(function(response) {
            $scope.opcionais = response.data.dados;
        });
    }
});
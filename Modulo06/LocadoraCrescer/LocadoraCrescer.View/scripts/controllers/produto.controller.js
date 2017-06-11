locadora.controller('ProdutoController', function($scope, authConfig, authService, $location, produtoService) {
    $scope.menu = 2;
    $scope.usuario = authService.getUsuario();
    $scope.logout = authService.logout;

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
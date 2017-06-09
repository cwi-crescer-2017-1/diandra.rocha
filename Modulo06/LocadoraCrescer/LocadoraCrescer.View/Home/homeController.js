app.controller("HomeController", function($scope, authService, homeService) {

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
        homeService.getTodosOsProdutos().then(function(response) {
            $scope.produtos = response.data.dados;
        });
    }

    function ListarPacotes() {
        homeService.getTodosOsPacotes().then(function(response) {
            $scope.pacotes = response.data.dados;
        });
    }

    function ListarOpcionais() {
        homeService.getTodosOsOpcionais().then(function(response) {
            $scope.opcionais = response.data.dados;
        });
    }
});
app.controller("HomeController", function($scope, LivrosService, $http, authService) {

    $scope.livros = [];
    $scope.lancamentos = [];

    $scope.parametros = {
        qtdTrazer: 10,
        qtdPular: 0
    };

    //Executa quando iniciar a controller
    iniciar();

    function iniciar() {
        obterLivroLancamentos();
        paginacao();
    }

    function paginacao() {
        LivrosService.paginacao($scope.parametros).then(function(response) {
            $scope.livros = response.data.dados;
        });
    }

    function proximaPage() {
        qtdPular = qtdPular + 10;
        LivrosService.paginacao($scope.parametros).then(function(response) {
            $scope.livros = response.data.dados;
        });
    }

    function anteriorPage() {
        qtdPular = qtdPular - 10;
        LivrosService.paginacao($scope.parametros).then(function(response) {
            $scope.livros = response.data.dados;
        });
    }

    //ListarTodos
    function obterTodosOsLivros() {
        LivrosService.obterTodosOsLivros().then(function(response) {
            console.log(response);
            $scope.livros = response.data.dados;
        });
    };

    //Lançamento
    function obterLivroLancamentos() {
        LivrosService.obterLivroLancamentos().then(function(response) {
            console.log(response);
            $scope.lancamentos = response.data.dados;
        });
    };
});
app.controller("LivrosController", function($scope, LivrosService, $http, authService) {

    $scope.salvar = salvar;
    $scope.remover = remover;

    $scope.livros = [];

    $scope.parametros = {
        qtdTrazer: 10,
        qtdPular: 0
    };

    //Executa quando iniciar a controller
    iniciar();

    function iniciar(); {
        paginacao();
    }

    function paginacao() {
        LivrosService.paginacao($scope.parametros).then(function(response) {
            $scope.livros = response.data.dados;
        });
    }

    //Salvar e Editar
    function salvar(livro) {
        let promise = {};

        if (angular.isDefined(livro.Isbn)) {
            promise = LivrosService.atualizar(livro);
            promise.then(function(response) {
                obterTodosOsLivros();
                swal("Sucesso!", "Livro editado com sucesso!", "success")
            });
        } else {
            promise = LivrosService.criar(livro);
            promise.then(function(response) {
                obterTodosOsLivros();
                swal("Sucesso!", "Livro cadastrado com sucesso!", "success")
            });
        }

        $scope.livro = {};
    };

    //Remover
    function remover(livro) {
        LivrosService.remover(livro).then(function() {
            swal("Apagado!", "Livro excluído com sucesso!", "success");
            obterTodosOsLivros();
        })
        sweetAlert("Oops...", "Alguma falha ocorreu!", "error");
    };

    //Listagens

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
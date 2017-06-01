app.controller("LivrosController", function($scope, LivrosService) {

    $scope.salvar = salvar;
    $scope.remover = remover;

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

        $scope.novoLivro = {};
    }

    //Remover
    function remover(livro) {
        LivrosService.remover(livro).then(function() {
            swal("Apagado!", "Livro excluído com sucesso!", "success");
            obterTodosOsLivros();
        })
        sweetAlert("Oops...", "Alguma falha ocorreu!", "error");
    }

    //Listagens

    //ListarTodos
    LivrosService.obterTodosOsLivros().then(function(response) {
        $scope.livros = response.data.dados;
    });

    //Lançamento
    LivrosService.obterLivroLancamentos().then(function(response) {
        console.log(response);
        $scope.lancamentos = response.data.dados;
    });

    //Por Isbn
    LivrosService.obterLivroPorIsbn(Isbn).then(function(response) {
        console.log(response);
        $scope.livroPorIsbn = response.data.dados;
    });

    //Por Genero
    LivrosService.obterLivroPorGenero(genero).then(function(response) {
        console.log(response);
        $scope.livroPorGenero = response.data.dados;
    });
})
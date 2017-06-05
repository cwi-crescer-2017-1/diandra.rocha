app.controller("LivrosController", function($scope, LivrosService, $http, authService) {

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

});
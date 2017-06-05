app.controller("DetalhesController", function($scope, $routeParams, LivrosService) {

    $scope.livro = {};

    ObterPorIsnb($routeParams.IsbnLivro);

    function ObterPorIsnb(IsbnLivro) {
        let promessa = LivrosService.obterPorIsbn(IsbnLivro);

        promessa.then(function(response) {
            $scope.livro = response.data.dados;
        })
    };

});
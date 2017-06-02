app.factory("LivrosService", function($http) {
    let urlBase = "http://localhost:51144/api/Livros";

    function paginacao(paginacao) {
        $http({
            url: urlBase,
            method: 'GET',
            params: paginacao
        })
    };


    function obterTodosOsLivros() {
        return $http.get(urlBase);
    };

    function obterLivroPorIsbn(Isbn) {
        return $http.get(urlBase + "/" + Isbn);
    };

    function obterLivroPorGenero(genero) {
        return $http.get(urlBase + "/" + genero);
    };

    function obterLivroLancamentos() {
        return $http.get(urlBase + "/Lancamento");
    };

    function atualizar(livro) {
        return $http.put(urlBase + "/" + livro.Isbn, livro);
    };

    function criar(livro) {
        return $http.post(urlBase, livro);
    };

    function remover(livro) {
        return $http.delete(urlBase + "/" + livro.Isbn);
    }

    return {
        obterTodosOsLivros: obterTodosOsLivros,
        obterLivroPorIsbn: obterLivroPorIsbn,
        obterLivroPorGenero: obterLivroPorGenero,
        obterLivroLancamentos: obterLivroLancamentos,
        atualizar: atualizar,
        criar: criar,
        remover: remover,
        paginacao: paginacao
    };

})
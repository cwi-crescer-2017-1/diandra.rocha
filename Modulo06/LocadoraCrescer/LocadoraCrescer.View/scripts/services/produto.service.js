locadora.factory('produtoService', function($http) {

    let urlBaseProduto = 'http://localhost:49456/api/produto';

    function getTodosOsProdutos() {
        return $http.get(urlBaseProduto);
    };

    let urlBasePacote = 'http://localhost:49456/api/pacote';

    function getTodosOsPacotes() {
        return $http.get(urlBasePacote);
    };

    let urlBaseOpcional = 'http://localhost:49456/api/opcional';

    function getTodosOsOpcionais() {
        return $http.get(urlBaseOpcional);
    };

    return {
        getTodosOsProdutos: getTodosOsProdutos,
        getTodosOsPacotes: getTodosOsPacotes,
        getTodosOsOpcionais: getTodosOsOpcionais
    };
});
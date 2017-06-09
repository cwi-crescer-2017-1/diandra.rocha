app.factory("homeService", function($http) {

    let urlBaseProduto = "http://localhost:49456/api/produto";

    function getTodosOsProdutos() {
        return $http.get(urlBaseProduto);
    };

    function getProdutoPorId(id) {
        return $http.get(urlBaseProduto + "/" + id);
    };

    let urlBasePacote = "http://localhost:49456/api/pacote";

    function getTodosOsPacotes() {
        return $http.get(urlBasePacote);
    };

    function getPacotePorId(id) {
        return $http.get(urlBasePacote + "/" + id);
    };

    let urlBaseOpcional = "http://localhost:49456/api/opcional";

    function getTodosOsOpcionais() {
        return $http.get(urlBaseOpcional);
    };

    function getOpcionalPorId(id) {
        return $http.get(urlBaseOpcional + "/" + id);
    };

    return {
        getTodosOsProdutos: getTodosOsProdutos,
        getTodosOsPacotes: getTodosOsPacotes,
        getTodosOsOpcionais: getTodosOsOpcionais,
        getProdutoPorId: getProdutoPorId,
        getPacotePorId: getPacotePorId,
        getOpcionalPorId: getOpcionalPorId
    };
});
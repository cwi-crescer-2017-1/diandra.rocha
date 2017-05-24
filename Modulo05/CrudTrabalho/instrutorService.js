app.factory('instrutorService', function ($http) {
    let urlBase = "http://localhost:3000/instrutor";

    function getTodosOsInstrutores() {
        return $http.get(urlBase);
    };

    function atualizar(instrutor) {
        return $http.put(urlBase + "/" + instrutor.id, instrutor);
    };

    function criar(instrutor) {
        return $http.post(urlBase, instrutor);
    };

    function remover(instrutor) {
        return $http.delete(urlBase + "/" + instrutor.id);
    }

    return {
        listInst: getTodosOsInstrutores,
        updateInst: atualizar,
        createInst: criar,
        eraseInst: remover
    };

})
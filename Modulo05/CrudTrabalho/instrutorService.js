modulo.factory('instrutorService', function ($http) {
    let urlBase = "http://localhost:3000";

    function getTodosOsInstrutores() {
        return $http.get(urlBase + '/instrutor');
    };

    function getInstrutorPorId(id) {
        return $http.get(urlBase + '/instrutor' + '/' + id);
    };

    function atualizar(instrutor) {
        return $http.put(urlBase + '/instrutor' + '/' + instrutor.id, instrutor);
    };

    function criar(instrutor) {
        instrutor.id = ++idAtual;
        instrutores.push(angular.copy(instrutor));
    };

    function remover(instrutor) {
        return $http.delete(urlBase + '/instrutor/' + instrutor.id);
    }

    return {
        list: getTodosOsInstrutores,
        findById: getInstrutorPorId,
        update: atualizar,
        create: criar,
        erase: remover
    };

})
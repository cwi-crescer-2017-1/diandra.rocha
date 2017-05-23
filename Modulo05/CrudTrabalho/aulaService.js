modulo.factory('aulaService', function ($http) {
    let urlBase = "http://localhost:3000/aula/";

    function getTodasAsAulas() {
        return $http.get(urlBase);
    };

    function getAulaPorId(id) {
        return $http.get(urlBase + id);
    };

    function atualizar(aula) {
        return $http.put(urlBase + "" + aula.id, aula);
    };

    function criar(aula) {
       return $http.post(urlBase, aula);
    };

    function remover(aula) {
        return $http.delete(urlBase + aula.id);
    }

    return {
        list: getTodasAsAulas,
        findById: getAulaPorId,
        update: atualizar,
        create: criar,
        erase: remover
    };

})
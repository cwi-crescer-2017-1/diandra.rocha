app.factory('aulaService', function ($http) {
    let urlBase = "http://localhost:3000/aula";

    function getTodasAsAulas() {
        return $http.get(urlBase);
    };

    function atualizar(aula) {
        return $http.put(urlBase + "/" + aula.id, aula);
    };

    function criar(aula) {
        return $http.post(urlBase, aula);
    };

    function remover(aula) {
        return $http.delete(urlBase + "/" + aula.id);
    }

    return {
        list: getTodasAsAulas,
        update: atualizar,
        create: criar,
        erase: remover
    };

})
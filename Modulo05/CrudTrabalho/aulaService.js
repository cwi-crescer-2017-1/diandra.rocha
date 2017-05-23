app.factory('aulaServices', function ($http) {
    let urlBase = "http://localhost:3000";

    function getTodasAsAulas() {
        return $http.get(urlBase + '/aula');
    };

    function getAulaPorId(id) {
        return $http.get(urlBase + '/aula' + '/' + id);
    };

    function atualizar(aula) {
        return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
    };

    function criar(aula) {
        aula.id = ++idAtual;
        aulas.push(angular.copy(aula));
    };

    function remover(aula) {
        return $http.delete(urlBase + '/aula/' + aula.id);
    }

    return {
        list: getTodasAsAulas,
        findById: getAulaPorId,
        update: atualizar,
        create: criar,
        erase: remover
    };

})
imovie.factory('comentarioService', function($http) {

    let urlBase = 'http://localhost:9090/api';

    function comentar(id, comentario) {
        return $http.post(urlBase + '/comentar/' + id, comentario);
    };

    function descomentar(id) {
        return $http.delete(urlBase + '/descomentar/' + id);
    }

    return {
        comentar: comentar,
        descomentar: descomentar
    };
});
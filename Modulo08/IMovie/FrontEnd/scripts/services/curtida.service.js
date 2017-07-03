imovie.factory('curtidaService', function($http) {

    let urlBase = 'http://localhost:9090/api';

    function curtir(id) {
        return $http.get(urlBase + '/curtir/' + id);
    };

    function descurtir(id) {
        return $http.delete(urlBase + '/descurtir/' + id);
    }

    return {
        curtir: curtir,
        descurtir: descurtir
    };
});
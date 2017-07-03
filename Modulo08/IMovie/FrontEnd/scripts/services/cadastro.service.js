imovie.factory('cadastroService', function($http) {

    let urlBase = 'http://localhost:9090/api';

    function cadastrar(usuario) {
        return $http.post(urlBase + '/cadastro', usuario);
    };

    return {
        cadastrar: cadastrar
    };
});
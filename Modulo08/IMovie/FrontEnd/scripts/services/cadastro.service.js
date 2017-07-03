imovie.factory('cadastroService', function($http) {

    let urlBase = 'http://localhost:9090/api';

    function cadastrar(novoUsuario) {
        return $http.post(urlBase + '/cadastro', novoUsuario);
    };

    return {
        cadastrar: cadastrar
    };
});
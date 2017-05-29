modulo.factory("usuarioService", function($http) {
    urlBase = "http://localhost:62270/api/Usuario";

    function obterUsuario() {
        return $http.get(urlBase);
    }

    function enviarUsuario(usuario) {
        return $http.post(urlBase, usuario)
    }

    return {
        getUsuario: obterUsuario,
        postUsuario: enviarUsuario
    }

});
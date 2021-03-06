imovie.factory('usuarioService', function($http) {

    let urlBase = 'http://localhost:9090/api';

    function listarTodos() {
        return $http.get(urlBase + "/todosusuarios");
    };

    function listarAmigosDoUsuario() {
        return $http.get(urlBase + '/amigos');
    }

    function excluirAmigo(id) {
        return $http.delete(urlBase + '/excluiramigo/' + id);
    }

    function obterPorId(id) {
        return $http.get(urlBase + '/usuario/' + id);
    }

    function atualizarPerfil(usuario) {
        return $http.put(urlBase + '/atualizarusuario', usuario);
    }

    function convidarAmigo(id) {
        return $http.get(urlBase + "/convidar/" + id);
    }

    function aceitarAmigo(id) {
        return $http.get(urlBase + '/aceitar/' + id);
    }

    function listarSolicitacoes() {
        return $http.get(urlBase + "/solicitacoes");
    }

    function excluirConta() {
        return $http.delete(urlBase + '/excluirusuario');
    }

    return {
        listarTodos: listarTodos,
        listarAmigosDoUsuario: listarAmigosDoUsuario,
        excluirAmigo: excluirAmigo,
        atualizarPerfil: atualizarPerfil,
        convidarAmigo: convidarAmigo,
        aceitarAmigo: aceitarAmigo,
        excluirConta: excluirConta,
        obterPorId: obterPorId,
        listarSolicitacoes: listarSolicitacoes
    };
});
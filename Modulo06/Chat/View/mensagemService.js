modulo.factory("mensagemService", function($http) {
    urlBase = "http://localhost:50807/api/Mensagem";

    function obterMensagem() {
        return $http.get(urlBase);
    }

    function enviarMensagem(mensagem) {
        return $http.post(urlBase, mensagem)
    }

    return {
        getMensagem: obterMensagem,
        postMensagem: enviarMensagem
    }

});
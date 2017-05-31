var modulo = angular.module('app', ['ngRoute']);

modulo.config(function($routeProvider) {

    $routeProvider
        .when('/chat/:nome', {
            controller: 'MensagemController',
            templateUrl: 'chat.html'
        })
        .when('/usuario', {
            controller: 'UsuarioController',
            templateUrl: 'usuario.html'
        })
        .otherwise({
            redirectTo: '/usuario'
        });
});

modulo.controller('UsuarioController', function($scope, usuarioService, $location) {

    $scope.usuarios = {};
    $scope.postUsuario = postUsuario;
    getUsuario();

    function getUsuario() {
        usuarioService
            .getUsuario()
            .then(response => {
                $scope.usuarios = response.data;
            })
    }

    function postUsuario(usuario) {;
        localStorage.setItem("usuario", JSON.stringify(usuario));
        usuarioService
            .postUsuario(usuario)
            .then(usuarios => {
                $location.path("/chat/" + usuario.nome);
            })
    }
});

modulo.controller('MensagemController', function($scope, mensagemService) {
    $scope.mensagens = {};
    $scope.postMensagem = postMensagem;
    getMensagem();

    function getMensagem() {
        mensagemService
            .getMensagem()
            .then(response => {
                $scope.mensagens = response.data;
            })
    }

    function postMensagem(mensagem) {
        mensagem.Texto.replace("André Nunes", "$$$$$ $$$$$");
        mensagemService
            .postMensagem(mensagem)
            .then(mensagens => {
                mensagem.usuario = JSON.parse(localStorage.getItem("usuario"));
                getMensagem();
            })
    }
});
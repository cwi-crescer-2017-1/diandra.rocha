var modulo = angular.module('app', ['ngRoute']);

modulo.config(function($routeProvider) {

    $routeProvider
        .when('/chat', {
            controller: 'MensagemController',
            templateUrl: 'chat.html'
        })
        .when('/usuario', {
            controller: 'UsuarioController',
            templateUrl: 'usuario.html'
        })
        .otherwise({
            redirectTo: '/index'
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

    function postUsuario(usuario) {
        $window.localStorage.setItem(usuario);
        usuarioService
            .postUsuario(usuario)
            .then(usuarios => {
                getUsuario()
                $location.url("/chat");
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
        mensagemService
        mensagem.Texto.replace("André Nunes", "$$$$$ $$$$$")
            .postMensagem(mensagem)
            .then(mensagens => {
                $window.localStorage.setItem(response.data);
                getMensagem();
            })
    }
});
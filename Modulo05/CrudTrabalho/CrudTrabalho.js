var app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

    $routeProvider
        .when('/aulas', {
            controller: 'AulasController',
            templateUrl: 'aulas.html'
        })
        .when('/instrutores', {
            controller: 'instrutoresController',
            templateUrl: 'instrutores.html'
        })
        .otherwise({
            redirectTo: '/index.html'
        });
});

app.controller("AulasController", function ($scope, $routeParams, aulaService) {

    $scope.id = $routeParams.idUrl;
    $scope.create = create;
    $scope.update = update;

    findById($scope.id);
    list();

    //funções locais de verificação
    function verificarAula(nome) {
        var nomes = $scope.aulas.map(a => a.nomeAula);
        return nomes.includes(nome);
    }

    function verificarInstrutorUsaAula(aula) {
        let aulasinst = $scope.instrutores.aulas;
        return aulasinst.includes(aula.id);
    }

    //funções internas
    function create(aula) {
        $scope.Formulario1.nomeAula.$setValidity("NomeDuplicado", !verificarAula(aula.nomeAula));
        if ($scope.Formulario1.$valid) {
            aulaService.create(aula);
            swal("Adicionado!", "Aula adicionada com Sucesso!", "success");
        }
    };

    function update(aula) {
        aulaService.update(aula).then(function () {
            swal("Alterado!", "Aula alterada com Sucesso!", "success");
            list();
        })
    };

    function erase(aula) {
        if (!verificarInstrutorUsaAula(aula)) {
            aulaService.erase(aula).then(function () {
                swal("Apagado!", "Aula excluida com Sucesso!", "success");
                list();
            })
        } else {
            sweetAlert("Oops...", "Aula sendo ministrada por instrutor!", "error");
        }
    }

    //Ao iniciar controller
    function findById(id) {
        aulaService.findById(id).then(function (response) {
            $scope.aula = response.data;
        });
    };

    function list() {
        aulaService.list().then(function (response) {
            $scope.aulas = response.data;
        });
    }
});
var modulo = angular.module('app', ['ngRoute']);

modulo.config(function ($routeProvider) {

    $routeProvider
        .when('/aulas', {
            controller: 'AulasController',
            templateUrl: 'aulas.html'
        })
        .when('/instrutores', {
            controller: 'InstrutoresController',
            templateUrl: 'instrutores.html'
        })
        .otherwise({
            redirectTo: '/index.html'
        });
});

//Controller aula

modulo.controller("AulasController", function ($scope, aulaService) {

    $scope.create = create;
    $scope.update = update;
    $scope.erase = erase;


    list();

    //funções internas
    function create(aula) {
            aulaService.create(aula);
            swal("Adicionado!", "Aula adicionada com Sucesso!", "success");
            list();
    };

    function update(aula) {
        aulaService.update(aula)
            swal("Alterado!", "Aula alterada com Sucesso!", "success");
            list();
    };

    function erase(aula) {
            aulaService.erase(aula).then(function () {
                swal("Apagado!", "Aula excluida com Sucesso!", "success");
                list();
            })
    }

    //Ao iniciar controller
    function findById(id) {
        aulaService.findById(id).then(function (response) {
            $scope.aula = response.data;
        });
    };

    function list() {
        aulaService.list().then(function (response) {
            console.log(response.data);
        });
    }
});


//Controller Instrutor
modulo.controller("InstrutoresController", function ($scope, aulaService) {

    $scope.create = create;
    $scope.update = update;


    list();
    function create(aula) {
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
            aulaService.erase(aula).then(function () {
                swal("Apagado!", "Aula excluida com Sucesso!", "success");
                list();
            })
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
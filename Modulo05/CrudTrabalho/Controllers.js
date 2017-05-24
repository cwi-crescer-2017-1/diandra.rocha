var app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

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

app.controller("AulasController", function ($scope, aulaService) {

    $scope.save = save;
    $scope.erase = erase;
    $scope.atualiza = atualiza;

    list();

    //funções internas

    function atualiza(aula) {
        $scope.novaAula = angular.copy(aula);
    }

    function save(aula) {
        if ($scope.Formulario1.$invalid) {
            return;
        }
        let promise = {};

        if (angular.isDefined(aula.id)) {
            promise = aulaService.update(aula);
            promise.then(function (response) {
                list();
                swal("Sucesso!", "Aula editada com sucesso!", "success")
            });
        } else {
            promise = aulaService.create(aula);
            promise.then(function (response) {
                list();
                swal("Sucesso!", "Aula adicionada com sucesso!", "success")
            });
        }

        $scope.novaAula = {};
    }


    function erase(aula) {
        aulaService.erase(aula).then(function () {
            swal("Apagado!", "Aula excluída com sucesso!", "success");
            list();
        })
        sweetAlert("Oops...", "Alguma falha ocorreu!", "error");
    }

    //Ao iniciar controller

    function list() {
        aulaService.list().then(function (response) {
            $scope.aulas = response.data;
        });
    }
});

app.controller("InstrutoresController", function ($scope, instrutorService, aulaService) {

    $scope.saveInst = saveInst;
    $scope.eraseInst = eraseInst;
    $scope.atualizaInst = atualizaInst;

    listInst();

    //funções internas

    function pegarDados() {
        instrutorService.listInst().then(function (res) {
            $scope.instrutores = res.data;
        });
        aulaService.list().then(function (res) {
            $scope.aulas = res.data;
        });
    }

    function atualizaInst(instrutor) {
        $scope.novoInstrutor = angular.copy(instrutor);
    }

    function saveInst(instrutor) {
        if ($scope.Formulario2.$invalid) {
            return;
        }
        let promessa = {};

        if (angular.isDefined(instrutor.id)) {
            promessa = instrutorService.updateInst(instrutor);
            promessa.then(function (response) {
                listInst();
                swal("Sucesso!", "Instrutor editado com Sucesso!", "success")
            });
        } else {
            promessa = instrutorService.createInst(instrutor);
            promessa.then(function (response) {
                listInst();
                swal("Sucesso!", "Instrutor adicionado com Sucesso!", "success")
            });
        }

        $scope.novoInstrutor = {};
    }


    function eraseInst(instrutor) {
        instrutorService.eraseInst(instrutor).then(function () {
            swal("Apagado!", "Instrutor excluído com sucesso!", "success");
            listInst();
        })
        sweetAlert("Oops...", "Alguma falha ocorreu!", "error");
    }

    //Ao iniciar controller

    function listInst() {
        instrutorService.listInst().then(function (response) {
            $scope.instrutores = response.data;
        });
    }
});
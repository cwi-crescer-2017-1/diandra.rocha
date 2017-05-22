var modulo = angular.module("Crud", []);

modulo.controller("Controller", function ($scope) {

    $scope.aulas = [];
    $scope.instrutores = [];

    $scope.encontrarIdAulas = function (id) {
        return $scope.aulas.indexOf($scope.aulas.find(a => a.id === id));
    }

    $scope.encontrarIdInstrutores = function (id) {
        return $scope.instrutores.indexOf($scope.instrutores.find(a => a.id === id));
    }

    $scope.geradorAula = function () {
        if ($scope.aulas.length !== 0) {
            return $scope.aulas[$scope.aulas.length - 1].id + 1;
        } else {
            return 1;
        }
    }
    $scope.geradorInstrutor = function () {
        if ($scope.instrutores.length !== 0) {
            return $scope.instrutores[$scope.instrutores.length - 1].id + 1;
        } else {
            return 1;
        }
    }

    $scope.verificarAula = function (nome) {
        var nomes = $scope.aulas.map(a => a.nomeAula);
        return nomes.includes(nome);
    }

    $scope.verificarInstrutor = function (nome) {
        var nomes = $scope.instrutores.map(a => a.nomeAula);
        return nomes.includes(nome);
    }
    $scope.verificarEmail = function (email) {
        var emails = $scope.instrutores.map(a => a.email);
        return emails.includes(email);
    }

    $scope.novaAula = function (aula) {
        $scope.Formulario1.nomeAula.$setValidity("NomeDuplicado", !$scope.verificarAula(aula.nomeAula));
        if ($scope.Formulario1.$valid) {
            var aulaCopia = angular.copy(aula);
            aulaCopia.id = $scope.geradorAula();
            $scope.aulas.push(aulaCopia);
            swal("Adicionado!", "Aula adicionada com Sucesso!", "success");
        }

        $scope.add = {};
    };

    $scope.novoInstrutor = function (instrutor) {
        $scope.Formulario2.nomeInstrutor.$setValidity("NomeDuplicado", !$scope.verificarInstrutor(instrutor.nomeInstrutor));
        $scope.Formulario2.email.$setValidity("EmailDuplicado", !$scope.verificarEmail(instrutor.email));
        if ($scope.Formulario2.$valid) {
            var instrutorCopia = angular.copy(instrutor);
            instrutorCopia.id = $scope.geradorInstrutor();
            instrutor.fotoUrl = "http://images.complex.com/complex/image/upload/c_limit,w_680/fl_lossy,pg_1,q_auto/t5vj46jc2ecyp2ptmcfo.jpg";
            $scope.instrutores.push(instrutorCopia);
            swal("Adicionado!", "Instrutor adicionado com Sucesso!", "success");
        }
        $scope.add = {};

    };

    $scope.alterarAula = function (novoNomeAula, idPesquisa) {
        var index = $scope.encontrarIdAulas(idPesquisa);
        $scope.aulas[index] = {
            id: idPesquisa,
            nomeAula: novoNomeAula,
        }
        swal("Alterado!", "Aula alterada com Sucesso!", "success");
    }

    $scope.alterarInstrutor = function (idPesquisa, novoNome, novoSobrenome, novaIdade, novoEmail) {
        var index = $scope.encontrarIdInstrutores(idPesquisa);
        $scope.instrutor[index] = {
            id: idPesquisa,
            nomeInstrutor: novoNome,
            sobrenome: novoSobrenome,
            idade: novaIdade,
            email: novoEmail,
            dandoAula: novaOp,
            aulas: novasAulas,
            urlFoto: novaFoto
        }
        swal("Alterado!", "Instrutor alterado com Sucesso!", "success")
    }

    $scope.verificarDandoAula = function (instrutor) {
        return instrutor.dandoAula;
    }

    $scope.removerInstrutor = function (idExcluirInst) {
        let index = $scope.encontrarIdInstrutores(idExcluirInst);
        $scope.RemoverAula.dandoAula.$setValidity("InstrutorDandoAula", !$scope.verificarDandoAula($scope.instrutor[index]));
        if (!verificarDandoAula(instrutores[index])) {
            $scope.instrutores = $scope.instrutores.filter(a => a.id !== idExcluirInst);
            swal("Removido!", "Instrutor removido com Sucesso!", "success")
        } else {
            sweetAlert("Oops...", "Instrutor Dando Aula!", "error");
        }
    }


    $scope.removerAula = function (idExcluirAula) {
        let index = $scope.encontrarIdAulas(idExcluirAula);
        if ($scope.instrutores.aulas.some(idExcluirAula)) {
            sweetAlert("Oops...", "Aula sendo ministrada por instrutor!", "error");
        } else {
            $scope.aulas = $scope.aulas.filter(a => a.id !== idExcluirAula);
            swal("Removido!", "Instrutor removido com Sucesso!", "success")
        }
    }


});
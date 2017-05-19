var modulo = angular.module("Exercício04", []);

modulo.controller("Controller", function ($scope) {

    $scope.instrutores = [];

    $scope.validarRequired = function(){
        return Formulario.$error.required;
    }
    
    $scope.novoInstrutor = function (instrutor) {
        $scope.instrutor = {};
        if($scope.Formulario.$valid){
      $scope.instrutores.push(instrutor);
        }
    };

});
var myApp = angular.module('myApp',[]);


myApp.controller("Controller", function($scope) {
    $scope.pokemon = {
        nome : "Bulbasaur",
        tipo : "Unknow"
    }
});
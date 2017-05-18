var modulo = angular.module("Exercício02", []);

modulo.controller("Controller", function ($scope) {

$scope.click = click;

function click(){
   dataObj = new Date($scope.data);  
   $scope.dataObj = dataObj;
   return dataObj;
}
 
})
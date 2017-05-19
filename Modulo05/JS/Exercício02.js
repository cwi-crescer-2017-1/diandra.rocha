var modulo = angular.module("Exercício02", []);


modulo.filter('mascada', function () {
  return function (nome) {
    return nome.replace(/(nunes)/i, '$ $1 $');
  }
});

modulo.controller("Controller", function ($scope, $filter) {

  function click() {
    dataObj = new Date($scope.data);
    $scope.dataObj = dataObj;
    return dataObj;
  }

  $scope.click = click;

  var instrutores = [{
      nome: 'Bernardo',
      aula: [{
          numero: 1,
          nome: 'OO'
        },
        {
          numero: 4,
          nome: 'Javascript'
        }
      ]
    },
    {
      nome: 'Nunes',
      aula: [{
        numero: 2,
        nome: 'Banco de Dados I'
      }]
    },
    {
      nome: 'Pedro (PHP)',
      aula: [{
        numero: 3,
        nome: 'HTML e CSS'
      }]
    },
    {
      nome: 'Zanatta',
      aula: [{
        numero: 5,
        nome: 'AngularJS'
      }]
    }
  ];

  $scope.instrutores = instrutores;

});
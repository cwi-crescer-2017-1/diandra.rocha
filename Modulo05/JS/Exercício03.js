var modulo = angular.module("Exercício03", []);

modulo.filter('mascada', function () {
    return function (nome) {
        return nome.replace(/(nunes)/i, '$ $1 $');
    }
});
modulo.filter('formata', function () {
    return function (numero, aula) {
        var numberstring = numero + ""; //gambiarra
        return numberstring.padStart(3, "0");
    }
});


modulo.controller("Controller", function ($scope) {

    let instrutores = [{
            nome: 'Pedro (PHP)',
            aula: 'HTML e CSS',
            numero: 3
        },
        {
            nome: 'Zanatta',
            aula: 'AngularJS',
            numero: 5
        },
        {
            nome: 'Bernardo',
            aula: 'OO',
            numero: 1
        },
        {
            nome: 'Bernardo',
            numero: 4,
            aula: 'Javascript'
        },
        {

            nome: 'Nunes',
            aula: 'Banco de Dados I',
            numero: 2,
        }
    ];

    $scope.instrutores = instrutores;
});
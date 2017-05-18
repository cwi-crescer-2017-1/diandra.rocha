var myApp = angular.module('myApp', []);


myApp.controller("Controller", function ($scope) {
    $scope.pokemons = [{
            nome: "Venusaur",
            tipo: "Grass"
        },
        {
            nome: "Charizard",
            tipo: "Fire"
        },
        {
            nome: "Blastoise",
            tipo: "Water"
        },
        {
            nome: "Butterfree",
            tipo: "Bug"
        },
        {
            nome: "Beedrill",
            tipo: "Poison"
        },
        {
            nome: "Pidgeot",
            tipo: "Flying"
        },
        {
            nome: "Sandshrew",
            tipo: "Ground"
        },
        {
            nome: "Clefairy",
            tipo: "Fairy"
        },
        {
            nome: "Primeape",
            tipo: "Fighting"
        },
        {
            nome: "Alakazam",
            tipo: "Psychic"
        }
    ]
});
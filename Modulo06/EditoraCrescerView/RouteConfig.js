var app = angular.module("app", ["ngRoute"]);

app.config(function($routeProvider) {

    $routeProvider
        .when("/home", {
            templateUrl: "/home/home.html"
        })
        .when("/livros", {
            controller: "LivrosController",
            templateUrl: "/livros/livros.html"
        })
        .otherwise({
            redirectTo: "/home"
        });
});
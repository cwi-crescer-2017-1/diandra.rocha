app.controller("LoginController", function($scope, authService) {

    $scope.login = function(usuario) {

        authService.login(usuario)
            .then(
                function(response) {
                    console.log(response);
                    swal("Sucesso!", "Funcionário Logado!", "success")

                },
                function(response) {
                    console.log(response);
                    sweetAlert("Oops...", "Alguma falha ocorreu!", "error");
                });
    };

});
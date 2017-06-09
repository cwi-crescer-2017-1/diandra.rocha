app.controller("ReservaController", reservaController);

function ReservaController($scope, authService, reservaService) {

    $scope.reservas = [];
    $scope.reserva = {};

    $scope.confirmar = confirmar;

    //Salvar
    function confirmar(reserva) {
        let promise = {};

        promise = reservaService.criar(reserva);
        promise.then(function(response) {
                swal("Sucesso!", "Reserva criada com sucesso!", "success")
            },
            function(response) {
                sweetAlert("Oops...", "Alguma falha ocorreu!", "error");

            });
        $scope.reserva = {};
    };
}
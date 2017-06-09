app.factory('reservaService', function($http) {

    let urlBase = 'http://localhost:54411/api/reserva';

    function getTodasAsReservas() {
        return $http.get(urlBase);
    };

    function getReservaPorId(id) {
        return $http.get(urlBase + "/" + id);
    };

    function criar(reservaModel) {
        return $http.post(urlBase, reservaModel);
    }

    return {
        obterTodasAsReservas: getTodasAsReservas,
        obterPorId: getReservaPorId,
        criar: criar
    };
});
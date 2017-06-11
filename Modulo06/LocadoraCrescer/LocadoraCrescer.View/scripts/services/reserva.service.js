locadora.factory('reservaService', function($http) {

    let urlBase = 'http://localhost:49456/api/reserva';

    function getTodasAsReservas() {
        return $http.get(urlBase);
    };

    function getReservaPorId(idreserva) {
        return $http.put(urlBase + "/" + idreserva);
    };

    function criar(reservaModel) {
        return $http.post(urlBase, reservaModel);
    }

    return {
        getTodasAsReservas: getTodasAsReservas,
        getReservaPorId: getReservaPorId,
        criar: criar
    };
});
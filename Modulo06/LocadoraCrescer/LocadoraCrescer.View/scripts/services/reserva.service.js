locadora.factory('reservaService', function($http) {

    let urlBase = 'http://localhost:49456/api/reserva';

    function getTodasAsReservas() {
        return $http.get(urlBase);
    };

    function devolver(idreserva) {
        return $http.put(urlBase + '/' + idreserva);
    };

    function getReservaPorId(idreserva) {
        return $http.get(urlBase + '/detalhes/' + idreserva);
    };


    function criar(reservaModel) {
        return $http.post(urlBase, reservaModel);
    }

    function getRelatorioGeral(date) {
        return $http.get(urlBase + '/relatorio?data=' + date)
    }

    return {
        getTodasAsReservas: getTodasAsReservas,
        devolver: devolver,
        getReservaPorId: getReservaPorId,
        criar: criar
    };
});
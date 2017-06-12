locadora.factory('relatorioService', function($http) {

    let urlBase = 'http://localhost:49456/api/reserva';

    function relatorioGeral(data) {
        return $http.get(urlBase + "/relatorio?data=" + data);
    };

    function relatorioAtrasos() {
        return $http.get(urlBase + "/atraso");
    };

    return {
        relatorioGeral: relatorioGeral,
        relatorioAtrasos: relatorioAtrasos
    }
});
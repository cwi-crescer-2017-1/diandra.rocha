locadora.factory('clienteService', function($http) {

    let urlBase = 'http://localhost:49456/api/cliente';

    function getTodosOsClientes() {
        return $http.get(urlBase);
    };

    function getClientePorCpf(cpf) {
        return $http.get(urlBase + "/" +
            cpf);
    };

    function criar(cliente) {
        return $http.post(urlBase, cliente);
    }

    return {
        getTodosOsClientes: getTodosOsClientes,
        getClientePorCpf: getClientePorCpf,
        criar: criar
    };
});
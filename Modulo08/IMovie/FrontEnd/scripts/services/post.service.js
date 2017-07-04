imovie.factory('postService', function($http) {

    let urlBase = 'http://localhost:9090/api';

    function feedAlheio(id) {
        return $http.get(urlBase + '/feed/' + id);
    };

    function feed() {
        return $http.get(urlBase + '/feed');
    }

    function meuFeed() {
        return $http.get(urlBase + '/meufeed');
    }

    function salvarPost(post) {
        return $http.post(urlBase + '/salvarpost', post);
    }

    function deletarPost(id) {
        return $http.delete(urlBase + '/deletarpost/' + id);
    }

    function buscarPorId(id) {
        return $http.get(urlBase + '/post/' + id);
    }

    function obterCurtidas(id) {
        return $http.get(urlBase + '/curtidas/' + id)
    }

    function obterComentarios(id) {
        return $http.get(urlBase + '/comentariospost/' + id)
    }

    return {
        feedAlheio: feedAlheio,
        feed: feed,
        meuFeed: meuFeed,
        salvarPost: salvarPost,
        deletarPost: deletarPost,
        buscarPorId: buscarPorId,
        obterCurtidas: obterCurtidas,
        obterComentarios: obterComentarios
    };
});
console.log("Nº1");

var verificarAno = function (series) {
    var retorno = false;
    for (let anoEstreia in series) {
        if (series[anoEstreia] >= 2017 || typeof series[anoEstreia] === undefined ||
            series[anoEstreia] === null) {
            retorno = true;
            break;
        }
    }
    return retorno;
}

var verificarCampos = function (series) {
    var retorno = false;
    for (let prop in series) {
        if (typeof series[prop] === undefined || series[prop] === null) {
            retorno = true;
            break;
        }
    }
    return retorno;
}


var invalidos = series.filter(verificarAno, serie => verificarCampos(series));
invalidos.forEach(serie => console.log(serie.titulo));


//2
console.log("Nº2");

function buscarPorAno(series, ano) {
    return resultado = series.filter(serie => serie.anoEstreia > ano);
}
console.log(buscarPorAno(series, 2014));

//3
console.log("Nº3");

var mediaDeEpisodios = function (series) {
    var qtdEps = 0;
    for (let i = 0; i < series.length; i++) {
        qtdEps += series[i].numeroEpisodios;
    }
    var qtdSeries = series.length;
    return qtdEps / qtdSeries;
}

console.log(mediaDeEpisodios(series));

//4
console.log("Nº4");

function buscarPorNome(series, nome) {
    var retorno = false;
    for (let i = 0; i < series.length; i++) {
        if (series[i].elenco.includes(nome)) {
            retorno = true;
            break;
        }
    }
    return retorno;
}

console.log(buscarPorNome(series, 'Diandra Rocha'));

//5

console.log("Nº5");

var salarios = function (series) {
    var qtdDiretores = 0;
    var qtdElenco = 0;

    qtdElenco += series.elenco.length;
    qtdDiretores += series.diretor.length;

    return (qtdDiretores * 100.000) + (qtdElenco * 40.000);
}

console.log(salarios(series[0]) + ".000");

//6
console.log("Nº6");

console.log("Busca por gênero");

function buscarPorGenero(series, genero) {
    return resultado = series.filter(serie => serie.genero.includes(genero));
}

var resultado = buscarPorGenero(series, "Drama");

resultado.forEach(serie => console.log(serie.titulo));


console.log("Busca por Título");

function buscarPorTitulo(series, titulo) {
    return resultado = series.filter(serie => serie.titulo.includes(titulo));
}

var resultado2 = buscarPorTitulo(series, "The");

resultado2.forEach(serie => console.log(serie.titulo));

//7
console.log("Nº7");



function creditosIlluminati(serie){
    
}




console.log("Nº1");

//2
console.log("Nº2");

function buscarPorAno(series, ano) {
    return series.filter(serie => serie.anoEstreia >= ano).map(s => s.titulo);
}
console.log(buscarPorAno(series, 2014));

//3
console.log("Nº3");

var mediaDeEpisodios = function (series) {
    var qtdEps = series.map(e => e.numeroEpisodios).reduce((a, b) => a + b, 0);
    return qtdEps / series.length;
}

console.log(mediaDeEpisodios(series));

//4
console.log("Nº4");

function buscarPorNome(series, nome) {
    return series.some(s => s.elenco.some(s => s.includes(nome)));
}

console.log(buscarPorNome(series, "Diandra Rocha"));

//5

console.log("Nº5");

var salarios = function (serie) {
    return ((serie.diretor.length * 100000) + (serie.elenco.length * 40000));
}

console.log(salarios(series[0]));

//6
console.log("Nº6");

console.log("Busca por gênero");

function buscarPorGenero(series, genero) {
    return series.filter(serie => serie.genero.includes(genero)).map(s => s.titulo);
}
console.log(buscarPorGenero(series, "Drama"));

console.log("Busca por Título");

function buscarPorTitulo(series, titulo) {
    return series.filter(serie => serie.titulo.includes(titulo)).map(s => s.titulo);
}
console.log(buscarPorTitulo(series, "The"));


//7
console.log("Nº7");

function ordenarDentro(pessoa) {
    let nomes = pessoa.trim().split(" ");
    return nomes[nomes.length - 1].join(', ');
}

var ordenacaoDiretores = series.forEach(serie => {
    serie.diretor.sort(pessoa => ordenarDentro(pessoa))
});


var ordenacaoElenco = series.forEach(serie => {
    serie.elenco.sort(pessoa => ordenarDentro(pessoa))
});


console.log("Titulo:");
console.log(series.titulo.join("\n"));
console.log("Diretores:");
console.log(series.sort(ordenacaoDiretores).diretor.join("\n"));
console.log("Elenco");
console.log(series.sort(ordenacaoElenco).elenco.join("\n"));


//8
console.log("Nº8");

function contaAbreviacoes(serie) {
    var elenco = serie.elenco;
    var contador = 0;
    elenco.forEach(ator => {
        if (ator.includes(".")) {
            contador++
        }
    });

    return contador;
}

var serieEasterEgg = series.filter(serie => serie.elenco.length === contaAbreviacoes(serie));
serieEasterEgg.forEach(serie => console.log(serie.elenco));

console.log(serieEasterEgg.titulo.join(","));
console.log("Nº1");

function interna(serie) {
    let algumCampoInvalido = Object.values(serie).some(v => v === null || typeof v === 'undefined');
    let estreiaInvalida = serie.anoEstreia > new Date().getFullYear();
    return estreiaInvalida || algumCampoInvalido;
}

function seriesInvalidas(series) {
    let invalidas = series.filter(serie => interna(serie));
    return `Séries Inválidas: ${ invalidas.map(s => s.titulo).join(" - ") }`;
}

console.log(seriesInvalidas(series));

//2
console.log("Nº2");

function buscarPorAno(series, ano) {
    let busca = series.filter(serie => serie.anoEstreia >= ano);
    return `Séries Por ano: ${ busca.map(s => s.titulo).join(" - ") }`;
}
console.log(buscarPorAno(series, 2014));

//3
console.log("Nº3");

var mediaDeEpisodios = function (series) {
    var qtdEps = series.map(e => e.numeroEpisodios).reduce((a, b) => a + b, 0);
    return `Média entre séries e episódios: ${ qtdEps / series.length }`;
}

console.log(mediaDeEpisodios(series));

//4
console.log("Nº4");

function buscarPorNome(series, nome) {
    return serie = series.filter(s => s.elenco.some(s => s.includes(nome)));
}

var serie = buscarPorNome(series, "Diandra Rocha");
console.log("Série: " + serie.map(s => s.titulo));

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
    return series.filter(serie => serie.genero.includes(genero)).map(s => s.titulo).join(", ");
}

console.log(buscarPorGenero(series, "Drama"));

console.log("Busca por Título");

function buscarPorTitulo(series, titulo) {
    return series.filter(serie => serie.titulo.includes(titulo)).map(s => s.titulo).join(", ");
}
console.log(buscarPorTitulo(series, "The"));


//7
console.log("Nº7");

String.prototype.ordenarDentro = function (a, b) {
    let partesNome = this.trim().split(" ");
    return partesNome[partesNome.length - 1];
}

function ordenar(s1, s2) {
    return s1.ordenarDentro().localeCompare(s2.ordenarDentro());
}

function creditosIlluminatis(serie) {

    let elencoOrdenado = serie.elenco.sort(ordenar);
    let diretoresOrdenados = serie.diretor.sort(ordenar);

    console.log("Título");
    console.log(serie.titulo);
    console.log("Diretores");
    console.log(diretoresOrdenados.join("\n"));
    console.log("Elenco");
    console.log(elencoOrdenado.join("\n"));
}


console.log(creditosIlluminatis(serie[0]));


//8
console.log("Nº8");

String.prototype.temAbreviacao = function () {
    return this.match(/ [A-Z][.] /gi) !== null;
}

function descobrirSerieComTodosAbreviados() {
    let elencoSerie = series
        .find(s => s.elenco.every(e => e.temAbreviacao()))
        .elenco
        .map(e => e.match(/ [a-z][.] /gi)[0][1])
        .join("");
    return `#${ elencoSerie }`;
}

console.log(descobrirSerieComTodosAbreviados());

///Printar séries


var divSubset = document.getElementById("subset");
var subset = series[4];

function titulo(serie) {
    let h1 = document.createElement("h1");
    h1.innerText = `${ serie.titulo + " (" + serie.anoEstreia+ ")" }`;
    divSubset.append(h1);
}

function elenco(serie) {
    let h3 = document.createElement("h3");
    h3.innerText = "Elenco:";
    let ul = document.createElement("ul");
    var li;
    serie.elenco.forEach(e => {
        li = document.createElement("li");
        li.innerText = `${ e }`;
        ul.appendChild(li);
    })
    divSubset.append(h3);
    divSubset.append(ul);
}

function diretores(serie) {
    let h3 = document.createElement("h3");
    h3.innerText = "Diretores:";
    let ul = document.createElement("ul");
    var li;
    serie.diretor.forEach(e => {
        li = document.createElement("li");
        li.innerText = `${ e }`;
        ul.appendChild(li);
    })
    divSubset.append(h3);
    divSubset.append(ul);
}

function genero(serie) {
    let h3 = document.createElement("h3");
    h3.innerText = "Diretores:";
    let ul = document.createElement("ul");
    var li;
    serie.diretor.forEach(e => {
        li = document.createElement("li");
        li.innerText = `${ e }`;
        ul.appendChild(li);
    })
    divSubset.append(h3);
    divSubset.append(ul);
}

titulo(series[4]);
elenco(series[4]);
diretores(series[4]);
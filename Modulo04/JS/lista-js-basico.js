//1
function daisyGame(a) {
    return a % 2 === 0 ? "Love Me Not" : "Love Me";
}
console.log(daisyGame(4));

//2
var nomes = ["Cersei", "Joffrey", "Ilyn", "Maryn", "Beric", "Melisandre", "Sandor"];

function maiorTexto(nomes) {
    var maiorQtdChar = 0;
    var maiorPalavra;
    for (var i = 0; i < nomes.length; i++) {
        if (nomes[i].length > maiorQtdChar) {
            maiorQtdChar = nomes[i].length;
            maiorPalavra = nomes[i];
        }
    }
    return maiorPalavra;
}

console.log(maiorTexto(nomes));

//3

var nomesInst = ["Bernardo", "André", "PHP", "Fabrício", "Ben-Hur", 5];

function funcao(nome) {
    return console.log("Olá querido instrutor:", nome);
}

function imprime(funcao, nomesInst) {
    return funcao(nomesInst[i]);
}

for (var i = 0; i < nomesInst.length; i++) {
    if (typeof nomesInst[i] !== "string") {
        console.log("Jabulani");
    } else
        console.log(imprime(funcao, nomesInst));
}

//4
function somar(a, b) {
    return a + b;
}

console.log(somar(2));
console.log(somar(3));

//5
function fib1(n) {
    if (n < 2) {
        return n
    }
       var a = fib1(n - 1) + fib1(n - 2);
    
     return a;
}

console.log(fib1(7));


//6

var listaPrecos = [5.16, 2.12, 1.15, 3.11, 17.5];
var mascada = 3.14;

function ordenar(listaPrecos) {
    for (var i = 0; i < listaPrecos.length; i++) {
        if (listaPrecos[i] > listaPrecos[i + 1]) {
            var aux = listaPrecos[i];
            listaPrecos[i] = listaPrecos[i + 1];
            listaPrecos[i + 1] = aux;
        }
    }
    return listaPrecos;
}

function queroCafe(mascada, listaPrecos, ordenar) {
    ordenar(listaPrecos);
    if (listaPrecos[i] < mascada) {
        var result = listaPrecos[i] + ", ";
    }

    return result;
}

console.log(queroCafe(mascada, listaPrecos));
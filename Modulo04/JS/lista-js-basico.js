//1
console.log("Nº1");
function daisyGame(a) {
    return a % 2 === 0 ? "Love Me Not" : "Love Me";
}

function daisyGameDiferentona(a) {
    return `Love Me${ a % 2 !== 0 ? '' : ' Not'}`;
}

console.log(daisyGame(4));
console.log(daisyGameDiferentona(1));

//2
console.log("Nº2");
var nomes = ["Cersei", "Joffrey", "Ilyn", "Maryn", "Beric", "Melisandre", "Sandor"];
var outroNomes = [];

function maiorTexto(nomes) {
    var maiorQtdChar = 0;
    var maiorPalavra;

    if (nomes.length !== 0) {
        for (var i = 0; i < nomes.length; i++) {
            if (nomes[i].length > maiorQtdChar) {
                maiorQtdChar = nomes[i].length;
                maiorPalavra = nomes[i];
            }
        }
        return maiorPalavra;

    } else {
        return maiorPalavra = "Array Vazio";
    }
}

console.log(maiorTexto(nomes));
console.log(maiorTexto(outroNomes));


//3
console.log("Nº3");
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
console.log("Nº4");
function somar(a) {
    return function (b) {
        return a + b;
    }
}

var soma = somar(2)(3);
console.log(soma);
console.log(somar(4)(4));

//5
console.log("Nº5");
var fibonacciSoma = function(n) {
    var a = 0, b = 1, final = 0;
    for (var i = 0; i <= n; i++) {
        var f = a;
        a = b;
        b += f;
        final = a + f;
    }
    return final -1;
};

function fiboSequence(n) {
    if(n === 1 || n === 2){
        return 1;
    }
    return fiboSequence(n-1) + fiboSequence(n-2);
}

console.log("Soma");
console.log(fibonacciSoma(3));
console.log(fibonacciSoma(7));
console.log(fibonacciSoma(1));
console.log("Sequencia");
console.log(fiboSequence(3));
console.log(fiboSequence(7));
console.log(fiboSequence(1));


//6
console.log("Nº6");
var listaPrecos = [5.16, 2.12, 1.15, 3.11, 17.5];
var mascada = 3.14;

function ordenar(listaPrecos) {
    listaPrecos = listaPrecos.sort(function (a, b) {
        return a - b;
    });
}

function queroCafe(mascada, listaPrecos, ordenar) {
    ordenar(listaPrecos);

    var result = "";
    for (var i = 0; i < listaPrecos.length; i++) {
        if (listaPrecos[i] < mascada) {
            result += "," + listaPrecos[i];
        }
    }
    return result;
}

var resultado = queroCafe(mascada, listaPrecos, ordenar);
console.log(resultado);
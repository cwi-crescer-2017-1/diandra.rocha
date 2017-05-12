//1
function daisyGame(a) {
    return a % 2 === 0 ? "Love Me Not" : "Love Me";
}

function daisyGameDiferentona(a) {
    return `Love Me${ a % 2 !== 0 ? '' : ' Not'}`;
}

console.log(daisyGame(4));
console.log(daisyGameDiferentona(1));

//2
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
function somar(a) {
    return function (b) {
        return a + b;
    }
}

var soma = somar(2)(3);
console.log(soma);

//5

function fib(n) {
    var a = 1;
    var b = 1;
    var temp;
    var final = 0;
    var nn = n;

    while (nn > n) {
        temp = b;
        b = a + b;
        a = temp;
        n--;
        final = b + a;
    }
    return final;
}

console.log(fib(7));


//6

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
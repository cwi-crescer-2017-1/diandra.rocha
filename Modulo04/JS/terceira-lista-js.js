function arredondar(numero, casas){
    casas = casas || 2;
    return numero.toFixed(casas) || numero.toFixed(2);
}

console.log(arredondar(12.4444, 3));
console.log(arredondar(12.4444));
function arredondamento(numero, casas){
    casas = casas || 2;
    return parseFloat(numero.arredondar(casas) || numero.arredondar(2));
}

Number.prototype.arredondar = function(decimals) {
 return Math.round(this * Math.pow(10, decimals)) / (Math.pow(10, decimals)); 
};

console.log(arredondamento(12.4444, 3));
console.log(arredondamento(12.4444));
console.log("Carregado!");

//alert("Olááááá");

function funcao (a,b,c){
    a+b+c;
}

function funcao (a,b,c){
    return a+b+c;
}

if(funcao(1,2,3)==="undefined"){
    console.log("Indefinido")
}else{
    console.log(typeof funcao);
}

var multArrowFunction = (a,b,c) => a*b*c;

console.log(multArrowFunction(1,2,3));

var mult = 1*5;

console.log(mult);




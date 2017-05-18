var urlpoke = document.addEventListener('DOMContentLoaded', function () {
    let btnPesquisar = document.getElementById('btnPesquisar').value;
    let campoPesquisar = document.getElementById('pesquisa');
    btnPesquisar.onclick = function () {
        return "https://pokeapi.co/api/v2/pokemon/" + campoPesquisar.value;
    }
})

fetch(urlpoke).then(response => response.json())
    .then(json => {
        console.log(json);
        let div = document.getElementById('detalhesPokemon');
        let h1 = document.createElement("h1");
        h1.innerText = json.name;
        let img = document.createElement('img');
        img.src = json.sprites.front_default;
        let h3 = document.createElement("h3");
        h3.innerText = json.id;
        let ul = document.createElement("ul");
        var li;
        json.types.type.name.forEach(e => {
            li = document.createElement("li");
            li.innerText = `${ e }`;
            ul.appendChild(li);
        })
        div.append(h1)
        div.append(img);
        div.append(h3);
        div.append(ul);
    })
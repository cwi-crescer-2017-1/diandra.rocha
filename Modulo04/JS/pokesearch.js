var pokeid = document.addEventListener('DOMContentLoaded', function () {
    let btnPesquisar = document.getElementById('btnPesquisar');
    btnPesquisar.onclick = function () {
        return btnPesquisar.value + "/";
    }
})

fetch("http://pokeapi.co/api/v2/pokemon/" + pokeid()).then(response => response.json())
    .then(json => {
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
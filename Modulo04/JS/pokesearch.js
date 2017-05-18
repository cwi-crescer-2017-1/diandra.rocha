document.addEventListener('DOMContentLoaded', function () {
    let btnPesquisar = document.getElementById('btnPesquisar');
    let campoPesquisar = document.getElementById('pesquisa');

    btnPesquisar.onclick = function () {
        let url = "https://pokeapi.co/api/v2/pokemon/" + campoPesquisar.value;
        fetch(url)
            .then(response => response.json())
            .then(json => {
                console.log(json);
                let div = document.getElementById('detalhesPokemon');
                div.innerHTML = "";
                let h1 = document.createElement("h1");
                h1.innerText = json.name;
                let img = document.createElement('img');
                img.src = json.sprites.front_default;
                let h3 = document.createElement("h3");
                h3.innerText = "ID: " + json.id;
                let h4 = document.createElement("h4");
                h4.innerText = "Tipo:";
                let ul = document.createElement("ul");
                var li;
                json.types.forEach(e => {
                    li = document.createElement("li");
                    li.innerText = `${ e.type.name }`;
                    ul.appendChild(li);
                })
                div.append(h1)
                div.append(img);
                div.append(h3);
                div.append(h4);
                div.append(ul);
            })
    }
});
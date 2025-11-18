// MENU
function toggleMenu() {
    const m = document.getElementById("menu");
    m.style.display = m.style.display === "flex" ? "none" : "flex";
}

function loadStock() {
    Papa.parse("data/inventaire.csv", {
        download: true,
        header: true,
        complete: function(results) {

            const list = results.data;
            const grid = document.querySelector(".stock-grid");
            if (!grid) return;

            grid.innerHTML = "";

            list.forEach(card => {
                if (!card.Nom) return;

                grid.innerHTML += `
                    <div class="stock-card">
                        <strong>${card.Nom}</strong><br>
                        Extension : ${card.Extension}<br>
                        Catégorie : ${card.Categorie}<br>
                        Prix : ${card.Prix} €<br>
                        Stock : ${card.Stock}
                    </div>
                `;
            });
        }
    });
}


function loadSerie(serieName) {
    Papa.parse("data/inventaire.csv", {
        download: true,
        header: true,
        complete: function(results) {
            const all = results.data;
            const list = all.filter(c => c.Extension === serieName);

            const container = document.getElementById("cardlist");

            list.forEach(card => {
                const imgPath = `pokemon/${card.Nom}-${card.NumeroDansSerie}.jpg`;

                container.innerHTML += `
                    <div class="pokemon-card">
                        <img src="${imgPath}" alt="${card.Nom}">
                        <strong>${card.Nom}</strong><br>
                        ${card.NumeroDansSerie}/${card.TailleSerie}<br>
                        Rareté : ${card.Rarete}
                    </div>
                `;
            });
        }
    });
}


// Charger stock automatiquement sur index.html
if (window.location.pathname.includes("index")) {
    loadStock();
}

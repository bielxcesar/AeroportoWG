document.addEventListener("DOMContentLoaded", function () {
    const urlParams = new URLSearchParams(window.location.search);
    const passageiroId = urlParams.get("passageiroId"); 

    console.log("ID recebido da URL:", passageiroId); 

    if (passageiroId && !isNaN(passageiroId)) { 
        listarVoosPorPassageiro(passageiroId);
    } else {
        listarTodosVoos();
    }
});

// 🔹 Navegação entre páginas
function voltarParaIndex() {
    window.location.href = "index.html";
}

function voltarParaConsultar() {
    window.location.href = "consultar.html";
}

// 🔹 Listar todos os voos
function listarTodosVoos() {
    fetch("http://localhost:8080/Voos")
        .then(response => response.ok ? response.json() : Promise.reject("Erro ao carregar voos"))
        .then(voos => preencherTabela(voos))
        .catch(error => console.error("Erro ao listar voos:", error));
}

// 🔹 Listar voos por passageiro
function listarVoosPorPassageiro(id) {
    fetch(`http://localhost:8080/Voos/id/${id}`)
        .then(response => response.json())
        .then(voos => preencherTabela(Array.isArray(voos) ? voos : [voos]))
        .catch(error => console.error("Erro ao buscar voos:", error));
}

// 🔹 Formatar data para exibição
function formatarDataISO(isoString) {
    if (!isoString) return "—";

    let dataObj = new Date(isoString);
    return `${dataObj.getUTCFullYear()}-${(dataObj.getUTCMonth() + 1).toString().padStart(2, '0')}-${dataObj.getUTCDate().toString().padStart(2, '0')}`;
}

// 🔹 Exibir modal de atualização
function AtualizaVoo(id, saida, destino, horaIda, horaVolta, diaIda, diaVolta) {
    console.log(`Abrindo modal de atualização para o voo ID: ${id}, Saída: ${saida}, Destino: ${destino}`);

    document.getElementById("modalBackground").style.display = "flex";
    document.getElementById("modalVooId").value = id;
    document.getElementById("modalSaida").value = saida;
    document.getElementById("modalDestino").value = destino || "—";
    document.getElementById("modalHoraIda").value = horaIda;
    document.getElementById("modalHoraVolta").value = horaVolta;
    document.getElementById("modalDiaIda").value = formatarDataISO(diaIda);
    document.getElementById("modalDiaVolta").value = formatarDataISO(diaVolta);
}

// 🔹 Fechar modal
function fecharModal() {
    document.getElementById("modalBackground").style.display = "none";
}

// 🔹 Confirmar atualização do voo
function confirmarAtualizacao() {
    let id = document.getElementById("modalVooId").value;
    let horaIda = document.getElementById("modalHoraIda").value;
    let horaVolta = document.getElementById("modalHoraVolta").value;
    let diaIda = document.getElementById("modalDiaIda").value;
    let diaVolta = document.getElementById("modalDiaVolta").value;

    if (confirm(`Deseja realmente remarcar o voo ${id}?`)) {
        fetch(`http://localhost:8080/Voos/atualizar/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ horaIda, horaVolta, diaIda, diaVolta })
        })
        .then(response => response.ok ? alert("Voo atualizado com sucesso!") : alert("Erro ao atualizar o voo!"))
        .catch(error => console.error("Erro ao atualizar voo:", error));

        fecharModal();
        window.location.href = "consultar.html"; // Redireciona para a página inicial
    }
}

// 🔹 Preencher tabela com os voos recebidos
function preencherTabela(voos) {
    let tabela = document.getElementById("tabelaVoo");
    tabela.innerHTML = "";

    if (voos.length === 0) {
        tabela.innerHTML = "<tr><td colspan='8'>Nenhum voo encontrado.</td></tr>";
        return;
    }

    voos.forEach(voo => {
        let row = tabela.insertRow();
        row.innerHTML = `
            <td>${voo.id}</td>
            <td>${voo.saida}</td>
            <td>${voo.destino}</td>
            <td>${voo.horaIda || "—"}</td>
            <td>${voo.horaVolta || "—"}</td>
            <td>${formatarDataISO(voo.diaIda)}</td>
            <td>${formatarDataISO(voo.diaVolta)}</td>
            <td><button onclick="AtualizaVoo(${voo.id}, '${voo.saida}', '${voo.destino}', '${voo.horaIda}', '${voo.horaVolta}', '${voo.diaIda}', '${voo.diaVolta}')">✏️ Remarcar</button></td>
        `;
    });
}

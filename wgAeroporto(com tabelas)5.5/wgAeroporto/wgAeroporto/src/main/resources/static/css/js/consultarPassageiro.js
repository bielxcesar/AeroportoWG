document.addEventListener("DOMContentLoaded", function () {

    listarTodosPassageiros(); // Carrega todos os passageiros ao iniciar
    document.getElementById("buscarBtn").addEventListener("click", buscarPassageiro);
});
function voltarParaIndex() {
    window.location.href = "index.html"; // Redireciona para a página inicial
}

function listarVoosPorPassageiro(id) {
    if (!id) {
        console.error("Erro: ID do passageiro não foi fornecido!");
        return;
    }

    fetch(`http://localhost:8080/voos/passageiro/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Nenhum voo encontrado para este passageiro!");
            }
            return response.json();
        })
        .then(voos => preencherTabela(voos))
        .catch(error => alert(error.message));
}
function buscarPassageiro() {
    let id = document.getElementById("idInput").value.trim();

    if (!id || isNaN(id)) {
        alert("Por favor, insira um ID válido (apenas números).");
        return;
    }

    fetch(`http://localhost:8080/passageiros/id/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Passageiro não encontrado!");
            }
            return response.json();
        })
        .then(passageiro => preencherTabela([passageiro])) // Envia um array com o passageiro único
        .catch(error => alert(error.message));
}

function listarTodosPassageiros() {
    fetch(`http://localhost:8080/passageiros`)
        .then(response => response.json())
        .then(passageiros => preencherTabela(passageiros))
        .catch(error => console.error("Erro ao listar passageiros:", error));
}
function formatarData(data) {
    let dataObj = new Date(data);
    let dia = dataObj.getDate().toString().padStart(2, '0');
    let mes = (dataObj.getMonth() + 1).toString().padStart(2, '0');
    let ano = dataObj.getFullYear();
    return `${dia}/${mes}/${ano}`;
}
function deletarPassageiro(id) {
    if (!confirm("Tem certeza que deseja excluir este passageiro?")) return; // Confirmação antes de deletar

    fetch(`http://localhost:8080/passageiros/delete/${id}`, {
        method: "DELETE"
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro ao excluir passageiro!");
        }
        alert("Passageiro deletado com sucesso!");
        listarTodosPassageiros(); // Atualiza a tabela após exclusão
    })
    .catch(error => alert(error.message));
}

function preencherTabela(passageiros) {
    let tabela = document.getElementById("tabelaPassageiro");
    tabela.innerHTML = ""; // Limpa a tabela antes de inserir novos dados

    passageiros.forEach(passageiro => {
        let row = tabela.insertRow();
        row.innerHTML = `
            <td>${passageiro.id}</td>
            <td>${passageiro.nome}</td>
            <td>${passageiro.sobrenome}</td>
            <td>${passageiro.email}</td>
            <td>${passageiro.celular}</td>
            <td>${formatarData(passageiro.dataNascimento)}</td> <!-- Agora formatado -->
            <td>${passageiro.genero}</td>
            <td>${passageiro.cpf}</td>
            <td><button onclick="deletarPassageiro(${passageiro.id})">❌ Deletar</button></td>
            <td><button onclick="consultarVoo(${passageiro.id})" class="btn-consultar">✈️ Voo</button></td>
        `;
    });
}

function consultarVoo(id) {
    window.location.href = `consultarVoo.html?passageiroId=${id}`; // Redireciona para a página de voos com o ID
}
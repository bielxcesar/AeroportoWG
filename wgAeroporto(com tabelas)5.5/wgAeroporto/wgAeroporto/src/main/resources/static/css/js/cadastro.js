document.addEventListener("DOMContentLoaded", () => {
  // Exibir dados do voo selecionado
  const dados = JSON.parse(localStorage.getItem("vooSelecionado"));

  if (dados) {
    document.getElementById("nomePacote").textContent = dados.destino;
    document.getElementById("precoPacote").textContent = dados.valor;
    document.getElementById("saida").textContent = dados.origem;
    document.getElementById("destino").textContent = dados.destino.substring(0, 3).toUpperCase();
    document.getElementById("horaIda").textContent = "08:00";
    document.getElementById("horaVolta").textContent = "18:00";
    document.getElementById("diaIda").textContent = dados.ida;
    document.getElementById("diaVolta").textContent = dados.volta;
  }

  // Cadastro de passageiro com debug
  document.getElementById("formPassageiro").addEventListener("submit", function (e) {
    e.preventDefault();

    const formData = new FormData(this);
    const passageiro = Object.fromEntries(formData.entries());

      fetch("http://localhost:8080/passageiros/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(passageiro)
    })

        .then(resp => {
          console.log("Status da resposta:", resp.status);
          return resp.json();
        })
        .then(data => {
          console.log("Resposta da API:", data);
          if (data && data.id) {
            alert("Passageiro cadastrado com ID: " + data.id);
            document.getElementById("id").value = data.id;
          } else {
            alert("Passageiro cadastrado, mas ID não retornado.");
          }
        })
        .catch(err => {
          console.error("Erro ao cadastrar passageiro:", err);
          alert("Erro ao cadastrar passageiro.");
        });
  });

  // Cadastro de voo
  document.getElementById("btnSalvarVoo").addEventListener("click", () => {
    const idPassageiro = document.getElementById("id").value;

    if (!idPassageiro) {
      alert("Preencha o ID do passageiro.");
      return;
    }

    const voo = {
      passageiroId: parseInt(idPassageiro),
      destino: dados.destino,
      origem: dados.origem,
      horaIda: "08:00",
      horaVolta: "18:00",
      diaIda: dados.ida,
      diaVolta: dados.volta,
      preco: parseFloat(dados.valor)
    };

    fetch("http://localhost:8080/voos/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(voo)
    })
        .then(resp => {
          if (resp.ok) {
            alert("Voo salvo com sucesso!");
            window.location.href = "consultar.html";
          } else {
            alert("Erro ao salvar voo.");
          }
        })
        .catch(() => alert("Erro na requisição."));
  });
});

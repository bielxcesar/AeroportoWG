document.addEventListener("DOMContentLoaded", () => {
    // Animação suave nos cards
    const pacotes = document.querySelectorAll('.pacote');
    pacotes.forEach((el, i) => {
        setTimeout(() => {
            el.style.opacity = '1';
            el.style.transform = 'translateY(0)';
        }, i * 150);
    });

    // Clique nos pacotes para salvar dados e redirecionar
    document.querySelectorAll(".pacote").forEach(pacote => {
        pacote.addEventListener("click", () => {
            const destino = pacote.querySelector("h3").innerText;
            const detalhes = pacote.querySelector("p").innerText;
            const [idaTxt, voltaTxt] = detalhes.match(/\d{2}\/\d{2}/g);
            const valor = detalhes.match(/R\$[\s]?\d+[.,]?\d*/g)[0].replace(/[R$\s]/g, "");

            const dadosVoo = {
                destino: destino,
                origem: "São Paulo",
                ida: idaTxt,
                volta: voltaTxt,
                valor: valor
            };

            localStorage.setItem("vooSelecionado", JSON.stringify(dadosVoo));
            window.location.href = "cadastro.html";
        });
    });
});

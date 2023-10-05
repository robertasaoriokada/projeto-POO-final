document.addEventListener("DOMContentLoaded", function () {
  const formularioPessoa = document.querySelector("form");
  const iNome = document.querySelector("#nome");
  const iTelefone = document.querySelector("#telefone");
  const iRg = document.querySelector("#rg");

  function cadastrar() {
    fetch("http://localhost:8080/pessoa", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify({
        nome: iNome.value,
        telefone: iTelefone.value,
        rg: iRg.value,
      }),
    })
      .then(function (res) {
        console.log(res);
      })
      .catch(function (res) {
        console.log(res);
      });
  }

  function limparCampos() {
    iNome.value = "";
    iTelefone.value = "";
    iRg.value = "";
  }

  formularioPessoa.addEventListener("submit", function (event) {
    event.preventDefault();

    cadastrar();
    limparCampos();
  });
});

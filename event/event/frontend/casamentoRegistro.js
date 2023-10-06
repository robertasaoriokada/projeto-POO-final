document.addEventListener("DOMContentLoaded", function () {
  const formularioCasamento = document.querySelector("form");
  const iLugar = document.querySelector("#lugar");
  const iData_Hora = document.querySelector("#data_hora");
  const iConjuge1 = document.querySelector("#conjuge1");
  const iConjuge2 = document.querySelector("#conjuge2");
  const iConvidados = document.querySelector("#convidados");

  function cadastrar() {
    fetch("http://localhost:8080/casamento", {
      headers: {
        "Access-Control-Allow-Origin": "http://127.0.0.1:5500",
        "Access-Control-Allow-Headers":
          "Origin, X-Requested-With, Content-Type, Accept",
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify({
        lugar: iLugar.value,
        data_hora: new Date(iData_Hora.value).getTime(),
        noivo1: { id: +iConjuge1.value },
        noivo2: { id: +iConjuge2.value },
        convidados: iConvidados.value,
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
    iLugar.value = "";
    iData_Hora.value = "";
    iConjuge1.value = "";
    iConjuge2.value = "";
    iConvidados.value = "";
  }

  formularioCasamento.addEventListener("submit", function (event) {
    event.preventDefault();

    cadastrar();
    limparCampos();
  });
});

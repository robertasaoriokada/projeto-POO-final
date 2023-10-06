document.addEventListener("DOMContentLoaded", function () {
  const iIdCasamento = document.querySelector("#id-casamento");
  const formularioCasamento = document.querySelector("form");
  const iLugar = document.querySelector("#lugar");
  const iData_Hora = document.querySelector("#data_hora");
  const iConjuge1 = document.querySelector("#conjuge1");
  const iConjuge2 = document.querySelector("#conjuge2");
  const iConvidados = document.querySelector("#convidados");

  function editarCasamento(casamentoId) {
    fetch(`http://localhost:8080/casamento/${casamentoId}`, {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "PATCH",
      body: JSON.stringify({
        lugar: iLugar.value,
        data_hora: new Date(iData_Hora.value).getTime(),
        noivo1: { id: +iConjuge1.value },
        noivo2: { id: +iConjuge2.value },
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
    iIdCasamento.value = "";
    iLugar.value = "";
    iData_Hora.value = "";
    iConjuge1.value = "";
    iConjuge2.value = "";
    iConvidados.value = "";
  }

  formularioCasamento.addEventListener("submit", function (event) {
    event.preventDefault();
    const casamentoId = +iIdCasamento.value;
    editarCasamento(casamentoId);
    limparCampos();
  });
});

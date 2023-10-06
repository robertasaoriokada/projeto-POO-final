document.addEventListener("DOMContentLoaded", function () {
  function listarTodos() {
    fetch("http://localhost:8080/casamento", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "GET",
    })
      .then(function (res) {
        if (!res.ok) {
          throw new Error("Erro na requisição");
        }
        return res.json();
      })
      .then(function (data) {
        const tabelaCasamentos = document.getElementById("tabela-casamento");
        const tbody = tabelaCasamentos.querySelector("tbody");
        tbody.innerHTML = "";
        data.forEach((casamento) => {
          const row = document.createElement("tr");
          row.innerHTML = `
          <td>${casamento.id}</td>
          <td>${casamento.lugar}</td>
          <td>${casamento.data_hora}</td>
          <td>${casamento.noivo1.nome}</td>
          <td>${casamento.noivo2.nome}</td>
          <td><button id="editar" class="btn-editar" onclick="location.href = 'editarCasamento.html'" value="${casamento.id}">Editar</button></td>
          <td><button id="excluir" class="btn-excluir" value="${casamento.id}">Excluir</button></td>
          `;
          tbody.appendChild(row);
          // tbody.addEventListener("click", function (e) {
          //   if (e.target.classList.contains("btn-editar")) {
          //     const casamentoId = e.target.getAttribute("value");
          //     editarCasamento(casamentoId);
          //   }
          // });
          tbody.addEventListener("click", function (e) {
            if (e.target.classList.contains("btn-excluir")) {
              const casamentoId = e.target.getAttribute("value");
              excluirCasamento(casamentoId);
            }
          });
        });
        console.log("Lista de Casamentos:", data);
      })
      .catch(function (res) {
        console.log(res);
      });
  }

  function excluirCasamento(casamentoId) {
    fetch(`http://localhost:8080/casamento/${casamentoId}`, {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "DELETE",
    })
      .then(function (res) {
        if (!res.ok) {
          throw new Error("Erro na requisição");
        }
        return res.json();
      })
      .then(function (data) {
        console.log("Casamento excluído com sucesso.");
        listarTodos();
      })
      .catch(function (res) {
        console.log(res);
      });
  }

  // function editarCasamento(casamentoId) {
  //   fetch(`http://localhost:8080/casamento/${casamentoId}`, {
  //     headers: {
  //       Accept: "application/json",
  //       "Content-Type": "application/json",
  //     },
  //     method: "PATCH",
  //     body: JSON.stringify({
  //       lugar: iLugar.value,
  //       data_hora: new Date(iData_Hora.value).getTime(),
  //       noivo1: { id: +iConjuge1.value },
  //       noivo2: { id: +iConjuge2.value },
  //       convidados: iConvidados.value,
  //     }),
  //   })
  //     .then(function (res) {
  //       if (!res.ok) {
  //         throw new Error("Erro na requisição");
  //       }
  //       return res.json();
  //     })
  //     .then(function (data) {
  //       console.log("Casamento editado com sucesso.");
  //       listarTodos();
  //     })
  //     .catch(function (res) {
  //       console.log(res);
  //     });
  //}
  listarTodos();
});

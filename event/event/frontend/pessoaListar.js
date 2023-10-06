document.addEventListener("DOMContentLoaded", function () {
  function listarTodos() {
    fetch("http://localhost:8080/pessoa", {
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
        console.log("Lista de Pessoas:", data);
      })
      .catch(function (res) {
        console.log(res);
      });
  }
  listarTodos();
});

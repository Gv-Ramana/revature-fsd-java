const urlParams = new URLSearchParams(window.location.search);
const currentId = urlParams.get('id');

(async function () {
    try {
     let response = await fetch("http://localhost:8080/bank-app-rest/accounts/"+ currentId);
       let accounts = await response.json();
      var acc = "";
      for (let account of accounts) {
        acc += ` <div class="col-sm-6">
      <div class="card card text-dark bg-light mb-3 card border-danger mb-3">
        <div class="card-body">
          <h5>Account Number : ${account.AccountNumber}</h5>
         
          <div class="badge badge-success">Balance : ${account.balance}</div><br><br>
         
        </div>
      </div>
    </div>`;
      }
      document.getElementById("accounts").innerHTML = acc;
  
  
    } catch (err) {
  
    }
  })();
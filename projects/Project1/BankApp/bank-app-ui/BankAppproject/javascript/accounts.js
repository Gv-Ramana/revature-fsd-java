async function getAccounts() {
    var options = {
      credentials: 'include'
    };
    try{
    let response = await fetch("http://localhost:8080/bank-app-rest/accounts");
    let accounts = await response.json();
    console.log("Method Executed");
    console.log(accounts);
    let element = "";
    for (var account of accounts) {
      element += `
            <div class="col-12  col-lg-4">
              <div class="card mb-3">
                <div class="card-body">
                  <h5 class="card-title">Account Number :${account.accountId}</h5>
                  <p class="card-text">Balance :${account.balance} </p>
                  <a href="deposit.html?id=${account.accountId}" class="btn btn-primary mr-auto mb-3">Deposit</a>
                  <a href="withdraw.html?id=${account.accountId}" class="btn btn-primary mr-auto mb-3">Withdraw</a>
                  <a href="transactions.html?id=${account.accountId}" class="btn btn-primary mr-auto mb-3">Transactions</a>
                </div>
              </div>
            </div>
          </div>`
    }
    document.getElementById("accounts").innerHTML = element;}
    catch(err){
      //document.getElementById("accounts").innerHtml = "Error";
      console.log("error");
    }
  }
  getAccounts();
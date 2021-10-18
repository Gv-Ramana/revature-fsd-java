const urlParams = new URLSearchParams(window.location.search);
const currentAccountId = urlParams.get('id');
let tabled = document.getElementById("transactionTable");
console.log(currentAccountId);

let accountNumberDisplay = document.getElementById("accountNumberDisplay");
 accountNumberDisplay.innerText = "Transactions of Account Number : " + currentAccountId;


 async function showTransactions(){
    let transaction ={
        accountId : currentAccountId
    };
    // var options = {
    //     method: 'POST',
    //     headers: { "Content-Type": "application/json" },
    //     body: JSON.stringify(transaction)
    // };
    let response = await fetch("http://localhost:8080/bank-app-rest/transactions/"+currentAccountId);
    let transactions = await response.json();
    if(transactions.length != 0){
    let element = "";
    for (var tran of transactions) {
            element += `<tr>
            <td>${tran.id}</td>
            <td>${tran.type}</td>
            <td>${tran.money}</td>
          </tr>`
        }
    document.getElementById("cust").innerHTML = element;
    console.log(element);}
    else{
        document.getElementById("noTransactions").innerText = "No transactions to see";
       tabled.style.display = "none";
    }
 }
 showTransactions();
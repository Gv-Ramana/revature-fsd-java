const urlParams = new URLSearchParams(window.location.search);
const currentAccountId = urlParams.get('id');
console.log(currentAccountId);

let amountEntered = document.getElementById("amount");
let setAccountNumber = document.getElementById("setAccountNumber");
let depositBtn = document.getElementById("depositButton")

let amountError = document.getElementById("amountError");
let successMessage = document.getElementById("success");
let errorMessage = document.getElementById("error");

successMessage.style.display = "none";
errorMessage.style.display = "none";

setAccountNumber.innerText = "Account Number : " + currentAccountId;

depositBtn.addEventListener("click", function () {
    amountEnteredValid = true;
    if (amountEntered.value == "") {
        amountError.innerText = "Amount is essential.";
        amountEnteredValid = false;
    }
    else if (amountEntered.value <= 0) {
        amountError.innerText = "Amount should be greater than 0";
        amountEnteredValid = false;
    }
    else if (!amountEntered.value.match(/^[0-9]+$/)) {
        amountError.innerText = "Amount should be in Number format only";
        amountEnteredValid = false;
    }
    if (amountEnteredValid == true) {
        console.log("Clicked");
        performDeposit();
    }
});

amountEntered.addEventListener("keyup", function () {
    if (amountEntered.value != "") {
        amountError.innerText = "";
    }
});

async function performDeposit() {
    let depositDetails = {
        accountId: currentAccountId,
        money: amountEntered.value
    };

    var options = {
        method: 'PUT',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(depositDetails)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions/deposit", options);

        if (response.status == 200){
            successMessage.style.display = "Block";
            errorMessage.style.display = "none";
            successMessage.innerText = "Amount Deposited successfully."
            clearData();
        }

    }
    catch (err) {
        errorMessage.style.display = "block";
        errorMessage.innerText = "Sorry for Inconvenience.Issue from our side please try again Later."
    }
}
function clearData(){
    amountEntered.value = " ";
}
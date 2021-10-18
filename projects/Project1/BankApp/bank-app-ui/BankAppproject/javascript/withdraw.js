const urlParams = new URLSearchParams(window.location.search);
const currentAccountId = urlParams.get('id');
console.log(currentAccountId);

let withdrawBtn = document.getElementById("withdrawButton");
let amountEntered = document.getElementById("amount");
let setAccountNumber = document.getElementById("setAccountNumber");

let amountError = document.getElementById("amountError");
let successMessage = document.getElementById("success");
let errorMessage = document.getElementById("error");

successMessage.style.display = "none";
errorMessage.style.display = "none";

setAccountNumber.innerText = "Account Number : " + currentAccountId;

withdrawBtn.addEventListener("click", function () {
    amountEnteredValid = true;
    if (amountEntered.value == "") {
        amountError.innerText = "Amount is essential";
        amountEnteredValid = false;
    }
    else if (amountEntered.value <= 0) {
        amountError.innerText = "Amount should be greater than 0";
        amountEnteredValid = false;
    }
    else if (!amountEntered.value.match(/^[0-9]+$/)) {
        amountError.innerText = "Amount should be in Number format only.";
        amountEnteredValid = false;
    }
    if (amountEnteredValid == true) {
        console.log("Clicked");
        performWithdraw();
    }
});

amountEntered.addEventListener("keyup", function () {
    if (amountEntered.value != "") {
        amountError.innerText = "";
    }
});
async function performWithdraw() {
    let withdrawDetails = {
        accountId: currentAccountId,
        money: amountEntered.value
    };

    var options = {
        method: 'PUT',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(withdrawDetails)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions", options);

        if (response.status == 200) {
            successMessage.style.display = "Block";
            errorMessage.style.display = "none";
            successMessage.innerText = "Withdrawal successfull."
            clearData();
        }
        else if (response.status == "400") {
            errorMessage.style.display = "block";
            successMessage.style.display = "none";
            errorMessage.innerText = "Insufficient balace,Action cannot be performed."
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
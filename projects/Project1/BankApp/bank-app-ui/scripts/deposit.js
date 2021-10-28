const urlParams = new URLSearchParams(window.location.search);
const currentAccountId = urlParams.get('id');


let amountEntered = document.getElementById("amount");

let depositBtn = document.getElementById("deposit");

depositBtn.addEventListener("click", function () {
    amountEnteredValid = true;
    if (amountEntered.value == "") {
        amountError.innerText = "Amount is manadatory";
        amountEnteredValid = false;
    }
    else if (amountEntered.value <= 0) {
        amountError.innerText = "Amount Cannot be less than 0";
        amountEnteredValid = false;
    }
    else if (!amountEntered.value.match(/^[0-9]+$/)) {
        amountError.innerText = "Amount should be in integers only.";
        amountEnteredValid = false;
    }
    if (amountEnteredValid == true) {
        console.log("Clicked");
        deposit();
    }
});

amountEntered.addEventListener("keyup", function () {
    if (amountEntered.value != "") {
        amountError.innerText = "";
    }
});






async function deposit() {
    let success = document.getElementById("success");
    let depositDetails = {
        accountNumber: currentAccountId,
        balance: amountEntered.value
    };

    var options = {
        method: 'PUT',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(depositDetails)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions/deposit", options);

        if (response.status == 200){
            clearData()
            success.innerText="Success";
        }

    }
    catch (err) {

    }
}


function clearData(){
    amountEntered.value = " ";
}
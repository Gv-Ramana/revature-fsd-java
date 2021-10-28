const urlParams = new URLSearchParams(window.location.search);
const currentAccNum = urlParams.get('id');

let withdrawBtn = document.getElementById("withdraw");
let amountEntered = document.getElementById("amount");


let amountError = document.getElementById("amountError");
let successMessage = document.getElementById("success");
let errorMessage = document.getElementById("error");




let fail = document.getElementById("error");


withdrawBtn.addEventListener("click", function () {
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
        withdraw();
    }
});

amountEntered.addEventListener("keyup", function () {
    if (amountEntered.value != "") {
        amountError.innerText = "";
    }
});


async function withdraw() {
    let success = document.getElementById("success");
    let withdrawDetails = {
        accountNumber: currentAccNum,
        balance: amountEntered.value
    };

    var options = {
        method: 'PUT',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(withdrawDetails)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions/withdraw", options);

        if (response.status == 200){
            success.innerText="Success";
            
            clearData();
        }
     

    }
    catch (err) {

    }
}

function clearData(){
    amountEntered.value = " ";
}
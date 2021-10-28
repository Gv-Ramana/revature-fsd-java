let account = document.getElementById("accno");
let bal = document.getElementById("ps");
let form = document.getElementById("frm");
let create = document.getElementById("sub");
let valid = true;





create.addEventListener("click", function () {
   



});


account.addEventListener("keyup", function () {
    let dis = document.getElementById("AccountError");
    console.log("wrkng");
    if (account.value != "" && account.value.length > 12) {
        console.log("notwrkng");
        dis.innerText = "Account Number Cannot Exceed 12 Characters";
        valid = false;

    }

    if (account.value != "" && account.value.length <= 12) {
        dis.innerText = "";
        valid = true;

    }




});







async function addAccount() {



    let account = {
        accountNumber: form.accno.value,
        balance: form.ps.value,
    };


    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(account)
    };

    
        try {
            let response = await fetch("http://localhost:8080/bank-app-rest/accounts", options);

        } catch (err) {
        }
    


}



create.addEventListener("click", function () {

    addAccount();
    alert("Account added successfully");
    document.location = "Customer.html";
  


});

create.addEventListener("click", function () {


    if (account.value == "" && bal.value == "") {
        let display = document.getElementById("dis");
        // display.innerText = "Enter all the Fields";
        valid = false;
    }   
   
    
    
    

    if (account.value == "" && bal.value == " ") {
        let dis = document.getElementById("AccountError");
        dis.innerText = "Enter the Account Number";
        valid = false;
    }









});


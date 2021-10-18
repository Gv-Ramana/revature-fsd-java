let signup = document.getElementById("submit");
let firstName = document.getElementById("firstName");
let lastName = document.getElementById("lastName");
let email = document.getElementById("email");
let password = document.getElementById("password");
let form = document.forms[0];
let valid = true;

let firstNameError = document.getElementById("firstNameError");
let lastNameError = document.getElementById("LastNameError");
let emailError = document.getElementById("emailError");
let passwordError = document.getElementById("passwordError");

let firstNameValidError;
let lastNameValidError;

success.style.display = "none";
error.style.display = "none";


 function  onClickingButton() {
    let firstNameValid = true;
    let lastNameValid = true;
    let emailValid = true;
    let passwordValid = true;
    if (firstName.value == "" ) {
        
        firstNameError.innerText = "First name is Essential";
        firstNameValid=false;
        return;
        
    }
   else if(!firstName.value.match( /^[A-Za-z]+$/)){
         
        firstNameError.innerText = "Numbers are not allowed here";
        firstNameValid=false;
        return;
    }
    if (lastName.value == "" ) {
        
        lastNameError.innerText = "Last name is essential";
        lastNameValid=false;
        return;
    }
    else if(!lastName.value.match( /^[A-Za-z]+$/)){
         
        lastNameError.innerText = "Numbers or Any other Special characters are not allowed here";
        lastNameValid=false;
        return;
    }
    if(email.value == ""){
        emailError.innerText = "Email is Essential";
        emailValid = false;
    }
    else if(!email.value.match(/[a-z0-9._%+-]+@[a-z0-9.9.-]+\.[a-z]{2,}$/)){
        emailError.innerText="Invalid mail format it should be like Ex:abc@mail.com";
        emailValid = false;
    }
    if(password.value == ""){
        passwordError.innerText = "Password should not be Empty";
        passwordValid = false;
    }
    console.log(valid);
    if(firstNameValid == true && lastNameValid == true && emailValid == true && passwordValid == true && firstNameValidError == true && lastNameValidError == true){
        console.log("Clicked");
        addCustomer(); 
    }
}

firstName.addEventListener("keyup", function () {
    //console.log(firstName.value);
   firstNameValidError = true;
    if (firstName.value != "" && firstName.value.length > 20) {
        firstNameValidError = false;
        firstNameError.innerText = "Maximun 20 characters allowed";
        return;
    }
    if (firstName.value != "" && firstName.value.length <= 20) {
        
       
        firstNameError.innerText = "";
        return;
    }
    // if (firstName.value != "") {
    //     let pattern = /^[A-Za-z]+$/;
    //     console.log(pattern);
    //     console.log(firstName.value.match(pattern));
    //     if (!firstName.value.match(pattern)) {
    //         firstNameError.innerText = "Numbers not allowed";
    //     }
    // }
   
});
lastName.addEventListener("keyup", function () {
    //console.log(firstName.value);
    lastNameValidError = true;
    if (lastName.value != "" && lastName.value.length > 20) {
        
        lastNameValidError = false;
        lastNameError.innerText = " Maximun 20 characters allowed";
        return;
    }
    if (lastName.value != "" && lastName.value.length <= 20) {
        
        lastNameError.innerText = "";
        return;
    }
});
email.addEventListener("keyup", function () {
    //console.log(firstName.value);
    // if (email.value != "" && email.value.length > 20) {
        
    //     emailError.innerText = "Last Name cannot exceed 20 characters";
    //     return;
    // }
    if (email.value != "" ) {
        emailError.innerText = "";
        return;
    }
    
});

password.addEventListener("keyup", function(){
    if (password.value != "" && password.value.length <= 20) {
        console.log("called");
        passwordError.innerText = "";
        return;
    }
});

async function addCustomer() {
    let customer = {
        firstName: form.firstname.value,
        lastName: form.lastname.value,
        email: form.email.value,
        passowrd: form.password.value
    };

    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(customer)
    };

    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
        clearFormData();
        success.style.display = "block";
        success.innerText = "Customer Added Successfully";
        window.location.href = "login.html"
    }
    catch (err) {
        error.style.display = "block";
        error.innerText = "Action Failed report to site administrator."
    }
}
function clearFormData() {
    form.firstname.value = "",
        form.lastname.value = "",
        form.email.value = "",
        form.password.value = ""
}
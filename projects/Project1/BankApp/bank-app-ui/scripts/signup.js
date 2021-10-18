let signup = document.getElementById("sub");
let firstName = document.getElementById("fn");
let lastName = document.getElementById("ln");
let email = document.getElementById("email");
let password = document.getElementById("ps");
let phoneno = document.getElementById("pn");
let form = document.getElementById("formm");
let valid = true;





signup.addEventListener("click", function () {
    console.log("clicked");
    if (firstName.value == "") {
        console.log("first name error " + valid);
        console.log(firstName.value);

        let firstNameError = document.getElementById("firstNameError");
        firstNameError.innerText = "First name is required ";
        valid = false;
        console.log("first name" + valid);
    }
   
    console.log(firstName.value);

    if(lastName.value == ""){
        let last = document.getElementById("lastNameError");
        last.innerText = "Last name is required";
        valid = false;
    }
    console.log("last name" + valid);
    if(email.value == ""){
        let mail = document.getElementById("emailValidation");
        mail.innerText = "email is required";
        valid = false;
    }
    console.log("email" + valid);
    if(password.value == ""){
        let pass = document.getElementById("passwordValidation");
        pass.innerText = "Password is required";
        valid = false;
    }
    console.log("phoneno" + valid);
    // if(phoneno.value == ""){
    //     let phno = document.getElementById("phonenoValidation");
    //     phno.innerText = "PhoneNumber is required";
    //     valid = false;
    // }

});
signup.addEventListener("click", function () {
    console.log("sahhhh");  
    addCustomer();
  });




    async function addCustomer() {
        let customer = {
            firstName: form.fn.value,
            lastName: form.ln.value,
            email: form.email.value,
            password: form.ps.value,
            phoneNumber: form.pn.value,

        };

        var options = {
            method: 'POST',
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(customer)
        };
        if(valid){
            console.log("machaa")
        try {
            let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
            //let data = await response.json();
            // console.log("after getting data");

            // console.log("after clearing form");


        } catch (err) {

        }
    }
    }

   


firstName.addEventListener("keyup", function () {
   
    if (firstName.value != "" && firstName.value.length > 20 ) {
        let firstNameError = document.getElementById("firstNameError");
        firstNameError.innerText = "First Name cannot exceed 20 characters";
        valid = false;
       
       
    }

    if (firstName.value != "" && firstName.value.length <= 20) {
        let firstNameError = document.getElementById("firstNameError");
        firstNameError.innerText = "";
        valid = true;
        
    }

    if (firstName.value != "") {
        let pattern = /^[A-Za-z]+$/;
        // console.log(firstName.value.match(pattern));
        if (!firstName.value.match(pattern)) {
            let firstNameError = document.getElementById("firstNameError");
            firstNameError.innerText = "Numbers not allowed";
            valid = false;
           
        }

    }
});

lastName.addEventListener("keyup", function () {
   
    if (lastName.value != "" && lastName.value.length > 20) {
        let lastNameError = document.getElementById("lastNameError");
        lastNameError.innerText = "Last Name cannot exceed 20 characters";
        valid = false;
    }

    if (lastName.value != "" && lastName.value.length <= 20) {
        let lastNameError = document.getElementById("lastNameError");
        lastNameError.innerText = "";
        valid = true;
    }

    if (lastName.value != "") {
        let pattern = /^[A-Za-z]+$/;
        // console.log(firstName.value.match(pattern));
        if (!lastName.value.match(pattern)) {
            let lastNameError = document.getElementById("lastNameError");
            lastNameError.innerText = "Numbers not allowed";
            valid = false;
        }
    }
});

email.addEventListener("keyup",function(){
    let emailError = document.getElementById("emailValidation");
  
    if(email.value != "" && email.value.length > 50){
      
        
        emailError.innerText = "email not allowed";
        valid = false;

    }
    if(email.value != "" && email.value.length <=50){
        emailError.innerText = ""
        valid = true;
    }

    if(email.value != ""){
        let mail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        if(!email.value.match(mail)){
            emailError.innerText = "invalid Pattern"
            valid = false;

        }
    }


});

password.addEventListener("keyup" ,function(){
    

   
    if(password.value != "" && password.value.length > 15){
        let pass = document.getElementById("passwordValidation");
        pass.innerText = "password can not exceed"
        valid = false;
        console.log(valid);
       
    }
    if(password.value != "" && password.value.length <= 15 && password.value.length >=5){
        let pass = document.getElementById("passwordValidation");
        pass.innerText = "";
        valid = true;
        console.log(valid);
    }
    if(password.value != ""){
        let pw =   /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
        if(!password.value.match(pw)){
            let pass = document.getElementById("passwordValidation");
            pass.innerText = "password can not exceed [7-15]character and use special character and numbers ";
            valid= false;
            console.log(valid);
        }
    }

});
// phoneno.addEventListener("keyup",function(){
//     let pn = document.getElementById("phonenoValidation");
   
//     if(phoneno.value != "" && phoneno.value.length > 10){
//         console.log("case 1");
//         pn.innerText = "InValid Phone Number";
//         valid = false;
//         console.log(valid);
//     }

//     if(phoneno.value != "" && phoneno.value.length <= 10){
//         console.log("case 2");
//         phoneno.innerText = "";
//         valid = true;
//         console.log(valid);

    // }
    // if(phoneno.value != ""){
    //     let pattn =/^[a-zA-Z0-9]+$/;
    //     if(!phoneno.value.match(pattn)){
    //         pn.innerText = "enter valid phone number";
    //         valid = false;
    //         console.log(valid);
    //     }
        
    // }
    

//  });


signup.addEventListener("click", function(){
    let err = document.getElementById("Error");
    if(valid == false){
   
    err.innerText = "Fill the required fields";
    }

    if(valid){
        let close = document.getElementById("close");
        close.innerText = "close";

        err.innerText = "Your Are Successfully Registered";
       
    }
   


});




































































































































// async function addCustomer() {
//     let customer = {
//         firstName: form.fn.value,
//         lastName: form.ln.value,
//         email: form.email.value,
//         password: form.ps.value,
//         phoneNumber:form.pn.value,

//     };

//     var options = {
//         method: 'POST',
//         headers: { "Content-Type": "application/json"},
//         body: JSON.stringify(customer)
//     };
//     try {   
//         let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
//         //let data = await response.json();
//         console.log("after getting data");

//         console.log("after clearing form");


//     } catch (err) {

//     }
// }




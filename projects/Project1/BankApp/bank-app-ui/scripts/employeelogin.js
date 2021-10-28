let email= document.getElementById("em");
let pass = document.getElementById("ps");
let form = document.getElementById("frm");
let login = document.getElementById("sub");



async function loginEmployee(){

try {
    let response = await fetch("http://localhost:8080/bank-app-rest/employees/"+email.value+"/"+pass.value);
     if(response.status == "401"){
        let display = document.getElementById("dis");
         display.innerText = "Login Failed";
     }
     if(response.status == 200){
        let display = document.getElementById("dis");
        display.innerText = "Login Success";
         document.location = "Employee.html";

        
     }
     if(response.status == "500"){
        let display = document.getElementById("dis");
        display.innerText = " Internal Error";
       
        // alert(" error");
         //display
     }
     

} catch (err) {

}
}
login.addEventListener("click",function(){
    console.log(form.email.value);
console.log(form.password.value);
    
loginEmployee();



});
login.addEventListener("click",function(){
    if(email.value == "" || pass.value == ""){
        let display = document.getElementById("dis");
        display.innerText = "Enter all the Fields";
    }
   
});
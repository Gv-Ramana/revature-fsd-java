let email= document.getElementById("em");
let pass = document.getElementById("ps");
let form = document.getElementById("frm");
let login = document.getElementById("sub");



async function loginEmployee(){

try {
    let response = await fetch("http://localhost:8080/bank-app-rest/employees/"+email.value+"/"+pass.value);
     if(response.status == "401"){
         alert(" login failed");
     }
     if(response.status == 200){
        alert(" login succesfull");
         document.location = "Employee.html";

        
     }
     if(response.status == "500"){
        alert(" error");
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
        alert("enter the required field");
    }
   
});
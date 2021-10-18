// let customers = [
//     {
//         firstName : "D",
//         lastName : "Sahith",
//         Email :" sahith@gmail.com",
//         PhoneNumber : 73467666678



//     },
//     {
//         firstName :"Drohini",
//         lastName :"Arshat",
//         Email :" drohinih@gmail.com",
//         PhoneNumber : 874783666678


//     },
//     {
//         firstName : "Hitman",
//         lastName :"Harsha",
//         Email :"hitmanh@gmail.com",
//         PhoneNumber : 7346236678

//     },
//     {
//         firstName : "Bablu",
//         lastName :"op",
//         Email :" oph@gmail.com",
//         PhoneNumber : 73757666678

//     },
//     {
//         firstName :"Xyz",
//         lastName : "Sunny",
//         Email :" xyzz@gmail.com",
//         PhoneNumber : 9877666678


//     }




// ];

// (async function () {
//   try {
//     let response = await fetch("http://localhost:8080/bank-app-rest/customers/");
//     let customer = await response.json();
//     let cust = "";
//     for (let customer of customers) {
//       cust += `<div class="col-sm-4 "> 
//     <div class="card text-white bg-dark mb-3">
//       <div class="card-body">
//         <h3> Name:  ${customer.firstName} ${customer.lastName}</h3>
//         <h5>Email:  ${customer.Email}</h5>
//         <div class="badge badge-success">Phone Number: ${customer.PhoneNumber}</div><br><br>
//         <div class="card-footer">
         
//           <a href="ecustomerAccounts.html" class="btn btn-primary">AccountList</a>
       
//         </div>
//       </div>
//     </div>
//   </div>`;
//     }
//     document.getElementById("detail").innerHTML = cust;
//   } catch (err) {

//   }
// })();



(async function () {
  try {
      let response = await fetch("http://localhost:8080/bank-app-rest/customers");
      let customer = await response.json();
      // for (let customer of customers) {
        cust += `<div class="col-sm-4 "> 
      <div class="card text-white bg-dark mb-3">
        <div class="card-body">
          <h3> Name:  ${customer.firstName} ${customer.lastName}</h3>
          <h5>Email:  ${customer.email}</h5>
          <div class="badge badge-success">Phone Number: ${customer.phoneNumber}</div><br><br>
          <div class="card-footer">
           
            <a href="ecustomerAccounts.html" class="btn btn-primary">AccountList</a>
         
          </div>
        </div>
      </div>
    </div>`;
      // }
      
  } catch (err) {

      }
})();

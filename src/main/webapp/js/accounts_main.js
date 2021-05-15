function getCustomers() {
    let customer = document.getElementById("customer");
    const CUSTOMER_LIST = "api/customers/list";

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            getAccountTypes();
            if (this.responseText) {
                 // handle response here
                 const customers = JSON.parse(this.responseText);

                 customers.forEach(item => {
                    let option = document.createElement("option");
                        option.text = item.name;
                        option.value = item.id;
                        customer.add(option);

                 });
             } else {
                 alert("Something went wrong retreiving the data");
             }
        }
    };
    xhttp.open("GET", CUSTOMER_LIST, true);
    xhttp.send();
}


function getAccountTypes() {
    let accounttype = document.getElementById("accounttype");
    const ACCOUNTTYPE_LIST = "api/accounts/type";

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            getLastRepayment();
            if (this.responseText) {
                 // handle response here
                 const accounttypes = JSON.parse(this.responseText);

                 accounttypes.forEach(item => {
                    let option = document.createElement("option");
                        option.text = item.name;
                        option.value = item.id;
                        accounttype.add(option);

                 });
             } else {
                 alert("Something went wrong retreiving the data");
             }
        }
    };
    xhttp.open("GET", ACCOUNTTYPE_LIST, true);
    xhttp.send();
}

function getLastRepayment() {
    const PLAN_NBR = "api/accounts/repayment/last";

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                    // handle response here
                const plan_nbr = JSON.parse(this.responseText);
            
                plan_nbr.forEach(item => {
                    console.log(item.id + 1);
                    document.getElementById("plan_nbr").value = item.id + 1;
                });
            } else {
                alert("Something went wrong retreiving the data");
            }
        }
    };
    xhttp.open("GET", PLAN_NBR, true);
    xhttp.send();
}

var form = document.getElementById('account');

// Adds a listener for the "submit" event.
form.addEventListener('submit', function (e) {

    // alert("Hello");
    let DTO = {
        "amount": document.getElementById('amount').value,
        "currency": document.getElementById('currency').value,
        "maturity_date": document.getElementById('maturity_date').value,
        "plan_nbr": document.getElementById('plan_nbr').value,
        "profit_amount": document.getElementById('profit_amount').value,
        "status": "Pending",
        "value_date": document.getElementById('value_date').value,
        "accountType": document.getElementById('accounttype').value
    };

    console.log(JSON.stringify(DTO));
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && (this.status == 200 || this.status == 204 )) {
            console.log(this.responseText);
            if (this.responseText) {
                alert("Repayment Plan has been created");
                addAccount(DTO);
            } else {
                alert("Invalid Form");
            }
        }
    };
    xhttp.open("PUT", "/customer_management/api/accounts/repayment", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(DTO));

    e.preventDefault();
});

function addAccount(DTO) { 
    let DTOACCOUNT = {
        "amount": DTO.amount,
        "created_by": "Zareef Soetodrono",
        "currency": DTO.currency,
        "yield": document.getElementById('yield').value,
        "repaymentID": DTO.plan_nbr,
        "status": "open",
        "date_closed": null,
        "customerID": document.getElementById('customer').value,
        "accountTypeID": DTO.accountType
    };

    console.log(JSON.stringify(DTOACCOUNT));
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && (this.status == 200 || this.status == 204 )) {
            console.log(this.responseText);
            if (this.responseText) {
                alert("Account has been created")
                window.location = "/customer_management/accounts.html";
            } else {
                alert("Invalid Form");
            }
        }
    };
    xhttp.open("PUT", "/customer_management/api/accounts/save", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(DTOACCOUNT));
}
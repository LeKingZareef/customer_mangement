function getAccountsList() {
    let accounts = document.getElementById("id");
    const ACCOUNT_URI = "api/accounts/list";

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                 // handle response here
                 const accountslist = JSON.parse(this.responseText);

                 accountslist.forEach(item => {
                    if (item.status == "open") { 
                        let option = document.createElement("option");
                        option.text = item.id;
                        option.value = item.id;
                        accounts.add(option);
                    }
                    

                 });
             } else {
                 alert("Something went wrong retreiving the data");
             }
        }
    };
    xhttp.open("GET", ACCOUNT_URI, true);
    xhttp.send();
}

var form = document.getElementById('approveaccount');

// Adds a listener for the "submit" event.
form.addEventListener('submit', function (e) {
    let DTO = {
        "id": document.getElementById('id').value,
        "status": document.getElementById('status').value
    };

    console.log(JSON.stringify(DTO));
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && (this.status == 200 || this.status == 204 )) {
            console.log(this.responseText);
            if (this.responseText) {
                alert("Loan has been approved");
                window.location = "/customer_management/accounts.html";
            } 
        }
    };
    xhttp.open("POST", "/customer_management/api/accounts/update", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(DTO));

    e.preventDefault();
});

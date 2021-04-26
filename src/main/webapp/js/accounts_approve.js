function getAccountsList() {
    const ACCOUNT_URI = "api/accounts/list";

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                 // handle response here
                const accounts = JSON.parse(this.responseText);
                

                accounts.forEach(item => {
                    console.log(item);
                    var date = new Date(item.date_open);
                    
                    if (item.status == "open") { 
                        const html =
                            `
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.currency}</td>
                                    <td>${item.accountType.id}</td>
                                    <td>${item.accountType.occupation}</td>
                                    <td>${item.amount}</td>
                                    <td>${item.yield}</td>
                                    <td>${item.customer.name}</td>
                                    <td>${date.getDate()+
                                        "/"+(date.getMonth()+1)+
                                        "/"+date.getFullYear()}</td>
                                    <td>
                                       <button class="btn btn-success" onclick="alert(${item.id})">Approve</button>
                                    </td>
                                </tr>
                            `;
                        document.getElementById("accountList").innerHTML += html;
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

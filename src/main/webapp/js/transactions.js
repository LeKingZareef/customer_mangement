function getTransferList() {
    const TRANSFER_URI = "api/accounts/paymentlist";

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText) {
                 // handle response here
                const transfers = JSON.parse(this.responseText);
                

                transfers.forEach(item => {
                    console.log(item);
                    const html =
                        `
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.amount}</td>
                                <td>${item.customer.name}</td>
                                <td>${item.repaymentPlan.plan_nbr}</td>
                                <td>${item.description}</td>
                                <td>${item.value_date}</td>
                            </tr>
                        `;
                    document.getElementById("transferList").innerHTML += html;
                });
            } else {
                alert("Something went wrong retreiving the data");
            }
        }
    };
    xhttp.open("GET", TRANSFER_URI, true);
    xhttp.send();
}

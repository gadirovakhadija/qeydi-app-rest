"use strict";

function getToken() {
    let token = null;
    if (document.cookie) {
        let cookies = document.cookie.split(";");
        for (let i = 0; i < cookies.length; i++) {
            let cookie = cookies[i].trim();
            if (cookie.startsWith("token=")) {
                token = cookie.substring("token=".length, cookie.length);
                console.log(token);
                break;
            }
        }
    }
    return token;
}

function getUsers() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4) {
            if (xhr.status === 200) {
                let response = JSON.parse(this.responseText);
                let list = response.name;
                console.log(list);
            }
        }
    };
    // var ema = document.getElementById("emailId").value;
    // var pass = document.getElementById("passwordId").value;
    // var user = {email: ema, password: pass};
    xhr.open("GET", "http://localhost:8089/QeydiRestApi_war_exploded/users", true);
    xhr.setRequestHeader('Authorization', getToken());

    xhr.send();

}
function displayData(data) {
    const tableBody = document.getElementById('table-body');
    data.forEach(item => {
        const row = document.createElement('tr');
        const nameCell = document.createElement('td');
        nameCell.textContent = item.name;
        const descriptionCell = document.createElement('td');
        descriptionCell.textContent = item.surname;
        row.appendChild(nameCell);+
        row.appendChild(descriptionCell);
        tableBody.appendChild(row);
    });
}



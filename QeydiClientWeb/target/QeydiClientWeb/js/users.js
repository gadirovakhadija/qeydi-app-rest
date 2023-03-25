function goCv(email) {
    window.location = 'cv?email=' + email;
}

function getUsers() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var response = JSON.parse(this.responseText);
            var list = response.obj;
            printUsers(list);
        }
    };
    // var ema = document.getElementById("emailId").value;
    // var pass = document.getElementById("passwordId").value;
    // var user = {email: ema, password: pass};
    xhttp.open("GET", "http://localhost:8089/QeydiRestApi_war_exploded/users", true);
    xhttp.send();
    // xhttp.send(JSON.stringify(user));
    // window.location = 'users.html';
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



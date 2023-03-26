
function getUsers() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange=function() {
        if (this.readyState == 4 && this.status == 200) {
            var response = JSON.parse(this.responseText);
            var list = response.obj;
            printUsers(list);
        }
    };
    xhttp.open("GET", "http://localhost:8089/QeydiRestApi_war_exploded/users", true);
    xhttp.setRequestHeader("Authorization", "Bearer " + token);
    xhttp.send();
}
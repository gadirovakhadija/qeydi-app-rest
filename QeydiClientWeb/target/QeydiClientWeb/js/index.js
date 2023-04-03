// function printUsers(arr){
//     var container = document.getElementById("container");
//     container.innerHTML = '';
//     for(var i=0;arr.length;i++) {
//         var obj = arr[i];
//
//         var deleteBtn  ='<button onclick="deleteUser('+obj.id+')" >DELETE</button>';
//         var str = obj.id + " " + obj.name + " " + obj.surname+ deleteBtn+"<br/>";
//         container.innerHTML += str;
//     }
// }

// function getUsers() {
//     var xhttp = new XMLHttpRequest();
//     xhttp.onreadystatechange=function() {
//         if (this.readyState == 4 && this.status == 200) {
//             var response = JSON.parse(this.responseText);
//             var list = response.obj;
//             printUsers(list);
//         }
//     };
//     xhttp.open("GET", "http://localhost:8089/QeydiRestApi_war_exploded/users", true);
//     // xhttp.setRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxNCIsImlhdCI6MTY4MDI1NjM4OSwiZXhwIjoxNjgwODYxMTg5fQ.BGNFjT3lG_FWCjP-TH3h0QEjdQCAFFihCLENkYFt76w");
//     xhttp.send();
// }

function getToken() {
    let token = null;
    if (document.cookie) {
        let cookies = document.cookie.split(";");
        for (let i = 0; i < cookies.length; i++) {
            let cookie = cookies[i].trim();
            if (cookie.startsWith("token=")) {
                token = cookie.substring("token=".length, cookie.length);
                console.log("Menim token"+token);
                break;
            }
        }
    }
    return token;
}

function getUsers() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8089/QeydiRestApi_war_exploded/users', true);
 xhr.setRequestHeader('Authorization', getToken());
    xhr.send();

    xhr.onload = function () {
        if (xhr.status === 200) {
            // Process the response data
            var responseData = JSON.parse(xhr.responseText);
            console.log(responseData);
            document.getElementById("result").innerHTML = responseData;
        } else {
            // Handle errors
            console.error('Error:', xhr.statusText);
        }
    };
}

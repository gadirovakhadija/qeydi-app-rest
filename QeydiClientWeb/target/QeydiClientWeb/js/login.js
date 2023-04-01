const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});

function passwordVisibility() {
    var x = document.getElementById("passwordId");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function getSignIn() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange=function() {
        if (this.readyState == 4 && this.status == 200) {
            var response = JSON.parse(this.responseText);
            var list = response.obj;
            printUsers(list);
        }
    };
    var ema = document.getElementById("emailId").value;
    var pass = document.getElementById("passwordId").value;
    var user = { email: ema, password: pass};
    xhttp.open("POST", "http://localhost:8089/QeydiRestApi_war_exploded/login/sign-in", true);
    xhttp.send(JSON.stringify(user));
    window.location ='users.html';

}

let token;

// Login form submit handler
function submitLoginForm() {
    let email = document.getElementById("emailId").value;
    let password = document.getElementById("passwordId").value;

    // Send login request to server
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8089/QeydiRestApi_war_exploded/login/sign-in",true);
    // xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let data = JSON.stringify({email: email, password: password});
    xhr.send(data);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var response = JSON.parse(xhr.responseText);
            token = response.token;
            console.log("Token: " + token);
        }
    };

}
function signIn() {
    let email = document.getElementById("emailId").value;
    let password = document.getElementById("passwordId").value;

    console.log(email);
    let data = {
        email: email,
        password: password
    };
    console.log(data);

    fetch("http://localhost:8089/QeydiRestApi_war_exploded/login/sign-in", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(response => response.text())
        .then(token => {
            console.log("Token: " + token);
        })
        .catch(error => {
            console.error(error);
        });
}

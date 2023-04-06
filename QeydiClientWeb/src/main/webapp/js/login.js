"use strict";
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
    let x = document.getElementById("passwordId");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}


function signIn() {
    let email = document.getElementById("emailId").value;
    let password = document.getElementById("passwordId").value;
    let xhr = new XMLHttpRequest();

    xhr.open("POST", "http://localhost:8089/QeydiRestApi_war_exploded/login/sign-in");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            if (xhr.status === 200) {
                let token = xhr.responseText;
                console.log("Token: " + token);
                document.cookie = "token=" + token;
                window.location.href = "users.html";
            } else {
                window.location.href ="login.html";
                console.error(xhr.statusText);
                // Display an error message to the user
                alert("Login failed. Please try again.");
            }
        }
    };
    let data = {
        email: email,
        password: password
    };
    xhr.send(JSON.stringify(data));
}

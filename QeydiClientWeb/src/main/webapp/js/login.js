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
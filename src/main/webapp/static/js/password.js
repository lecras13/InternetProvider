var myInput = document.getElementById("psw");
var myInputR = document.getElementById("pswr");
var validness = document.getElementById("validness");

myInputR.onfocus = function () {
    document.getElementById("message").style.display = "block";
}


myInputR.onblur = function () {
    document.getElementById("message").style.display = "none";
}


myInputR.onkeyup = function () {
    if (myInput.value == myInputR.value) {
        validness.classList.remove("invalid");
        validness.classList.add("valid");
    } else {
        validness.classList.remove("valid");
        validness.classList.add("invalid");
    }
}

var myInput = document.getElementById("amount");
var validness = document.getElementById("validness");

myInput.onfocus = function () {
    document.getElementById("message").style.display = "block";
}


myInput.onblur = function () {
    document.getElementById("message").style.display = "none";
}

myInput.onkeyup = function () {
    var regexDouble = /^[0-9]+(\.[0-9]{1,2})?$/;
    if ((myInput.value.match(regexDouble)) && (myInput.value < 501)) {
        validness.classList.remove("invalid");
        validness.classList.add("valid");
    } else {
        validness.classList.remove("valid");
        validness.classList.add("invalid");
    }
}
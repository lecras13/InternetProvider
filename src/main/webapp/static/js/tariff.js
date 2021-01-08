var myInputName = document.getElementById("tariff");
var description = document.getElementById("description");
var price = document.getElementById("price");
var letter = document.getElementById("tariffIn");
var priceIn = document.getElementById("priceIn");
var descriptionIn = document.getElementById("descriptionIn");


myInputName.onkeyup = function () {
    if ((myInputName.value.length > 0) & (myInputName.value.length < 20)) {
        letter.classList.remove("invalid");
        letter.classList.add("valid");
    } else {
        letter.classList.remove("valid");
        letter.classList.add("invalid");
    }
}

description.onkeyup = function () {
    if ((description.value.length > 0) & (description.value.length < 255)) {
        descriptionIn.classList.remove("invalid");
        descriptionIn.classList.add("valid");
    } else {
        descriptionIn.classList.remove("valid");
        descriptionIn.classList.add("invalid");
    }
}

price.onkeyup = function () {
    if ((price.value > 0) & (price.value < 51)) {
        priceIn.classList.remove("invalid");
        priceIn.classList.add("valid");
    } else {
        priceIn.classList.remove("valid");
        priceIn.classList.add("invalid");
    }
}
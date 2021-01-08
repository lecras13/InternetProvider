var login = document.getElementById("login");
var firstName = document.getElementById("firstName");
var lastName = document.getElementById("lastName");
var discount = document.getElementById("discount");

var loginMes = document.getElementById("loginMes");
var firstNameMes = document.getElementById("firstNameMes");
var lastNameMes = document.getElementById("lastNameMes");
var discountMes = document.getElementById("discountMes");


login.onkeyup = function () {
    if ((login.value.length > 0) && (login.value.length < 25)) {
        loginMes.classList.remove("invalid");
        loginMes.classList.add("valid");
    } else {
        loginMes.classList.remove("valid");
        loginMes.classList.add("invalid");
    }
}

firstName.onkeyup = function () {
    if ((firstName.value.length > 0) && (login.value.length < 25)) {
        firstNameMes.classList.remove("invalid");
        firstNameMes.classList.add("valid");
    } else {
        firstNameMes.classList.remove("valid");
        firstNameMes.classList.add("invalid");
    }
}

lastName.onkeyup = function () {
    if ((lastName.value.length > 0) && (lastName.value.length < 25)) {
        lastNameMes.classList.remove("invalid");
        lastNameMes.classList.add("valid");
    } else {
        lastNameMes.classList.remove("valid");
        lastNameMes.classList.add("invalid");
    }
}

discount.onkeyup = function () {
    if ((discount.value > 0) && (discount.value < 25)) {
        discountMes.classList.remove("invalid");
        discountMes.classList.add("valid");
    } else {
        discountMes.classList.remove("valid");
        discountMes.classList.add("invalid");
    }
}

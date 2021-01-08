var promotionName = document.getElementById("promotionName");
var startDate = document.getElementById("startDate");
var endDate = document.getElementById("endDate");
var description = document.getElementById("description");
var newPrice = document.getElementById("newPrice");

var promotionNameMes = document.getElementById("promotionNameMes");
var startDateMes = document.getElementById("startDateMes");
var endDateMes = document.getElementById("endDateMes");
var descriptionMes = document.getElementById("descriptionMes");
var newPriceMes = document.getElementById("newPriceMes");

var regexDouble = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/;

promotionName.onkeyup = function () {
    if ((promotionName.value.length > 0) & (promotionName.value.length < 50)) {
        promotionNameMes.classList.remove("invalid");
        promotionNameMes.classList.add("valid");
    } else {
        promotionNameMes.classList.remove("valid");
        promotionNameMes.classList.add("invalid");
    }
}

startDate.onkeyup = function () {
    if ((startDate.value.match(regexDouble))) {
        startDateMes.classList.remove("invalid");
        startDateMes.classList.add("valid");
    } else {
        startDateMes.classList.remove("valid");
        startDateMes.classList.add("invalid");
    }
}

endDate.onkeyup = function () {
    if ((endDate.value.match(regexDouble))) {
        endDateMes.classList.remove("invalid");
        endDateMes.classList.add("valid");
    } else {
        endDateMes.classList.remove("valid");
        endDateMes.classList.add("invalid");
    }
}

description.onkeyup = function () {
    if ((description.value.length > 0) & (description.value.length < 255)) {
        descriptionMes.classList.remove("invalid");
        descriptionMes.classList.add("valid");
    } else {
        descriptionMes.classList.remove("valid");
        descriptionMes.classList.add("invalid");
    }
}

newPrice.onkeyup = function () {
    if ((newPrice.value > 0) & (newPrice.value < 51)) {
        newPriceMes.classList.remove("invalid");
        newPriceMes.classList.add("valid");
    } else {
        newPriceMes.classList.remove("valid");
        newPriceMes.classList.add("invalid");
    }
}
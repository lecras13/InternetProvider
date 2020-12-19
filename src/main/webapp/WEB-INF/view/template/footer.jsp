<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<div class="footer">
    <h2><fmt:message key="label.nameCompany"/></h2>
    <h2><fmt:message key="footer.slogan"/></h2>
    <p><fmt:message key="footer.ques.sugg"/>
        <br>
        <fmt:message key="footer.email"/>
        <br>
        <fmt:message key="footer.tel"/>
        <br>
        <fmt:message key="footer.owner"/>
    </p>
</div>
</body>
</html>

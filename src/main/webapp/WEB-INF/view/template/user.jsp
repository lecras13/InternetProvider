<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>


<html lang="${sessionScope.lang}">
<head>
    <title>InternetProvider</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/index.css">
</head>
<body>



<div>
    <ul>
        <li><a href="/controller?command=users" class="mainmenu1" method=POST>Моя страница</a></li>

        <li><a href="Sheets/page2.html" class="mainmenu1">Пополнить баланс</a></li>

        <li><a href="Sheets/page2.html" class="mainmenu1">Изменить тарифный план</a></li>

        <li><a href="Sheets/page3.html" class="mainmenu1">Изменить личные параметры</a></li>

    </ul>
</div>
</body>
</html>
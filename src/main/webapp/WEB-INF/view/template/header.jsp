<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<body>
<header>
    <div class="header-panel">
        <div class="site-name">
            <h1><fmt:message key="label.nameCompany"/></h1>
        </div>

        <div class="tool-bar">
            <ul>
                <li><a href="${pageContext.request.contextPath}/index.jsp"><fmt:message key="toolbar.main"/></a></li>
                <li><a href="/controller?command=tariffs" method=POST><fmt:message key="toolbar.tariff"/></a></li>
                <li><a href="contact.php"><fmt:message key="toolbar.promotions"/></a></li>
                <li><a href="${pageContext.request.contextPath}/registration.jsp"><fmt:message key="toolbar.connect"/></a></li>
            </ul>
        </div>

        <div class="language">


            <li>
                <form method=POST
                      action="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}">
                    <input type="hidden" name="sessionLocale" value="en"/>
                    <button class="button-lang" type="submit"><fmt:message key="label.lang.en"/></button>
                </form>
            </li>
            <li>
                <form method=POST
                      action="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}">
                    <input type="hidden" name="sessionLocale" value="ru"/>
                    <button class="button-lang" type="submit"><fmt:message key="label.lang.ru"/></button>
                </form>
            </li>
            <li>
                <form method=POST
                      action="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}">
                    <input type="hidden" name="sessionLocale" value="by"/>
                    <button class="button-lang" type="submit"><fmt:message key="label.lang.by"/></button>
                </form>
            </li>

        </div>


        <div class="login">
            <form action="/controller?command=login" method=POST>
                <br>
                <br>
                <input type="text" name="login" placeholder="<fmt:message key="login.form.log" />">
                <br>
                <br>
                <input type="password" name="password" placeholder="<fmt:message key="login.form.pass" />">
                <br>
                <br>
                <input type="submit" value="<fmt:message key="login.form.button" />">
            </form>
            <p class="errorLogin"> ${errorMessage}</p>
        </div>
    </div>
</header>
</body>
</html>

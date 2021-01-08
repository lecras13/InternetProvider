<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>


<html lang="${sessionScope.lang}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>InternetProvider</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/index.css">
</head>
<body>

<jsp:include page="../template/header.jsp"/>
<div id="content">
    <nav>
        <c:if test="${sessionScope.userRole eq 'ADMIN'}">
            <div>
                <jsp:include page="../template/admin.jsp"/>
            </div>
        </c:if>
        <c:if test="${sessionScope.userRole eq 'USER'}">
            <div>
                <jsp:include page="../template/user.jsp"/>
            </div>
        </c:if>
    </nav>


    <div class="right">
        <c:if test="${sessionScope.userRole != null}">
            <hr/>
            <H2>Hello, ${sessionScope.login}!</H2>
            <a><ctg:info-time/></a>
            <a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message
                    key="logout.form.button"/></a>
            <hr/>
        </c:if>

        <div class="info">

            <form action="${pageContext.request.contextPath}/controller?command=tariffs-save" method=POST>
                <input type="hidden" name="id" value="${tariff_id}"/>
                <table class="reg_form">
                    <tr>
                        <td><fmt:message key="tariff.name"/></td>
                        <td><input type="text" id="tariff" name="tariff" value="${tariff}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="tariff.price"/></td>
                        <td><input type="text" id="price" name="price" value="${price}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="tariff.description"/></td>
                        <td><textarea id="description" name="description">${description}</textarea>
                    </tr>
                    <tr>
                    </tr>
                    <tr>
                        <td>
                            <h1 align="center"> ${errorMessageData}</h1>
                            <p id="tariffIn" class="invalid"><fmt:message key="tariff.name"/><b> <fmt:message key="valid"/></b></p>
                            <p id="priceIn" class="invalid"><fmt:message key="tariff.price"/><b> <fmt:message key="valid"/></b></p>
                            <p id="descriptionIn" class="invalid"><fmt:message key="tariff.description"/><b> <fmt:message key="valid"/></b>
                            </p>
                        </td>
                        <td>
                            <input type="submit" value="<fmt:message key="button.add"/>">
                        </td>
                    </tr>
                </table>
            </form>

        </div>
    </div>
</div>


<footer>
    <jsp:include page="../template/footer.jsp"/>
</footer>
<script src="<c:url value="/static/js/tariff.js"/>"></script>
</body>
</html>

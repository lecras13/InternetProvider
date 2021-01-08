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

            <form name="password_form" action="${pageContext.request.contextPath}/controller?command=user-password-save"
                  method=POST>
                <input type="hidden" name="id" value="${id}"/>
                <table class="reg_form">
                    <tr>
                        <td><fmt:message key="registr.pass"/></td>
                        <td><input type="password" id="psw" name="password"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="registr.pass.confirm"/></td>
                        <td><input type="password" id="pswr" name="password_repeat"/></td>
                    </tr>
                    <tr>
                        <td><p> ${errorMessagePassword}</p></td>
                        <td></td>
                    </tr>
                    <td>
                        <div id="message">
                            <p id="validness" class="invalid"><b> <fmt:message key="valid"/></b></p>
                        </div>
                    </td>
                    <td>
                        <input type="submit" value="<fmt:message key="button.edit.password"/>">
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
<script src="<c:url value="/static/js/password.js"/>"></script>
</body>
</html>



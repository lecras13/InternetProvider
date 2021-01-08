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
            <form action="${pageContext.request.contextPath}/controller?command=user-save" method=POST>
                <input type="hidden" name="id" value="${id}"/>
                <table class="reg_form">
                    <tr>
                        <td><fmt:message key="login"/></td>
                        <td><input type="text" id="login" name="login" value="${login}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="first.name"/></td>
                        <td><input type="text" id="firstName" name="first_name" value="${first_name}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="last.name"/></td>
                        <td><input type="text" id="lastName" name="last_name" value="${last_name}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="tariff.id"/></td>

                        <td>
                            <select name="select_tariff">
                                <c:forEach items="${tariffs}" var="tariff">
                                    <option value="${tariff.id}"> ${tariff.tariffName} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                    <c:if test="${sessionScope.userRole eq 'ADMIN'}">
                        <tr>
                            <td><fmt:message key="discount"/></td>
                            <td>
                                <input type="text" id="discount" name="discount" value="<c:out value="${discount}"/>"/>
                            </td>
                        </tr>

                        <tr>
                            <td><fmt:message key="status"/></td>
                            <td>
                                <input type="radio" name="status_block" value="TRUE"><fmt:message key="status.blocked"/>
                                <input type="radio" name="status_block" value="FALSE" checked><fmt:message
                                    key="status.unblocked"/><br>
                            </td>
                        </tr>
                    </c:if>

                    <tr>
                        <td>
                            <h1 align="center"> ${errorMessageData}</h1>
                            <p id="loginMes" class="invalid"><fmt:message key="login"/><b> <fmt:message
                                    key="valid"/></b>
                            </p>
                            <p id="firstNameMes" class="invalid"><fmt:message key="first.name"/><b> <fmt:message
                                    key="valid"/></b></p>
                            <p id="lastNameMes" class="invalid"><fmt:message key="last.name"/><b> <fmt:message
                                    key="valid"/></b></p>
                            <c:if test="${sessionScope.userRole eq 'ADMIN'}">
                                <p id="discountMes" class="invalid"><fmt:message key="discount"/><b> <fmt:message
                                        key="valid"/></b></p>
                            </c:if>
                        </td>
                        <td>
                            <input type="hidden" name="discount" value="<c:out value="${discount}"/>"/>
                            <input type="hidden" name="tariff_id" value="<c:out value="${tariff_id}"/>"/>
                            <input type="submit" value="<fmt:message key="button.edit"/>"/>
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
<script src="<c:url value="/static/js/user.js"/>"></script>
</body>
</html>

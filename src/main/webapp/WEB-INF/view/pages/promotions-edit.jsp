<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>
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
            <a href="/${pageContext.request.contextPath}/controller?command=logout"><fmt:message
                    key="logout.form.button"/></a>
            <hr/>
        </c:if>

        <div class="info">
            <form action="${pageContext.request.contextPath}/controller?command=promotions-save" method=POST>
                <input type="hidden" name="id" value="${id}"/>
                <table class="reg_form">
                    <tr>
                        <td><fmt:message key="promotion.name"/></td>
                        <td><input type="text" id="promotionName" name="promotion-name" value="${promotion_name}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="promotion.start"/></td>
                        <td><input type="text" id="startDate" name="start-date" value="${start_date}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="promotion.end"/></td>
                        <td><input type="text" id="endDate" name="end-date" value="${end_date}"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="promotion.description"/></td>
                        <td><textarea id="description" name="description">${description}</textarea></td>
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
                    <tr>
                        <td><fmt:message key="promotion.new.price"/></td>
                        <td><input type="text" id="newPrice" name="new-price" value="${new_price}"></td>
                    </tr>
                    <tr>
                    </tr>
                    <tr>
                        <td>
                            <h1 align="center"> ${errorMessageData}</h1>
                            <p id="promotionNameMes" class="invalid"><fmt:message key="promotion.name"/><b> <fmt:message key="valid"/></b>
                            </p>
                            <p id="startDateMes" class="invalid"><fmt:message key="promotion.start"/><b> <fmt:message key="valid"/></b></p>
                            <p id="endDateMes" class="invalid"><fmt:message key="promotion.end"/><b> <fmt:message key="valid"/></b></p>
                            <p id="descriptionMes" class="invalid"><fmt:message key="promotion.description"/><b> <fmt:message key="valid"/></b></p>
                            <p id="newPriceMes" class="invalid"><fmt:message key="promotion.new.price"/><b> <fmt:message key="valid"/></b>
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
<script src="<c:url value="/static/js/promotion.js"/>"></script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Main</title>
</head>
<body>
<h1>USER-BASIS PAGE</h1>
<a href="?sessionLocale=en"><button><fmt:message key="label.lang.en" /></button></a><span>  </span>
<a href="?sessionLocale=ua"><button><fmt:message key="label.lang.ua" /></button></a>

<%--<h1>Payments.ua</h1>--%>
<%--<br>--%>
<%--<h4>--%>
<%--<fmt:message key="label.select"/>--%>
<%--</h4>--%>
<%--<form action="${pageContext.request.contextPath}/login">--%>
<%--<button>--%>
<%--<fmt:message key="label.login"/>--%>
<%--</button>--%>
<%--</form>--%>
<%--<br>--%>
<%--<form action="${pageContext.request.contextPath}/registration">--%>
<%--<button>--%>
<%--<fmt:message key="label.register"/>--%>
<%--</button>--%>
<%--</form>--%>

<h1><fmt:message key="label.select"/></h1>

<form action="${pageContext.request.contextPath}/app/main.jsp" method="get">
    <fieldset>
        <legend><h3>Розрахунок вартості перевезення</h3></legend>
        <p><label>Місто завантаження: </label>
            <select>
                <option>Львів</option>
                <option>Вінниця</option>
                <option>Дніпро</option>
                <option>Київ</option>
                <option>Харків</option>
            </select>
            <label>Місто розвантаження:</label>
            <select>
                <option>Львів</option>
                <option>Вінниця</option>
                <option>Дніпро</option>
                <option>Київ</option>
                <option>Харків</option>
            </select>
            <label>Відстань:</label><input type="number"> км.</p>
        <p><label>Дата завантаження: </label><input type="date">
            <label>Дата розвантаження:</label><input type="date"></p>
        <p><label>Вага:</label><input type="number"> кг.
            <label>Категорія товару:</label><input type="number"></p>
        <p><input type="submit" value="РОЗРАХУВАТИ"></p>
    </fieldset>
</form>

</body>

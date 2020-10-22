<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Front</title>
</head>


<body style="background-color: aquamarine; margin: 10px; text-align: center">

<div style="text-align: right"><a href="?sessionLocale=en"><button style="background-color: blue">
    <fmt:message key="label.lang.en" /></button></a><span>  </span>
<a href="?sessionLocale=ua"><button style="background-color: yellow; ">
    <fmt:message key="label.lang.ua" /></button></a>
    <a href="${pageContext.request.contextPath}/index.jsp"><button><fmt:message key="label.logout"/></button></a>
</div>

<h1><fmt:message key="label.delivery"/></h1>

<form action="${pageContext.request.contextPath}/index.jsp">
    <fieldset>
        <legend><h3><fmt:message key="label.calculation"/> </h3></legend>
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
        <p><button>
            <fmt:message key="label.calculate"/>
        </button></p>
    </fieldset>
</form>

<fieldset>
    <legend><h3><fmt:message key="label.selectloginregistr"/></h3></legend>
    <button>
        <a href="login.jsp"><fmt:message key="label.login"/></a>
    </button>
    <button>
        <a href="registration.jsp"><fmt:message key="label.register"/></a>
    </button>
</fieldset>
</body>
</html>

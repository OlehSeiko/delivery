<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>

<body style="background-color: aqua; text-align: center; margin: 10px">
<div style="text-align: right"><a href="?sessionLocale=en"><button style="background-color: blue">
    <fmt:message key="label.lang.en" /></button></a><span>  </span>
    <a href="?sessionLocale=ua"><button style="background-color: yellow; "><fmt:message key="label.lang.ua" /></button></a>
    <a href="${pageContext.request.contextPath}/login.jsp">
        <button>
            <fmt:message key="label.logout"/>
        </button></a>
</div>

<h1><fmt:message key="label.delivery"/></h1>

<fmt:message key="label.user" />: <br>
${user.firstName} ${user.lastName}<br>
${user.username}


<form action="${pageContext.request.contextPath}/result">
    <fieldset>
        <legend><h3><fmt:message key="label.calculation"/> </h3></legend>
        <p><label><fmt:message key="label.downcity" />: </label>
            <select name="downloadCity">
                <option><fmt:message key="label.citylviv" /></option>
                <option><fmt:message key="label.cityvinnytsia" /></option>
                <option><fmt:message key="label.citydnipro" /></option>
                <option><fmt:message key="label.citykiev" /></option>
                <option><fmt:message key="label.citykharkiv" /></option>
            </select>
            <label><fmt:message key="label.unloadcity" />:</label>
            <select name="cityOfUnloading">
                <option><fmt:message key="label.citylviv" /></option>
                <option><fmt:message key="label.cityvinnytsia" /></option>
                <option><fmt:message key="label.citydnipro" /></option>
                <option><fmt:message key="label.citykiev" /></option>
                <option><fmt:message key="label.citykharkiv" /></option>
            </select>
            <label><fmt:message key="label.distance" />:</label><input type="number" name="distance"> </p>
        <p><label><fmt:message key="label.uploaddate" />: </label><input type="date" name="date">
            <label><fmt:message key="label.dateofunloading" />:</label><input type="date" name="date"></p>
        <p><label><fmt:message key="label.weight" />:</label><input type="number" name="weight">
            <label><fmt:message key="label.category" />:</label>
            <select name="category">
                <option> 1 </option>
                <option> 2 </option>
            </select></p>
        <button><fmt:message key="label.calculate"/></button>
        <button><fmt:message key="label.application"/></button>
    </fieldset>
</form>


</body>

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
<body style="background-color: aqua; text-align: center; margin: 10px">
<div style="text-align: right"><a href="?sessionLocale=en"><button style="background-color: blue">
    <fmt:message key="label.lang.en" /></button></a><span>  </span>
    <a href="?sessionLocale=ua"><button style="background-color: yellow; "><fmt:message key="label.lang.ua" /></button></a>
    <a href="${pageContext.request.contextPath}/login.jsp">
        <button>
            <fmt:message key="label.login"/>
        </button></a>
</div>

<fieldset>
    <legend><h1><fmt:message key="label.registration"/></h1></legend>

<form action="${pageContext.request.contextPath}/registration" method="post">
    <p><label><fmt:message key="label.name"/> :   </label><input type="text" name="firstName"></p>
    <p><label><fmt:message key="label.surname"/>: </label><input type="text" name="lastName"></p>
    <p><label><fmt:message key="label.email"/>:   </label><input name="username"></p>
    <p><label><fmt:message key="label.password"/>:</label><input type="password" name="password"></p>
    <button>
        <fmt:message key="label.register"/>
    </button>


</form>

</fieldset>

</body>
</html>

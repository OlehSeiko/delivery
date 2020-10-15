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
<a href="?sessionLocale=en"><button><fmt:message key="label.lang.en" /></button></a><span>  </span>
<a href="?sessionLocale=ua"><button><fmt:message key="label.lang.ua" /></button></a>
<h1>REGISTRATION</h1>

<form action="${pageContext.request.contextPath}/registration" method="post">
    <p><label>Name:    </label><input type="text" name="firstName"></p>
    <p><label>Surname: </label><input type="text" name="lastName"></p>
    <p><label>Email:   </label><input name="username"></p>
    <p><label>Password:</label><input type="password" name="password"></p>
    <p><input type="submit" value="Register"></p>

</form>
<a href="${pageContext.request.contextPath}/index.jsp">
    <button>
        <fmt:message key="label.logout"/>
    </button></a>

</body>
</html>

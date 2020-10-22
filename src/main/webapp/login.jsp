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
    <title>Login</title>


</head>
    <body style="background-color: aquamarine; text-align: center; margin: 10px">

    <div style="text-align: right"><a href="?sessionLocale=en"><button style="background-color: blue">
        <fmt:message key="label.lang.en" /></button></a><span>  </span>
        <a href="?sessionLocale=ua"><button style="background-color: yellow; ">
            <fmt:message key="label.lang.ua" /></button></a>
            <a href="${pageContext.request.contextPath}/registration.jsp"><button><fmt:message key="label.registration"/></button></a>
    </div>
    <fieldset><legend><h1><fmt:message key="label.select"/></h1></legend>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <%--<input type="radio" name="role" value="ROLE_ADMIN"/>admin--%>
        <%--<input type="radio" name="role" value="ROLE_USER" checked/>user--%>
        <br><br>
        <fmt:message key="label.username"/> : <input name="username" min=1/>
        <br><br>
        <fmt:message key="label.password"/> : <input name="password" type="password" min=1/>
        <br><br>
        <button>
            <fmt:message key="label.login"/>
        </button>


    </form>

    </fieldset>

    </body>
</html>

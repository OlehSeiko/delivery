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
    <h1><fmt:message key="label.select"/></h1>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <%--<input type="radio" name="role" value="ROLE_ADMIN"/>admin--%>
        <%--<input type="radio" name="role" value="ROLE_USER" checked/>user--%>
        <br><br>
        <fmt:message key="label.username"/> : <input name="username"/>
        <br><br>
        <fmt:message key="label.password"/> : <input name="password" type="password" min=1/>
        <br><br>
        <button>
            <fmt:message key="label.login"/>
        </button>
    </form>


    <a href="${pageContext.request.contextPath}/index.jsp">
        <button>
            <fmt:message key="label.logout"/>
        </button></a>

    </body>
</html>

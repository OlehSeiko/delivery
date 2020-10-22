<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
    <head>
        <title>Delivery</title>
    </head>

        <body>
        <h4>Тема ТЗ: Доставка вантажу</h4>

        <p> 1) Існують ролі: Користувач, Авторизований користувач, Менеджер.<br>
            2) На сайті компанії доставки вантажів розміщено інформацію про напрямки доставки,<br>
            а також про тарифи (тарифи залежать від відстані, ваги та габаритів вантажу).<br>
            3) Незареєстрований користувач може переглядати інформацію на сайті,<br>
            відсортувавши чи відфільтрувавши її за напрямами доставки,а також має можливість<br>
            самостійно розрахувати вартість послуг.<br>
            4) Авторизований користувач може створити заявку на доставку вантажу і вказати адресу доставки.<br>
            5) Заявка містить інформацію про тип багажу, вагу, об’єм і дату отримання.<br>
            6) Менеджер опрацьовує заявки і формує квитанції до сплати, а також може отримувати звіти<br>
            щодо доставок (по днях та напрямках).<br>
            7) Авторизований користувач в своєму кабінеті може сплатити квитанцію на доставку.</p>

        <a href="front.jsp">Розпочати розгляд технічного завдання</a>
        </body>
</html>

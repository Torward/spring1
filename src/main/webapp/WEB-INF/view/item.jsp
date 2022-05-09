<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artemkropotov
  Date: 27.03.2022
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Продукт</title>
</head>
<body>
<h2> Название продукта: ${item.title}</h2>
<h2> Стоимость продукта: ${item.cost}</h2>

<%--<c:url var="deleteUrl" value="/message/delete">--%>
<%--    <c:param name="id" value="${message.id}"/>--%>
<%--</c:url>--%>

<%--<a href="${deleteUrl}">DELETE</a>--%>

<%--<br>--%>

<c:url var="editUrl" value="/product/edit">
    <c:param name="id" value="${item.id}"/>
</c:url>

<a href="${editUrl}">EDIT</a>
</body>
</html>

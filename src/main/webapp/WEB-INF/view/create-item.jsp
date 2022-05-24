<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  1. Разобраться с примером проекта на Spring MVC;
2. Создать класс Товар (Product), с полями id, title, cost;
3. Товары необходимо хранить в репозитории (класс, в котором в виде List<Product> хранятся товары). Репозиторий должен уметь выдавать список всех товаров и товар по id;
4. Сделать форму для добавления товара в репозиторий и логику работы этой формы;
5. Сделать страницу, на которой отображаются все товары из репозитория.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать новый продукт</title>
</head>
<body>
<form:form action="create" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
   Название: <form:input path="title" />
    <br>
   Стоимость: <form:input path="cost"/>
    <br>
    Дата изготовления: <form:input path="date"/>
    <br>
    Код изготовителя: <form:input path="manufacturer" value="${product.manufacturer.id.longValue()}"/>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>

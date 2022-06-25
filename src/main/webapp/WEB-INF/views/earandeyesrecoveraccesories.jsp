<%--
  Created by IntelliJ IDEA.
  User: kiejstut
  Date: 28.05.2022
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/earandeyesrecoveraccesoriesform" method="post">
    <input name="name" placeholder="Nazwa">
    <input name="price" placeholder="Cena:">
    <input name="description"  placeholder="Opis">
    Ochrona słuchu czy wzroku?
    <input type="checkbox" name="type" value="sluch"/>sluch
    <input type="checkbox" name="type" value="wzrok"/>wzrok
    <input type="submit" value="Wyślij">
</form>
</body>
</html>
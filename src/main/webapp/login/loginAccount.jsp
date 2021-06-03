<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/3/2021
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .notification{
            color: darkmagenta;
        }
    </style>
</head>
<body>

<form action="" method="post">
<table>
    <tr>
        <td>Email</td>
        <td><input type="text" name="username"></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="text" name="password"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Dang nhap"></td>
    </tr>

</table>
    <c:if test='${requestScope["notification"] != null}'>
        <h2 class="notification">${requestScope["notification"]}</h2>
    </c:if>
</form>

</body>
</html>

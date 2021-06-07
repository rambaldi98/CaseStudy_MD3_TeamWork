<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/5/2021
  Time: 3:12 PM
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

<h2>Thay đổi điểm</h2>

<h3><a href="/minister}">Quay lại</a></h3>

<h4>
    <c:if test='${requestScope["notification"] != null}'>
        <span class="notification">${requestScope["notification"]}</span>
    </c:if>
</h4>

<form action="" method="post">

    <table>
        <tr>
            <td>Point</td>
            <td>
                <input type="text" name="point" value="${point.getPoint()}">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Thay đổi"></td>
        </tr>
    </table>
</form>

</body>
</html>

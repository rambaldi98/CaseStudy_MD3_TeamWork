<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/5/2021
  Time: 3:22 PM
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

<h4>
    <c:if test='${requestScope["notification"] != null}'>
        <span class="notification">${requestScope["notification"]}</span>
    </c:if>
</h4>
<form action="" method="post">
<table>
        <tr><td>Nhập tên cho học sinh cần thay đổi:</td>
            <td></td>
        </tr>
        <tr><td><input type="text" name="name"></td></tr>
    <tr>
        <td><input type="submit" value="Tìm kiếm"></td>
    </tr>
</table>
</form>

</body>
</html>

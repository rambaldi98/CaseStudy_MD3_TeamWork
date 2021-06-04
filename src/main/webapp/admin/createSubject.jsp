<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/4/2021
  Time: 9:01 AM
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
<h1>Them môn học mới</h1>

<h2><a href="admin/indexAdmin.jsp">Quay lại</a></h2>
<h4>
    <c:if test='${requestScope["notification"] != null}'>
        <span class="notification">${requestScope["notification"]}</span>
    </c:if>
</h4>

<form action="" method="post">

    <table>
        <tr>
            <td>Tên môn học</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Thêm"></td>
        </tr>
    </table>

</form>

</body>
</html>

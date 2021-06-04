<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/3/2021
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
    <style>
        .notification{
            color: darkmagenta;
        }
    </style>
</head>
<body>

<h1>Xóa học viên</h1>
<h3><a href="/admin?action=listUser">Quay lại </a></h3>

<h4>
    <c:if test='${requestScope["notification"] != null}'>
        <span class="notification">${requestScope["notification"]}</span>
    </c:if>
</h4>

<form  method="post">
    <h3>Bạn chắc chắn muốn xóa</h3>
    <fieldset>
        <table>
            <tr>
                <td>Họ tên:</td>
                <td>${requestScope["user"].getName()}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${requestScope["user"].getEmail()}</td>
            </tr>

            <tr>
                <td>Địa chỉ</td>
                <td>${requestScope["user"].getAddress()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Xóa"></td>
            </tr>
        </table>
    </fieldset>
</form>


</body>
</html>

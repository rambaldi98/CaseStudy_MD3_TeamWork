<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/3/2021
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <style>
        .notification{
            color: darkmagenta;
        }
    </style>
</head>
<body>
<h1>Create User</h1>

<form  method="post">
    <c:if test='${requestScope["notification"] != null}'>
        <h2 class="notification">${requestScope["notification"]}</h2>
    </c:if>
    <table>
        <tr>
            <td>Họ tên:</td>
            <td><input type="text" name="name" ></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" ></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password" ></td>
        </tr>
        <tr>
            <td>Số điện thoại</td>
            <td><input type="text" name="phone" ></td>
        </tr>
        <tr>
            <td>Ngày sinh</td>
            <td><input type="date" name="dateOfBirth"></td>
        </tr>
        <tr>
            <td>Địa chỉ</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Giới tính</td>
            <td>
                <select name="gender_id" >
                    <option value="1">Male</option>
                    <option value="2">Female</option>

                </select>
            </td>
        </tr>

        <tr>
            <td>Vai trò</td>
            <td>
                <select name="role_id" >
                    <option value="2">TEACHER</option>
                    <option value="3">MINISTER</option>
                    <option value="4">STUDENT</option>

                </select>
            </td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Thêm mới"></td>
        </tr>
    </table>
</form>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/3/2021
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
    <style>
        .notification{
            color: darkmagenta;
        }
    </style>
</head>
<body>

<h1>Sửa thông tin hoc sinh</h1>
<h3><a href="admin/indexAdmin.jsp">Quay lại</a></h3>

<c:if test='${requestScope["notification"] != null}'>
    <span class="notification">${requestScope["notification"]}</span>
</c:if>

<form  method="post">
    <table>
        <tr>
            <td>Họ tên:</td>
            <td><input type="text" name="name" value="${requestScope["user"].getName()}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"  value="${requestScope["user"].getEmail()}"></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><input type="text" name="password"  value="${requestScope["user"].getPassword()}"></td>
        </tr>
        <tr>
            <td>Phone: </td>
            <td><input type="text" name="phone"  value="${requestScope["user"].getPhone()}"></td>
        </tr>
        <tr>
            <td>Ngày sinh: </td>
            <td><input type="date" name="dateOfBirth"  value="${requestScope["user"].getDateOfBirth()}"></td>
        </tr>
        <tr>
            <td>Địa chỉ: </td>
            <td><input type="text" name="address"  value="${requestScope["user"].getAddress()}"></td>
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
            <td><input type="submit" value="Nhấn đê :v"></td>
        </tr>
    </table>
</form>

</body>
</html>

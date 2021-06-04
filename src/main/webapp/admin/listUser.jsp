<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/3/2021
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            text-align: center;
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even){background-color: #f2f2f2}
        th {
            background-color: #4CAF50;
            color: white;
        }
        button{
            border-radius: 8px;
            background: aqua;
        }
        body{
            text-align: center;
        }
    </style>
</head>
<body>

<h1>Danh sách </h1>


<h2><a href="/admin">Trở về trang chủ</a></h2>

<table>
    <tr>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Password</th>
        <th>Số điện thoại</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th>Vai trò</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items='${requestScope["userList"]}' var="u">
        <tr>
            <td>${u.getId()}</td>
            <td>${u.getName()}</td>
            <td>${u.getEmail()}</td>
            <td>${u.getPassword()}</td>
            <td>${u.getPhone()}</td>
            <td>${u.getDateOfBirth()}</td>
            <td>${u.getAddress()}</td>
            <td>${u.getGender()}</td>
            <td>${u.getRole()}</td>
            <td><a href="/admin?action=updateUser&id=${u.getId()}">Chỉnh sửa</a></td>
            <td><a href="/admin?action=deleteUser&id=${u.getId()}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

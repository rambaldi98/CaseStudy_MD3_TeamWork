<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/5/2021
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>


</head>
<body>
<h3><a href="minister/indexMinister.jsp">Quay lại</a></h3>

<table>
    <tr>
        <td>Họ tên: </td>
        <td>${student.getStudent().getName()}</td>
    </tr>
    <tr>
        <td>Địa chỉ</td>
        <td>${student.getStudent().getAddress()}</td>
    </tr>
    <tr>
        <td>Giới tính</td>
        <td>${student.getStudent().getGender()}</td>
    </tr>
    <tr>
        <td>Trạng thái</td>
        <td>${student.getStatus()}</td>
        <td><a href="/minister?action=changeStatus&id=${student.getStudent().getId()}">Thay đổi</a></td>
    </tr>

</table>
</body>
</html>

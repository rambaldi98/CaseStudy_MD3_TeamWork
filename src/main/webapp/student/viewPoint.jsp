<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/5/2021
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xem diem</title>
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
<h3><a href="/student/indexStudent.jsp">Quay lại</a></h3>

<h3>Tên học sinh : ${user.getName()}</h3>

<table>
    <tr>
        <th>Môn học</th>
        <th>Điểm</th>
    </tr>
    <c:forEach items='${requestScope["pointList"]}' var="p">
        <tr>
            <td>${p.getSubject().getName()}</td>
            <td>${p.getPoint()}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>

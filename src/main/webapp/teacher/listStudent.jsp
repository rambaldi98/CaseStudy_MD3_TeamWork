<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/4/2021
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách học sinh</title>
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
<h1>Danh sách học sinh</h1>

<h2><a href="teacher/listClass.jsp">Trở về danh sách lớp</a></h2>

<table>
<tr>
    <th>Tên Lớp</th>
    <td>Tên học sinh</td>
</tr>
<c:forEach items='${requestScope["classStudentList"]}' var="c">
    <tr>
        <td>${c.getaClass().getName()}</td>
        <td>${c.getStudent().getName()}</td>
    </tr>
</c:forEach>
</table>

</body>
</html>

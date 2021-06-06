<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/6/2021
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<h2><a href="/teacher/indexTeacher.jsp">Trở về trang chủ</a></h2>

<table>
    <tr>
        <th>Ngày viết</th>
        <th>Nội dung</th>
        <th></th>
    </tr>
    <c:forEach items='${requestScope["diaryClassList1"]}' var="d">
        <tr>
            <td>${d.getDate()}</td>
            <td>${d.getDiary()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

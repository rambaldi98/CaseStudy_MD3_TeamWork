<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/4/2021
  Time: 11:32 AM
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


<h1>Danh sách </h1>


<h2><a href="/teacher/indexTeacher.jsp">Trở về trang chủ</a></h2>

<table>
    <tr>
        <th>Tên GV</th>
        <th>Lớp học</th>
    </tr>
    <c:forEach items='${requestScope["diaryClassList"]}' var="d">
        <tr>
            <td>${d.getTeacher().getName()}</td>
            <td><a href="/teacher?action=listStudent&id=${d.getaClass().getId()}">${d.getaClass().getName()}</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

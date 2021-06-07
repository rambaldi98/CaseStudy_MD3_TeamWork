<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/4/2021
  Time: 5:25 PM
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
<h2>Viết nhập kí</h2>

<h2><a href="teacher/indexTeacher.jsp"> Quay lại</a></h2>


<h4>
    <c:if test='${requestScope["notification"] != null}'>
        <span class="notification">${requestScope["notification"]}</span>
    </c:if>
</h4>

<form action="" method="post">
    <table>

        <tr>
            <td>Giáo viên</td>
            <td>${user.getName()}</td>
        </tr>

        <tr>
            <td>"Thời gian</td>
            <td><input type="date" name = "date"></td>
        </tr>
        <tr>
            <td>Nhật kí</td>
            <td><input type="text" name="diary"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Thêm mới"></td>
        </tr>

    </table>
</form>

</body>
</html>

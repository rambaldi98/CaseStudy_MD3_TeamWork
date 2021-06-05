<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/5/2021
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        .notification{
            color: darkmagenta;
        }
    </style>
</head>
<body>
<h3><a href="/minister/indexMinister.jsp">Quay lại</a></h3>
<h4>
    <c:if test='${requestScope["notification"] != null}'>
        <span class="notification">${requestScope["notification"]}</span>
    </c:if>
</h4>



<form action="" method="post">

<table>
    <tr>
    <td>status</td>
    <td>
        <select name="status_id">
            <option value="1">STUDYING</option>
            <option value="2">WAITING</option>
            <option value="3">STOP_STUDYING</option>
            <option value="4">SUSPEND</option>
        </select>
    </td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Thay đổi"></td>
    </tr>
</table>
</form>
</body>
</html>

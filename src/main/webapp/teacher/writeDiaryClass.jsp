<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/4/2021
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Write diary</title>
</head>
<body>

<form action="" method="post">
    <table>

        <tr>
            <td>Giáo viên</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Lớp</td>
            <td>
                <select name="id_class">
                    <c:forEach var="l" items="${classList}">
                        <option value="${l.getId()}">${l.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Nhật kí</td>
            <td><input type="text" name="diary"></td>
        </tr>

    </table>
</form>

</body>
</html>

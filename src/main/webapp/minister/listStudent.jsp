<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/3/2021
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>List Student</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link rel="stylesheet" href="../template/layout/styles/layout.css" type="text/css" />
    <script type="text/javascript" src="../template/layout/scripts/jquery.min.js"></script>
    <script type="text/javascript" src="../template/layout/scripts/jquery.slidepanel.setup.js"></script>
    <script type="text/javascript" src="../template/layout/scripts/jquery.ui.min.js"></script>
    <script type="text/javascript" src="../template/layout/scripts/jquery.tabs.setup.js"></script>
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
<div class="wrapper col0" style="color: white">
    <div id="loginpanel" style="color: white">
        <ul>
            <li class="left"> Hello ${user.getName()} (${user.getRole()})</li>
            <li class="right" id="toggle"><a methods="get" href="/login">Log Out</a></li>
            <%--                <li class="left">Log In Here &raquo;</li>--%>
            <%--        <li class="left" id="toggle" style="color: white"><a id="slideit"  style="color: white">Hello ${user.getName()} </a>  </li>--%>
            <%--        <li class="right" id="toggle" style="color: white"><a id="slid" style="color: blue"> (${user.getRole()})</a></li>--%>
        </ul>
    </div>
</div>
<%--   thanh tiep--%>
<div class="wrapper col1">
    <div id="header">
        <div id="logo">
            <h1><a href="login">CODEGYM</a></h1>
            <p>Raising The Bar</p>
        </div>
        <div class="fl_right">
            <ul>
                <li class="last"><a href="#">Search</a></li>
                <li><a href="#">Online Support</a></li>
                <li><a href="#">School Board</a></li>
            </ul>
            <p>Tel: +84 3377 52 555 | Mail:diencong5998@gmail.com</p>
        </div>
        <br class="clear" />
    </div>
</div>


<%-- thanh menu --%>
<div class="wrapper col2">
    <div id="topnav">
        <ul>
            <li ><a href="/minister">Home</a>
                <%--                <ul>--%>
                <%--                    <li><a href="#">Libero</a></li>--%>
                <%--                    <li><a href="#">Maecenas</a></li>--%>
                <%--                    <li><a href="#">Mauris</a></li>--%>
                <%--                    <li class="last"><a href="#">Suspendisse</a></li>--%>
                <%--                </ul>--%>
            </li>
<%--            <li class="active"><a href="/admin?action=listUser">List User</a>--%>

            </li>
<%--            <li><a href="/admin?action=createUser">Add new User</a>--%>
                <%--                <ul>--%>
                <%--                    <li><a href="#">Lorem ipsum dolor</a></li>--%>
                <%--                    <li><a href="#">Suspendisse in neque</a></li>--%>
                <%--                    <li class="last"><a href="#">Praesent et eros</a></li>--%>
                <%--                </ul>--%>
            </li>
            <li><a href="/minister?action=listStudent">List Student</a></li>
<%--            <li class="last"><a href="#">Show Subject</a></li>--%>
        </ul>
    </div>
</div>



<table>
    <tr>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Số điện thoại</th>
        <th>Địa chỉ</th>
        <th>Status</th>
        <th colspan="2">Action</th>

    </tr>
    <c:forEach items='${requestScope["studentList"]}' var="u">
        <tr>
            <td>${u.getStudent().getName()}</td>
            <td>${u.getStudent().getEmail()}</td>
            <td>${u.getStudent().getPhone()}</td>
            <td>${u.getStudent().getAddress()}</td>
            <td>${u.getStatus()}</td>
            <td><a href="/minister?action=changeStatus&id=${u.getStudent().getId()}">Change Status</a></td>
            <td><a href="/minister?action=viewPoint&id=${u.getStudent().getId()}">View Point</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>


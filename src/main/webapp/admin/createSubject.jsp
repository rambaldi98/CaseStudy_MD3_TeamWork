<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/4/2021
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link rel="stylesheet" href="../template/layout/styles/layout.css" type="text/css" />
    <script type="text/javascript" src="../template/layout/scripts/jquery.min.js"></script>
    <script type="text/javascript" src="../template/layout/scripts/jquery.slidepanel.setup.js"></script>
    <script type="text/javascript" src="../template/layout/scripts/jquery.ui.min.js"></script>
    <script type="text/javascript" src="../template/layout/scripts/jquery.tabs.setup.js"></script>

    <style>
        .notification{
            color: darkmagenta;
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
            <li ><a href="/admin">Home</a>
                <%--                <ul>--%>
                <%--                    <li><a href="#">Libero</a></li>--%>
                <%--                    <li><a href="#">Maecenas</a></li>--%>
                <%--                    <li><a href="#">Mauris</a></li>--%>
                <%--                    <li class="last"><a href="#">Suspendisse</a></li>--%>
                <%--                </ul>--%>
            </li>
            <li ><a href="/admin?action=listUser">List User</a>

            </li>
            <li ><a href="/admin?action=createUser">Add new User</a>
                <%--                <ul>--%>
                <%--                    <li><a href="#">Lorem ipsum dolor</a></li>--%>
                <%--                    <li><a href="#">Suspendisse in neque</a></li>--%>
                <%--                    <li class="last"><a href="#">Praesent et eros</a></li>--%>
                <%--                </ul>--%>
            </li>
            <li class="active"><a href="/admin?action=createSubject">Add New Subject</a></li>
            <li class="last"><a href="#">Show Subject</a></li>
        </ul>
    </div>
</div>


<h2><a href="admin/indexAdmin.jsp">Quay lại</a></h2>
<h4>
    <c:if test='${requestScope["notification"] != null}'>
        <span class="notification">${requestScope["notification"]}</span>
    </c:if>
</h4>

<form action="" method="post">

    <table>
        <tr>
            <td>Tên môn học</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Thêm"></td>
        </tr>
    </table>

</form>

</body>
</html>

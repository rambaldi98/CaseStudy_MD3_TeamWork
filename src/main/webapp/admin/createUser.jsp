<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Create User</title>
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
            <li class="active"><a href="/admin?action=createUser">Add new User</a>
                <%--                <ul>--%>
                <%--                    <li><a href="#">Lorem ipsum dolor</a></li>--%>
                <%--                    <li><a href="#">Suspendisse in neque</a></li>--%>
                <%--                    <li class="last"><a href="#">Praesent et eros</a></li>--%>
                <%--                </ul>--%>
            </li>
            <li><a href="/admin?action=createSubject">Add New Subject</a></li>
            <li class="last"><a href="#">Show Subject</a></li>
        </ul>
    </div>
</div>



<form  method="post">
    <c:if test='${requestScope["notification"] != null}'>
        <h2 class="notification">${requestScope["notification"]}</h2>
    </c:if>
    <table>
        <tr>
            <td>Họ tên:</td>
            <td><input type="text" name="name" ></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" ></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password" ></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" ></td>
        </tr>
        <tr>
            <td>Date Of Birth</td>
            <td><input type="date" name="dateOfBirth"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <select name="gender_id" >
                    <option value="1">Male</option>
                    <option value="2">Female</option>

                </select>
            </td>
        </tr>

        <tr>
            <td>Role</td>
            <td>
                <select name="role_id" id="role_id" onchange="genderChanged(this)"  >
                    <option selected disabled>----SELECT----</option>
                    <option value="2">TEACHER</option>
                    <option value="3">MINISTER</option>
                    <option value="4">STUDENT</option>

                </select>

            </td>
        </tr>

        <tr id = task >


            <script language="javascript">
                // Hàm xử lý khi thẻ select thay đổi giá trị được chọn
                // obj là tham số truyền vào và cũng chính là thẻ select
                function genderChanged(obj)
                {
                    let message = document.getElementById('task');
                    let value = obj.value;
                    if(value == '2'|| value == '4') message.innerHTML = '<tr><td>Class</td> <td><input type="text" name="class"></td> </tr>';
                    else
                        message.innerHTML = '';
                }

            </script>
        </tr>


        <tr>
            <td></td>
            <td><input type="submit" value="Thêm mới"></td>
        </tr>
    </table>
</form>

</body>
</html>

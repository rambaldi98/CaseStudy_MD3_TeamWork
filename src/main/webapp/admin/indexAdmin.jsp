<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>ADMIN</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link rel="stylesheet" href="../template/layout/styles/layout.css" type="text/css" />
    <script type="text/javascript" src="../template/layout/scripts/jquery.min.js"></script>
    <script type="text/javascript" src="../template/layout/scripts/jquery.slidepanel.setup.js"></script>
    <script type="text/javascript" src="../template/layout/scripts/jquery.ui.min.js"></script>
    <script type="text/javascript" src="../template/layout/scripts/jquery.tabs.setup.js"></script>
</head>
<body>
<div class="wrapper col0" style="color: white">
<div id="loginpanel" style="color: white">
    <ul>
        <li class="left">Hello ${user.getName()} (${user.getRole()})</li>
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
            <li class="active"><a href="/admin">Home</a>
<%--                <ul>--%>
<%--                    <li><a href="#">Libero</a></li>--%>
<%--                    <li><a href="#">Maecenas</a></li>--%>
<%--                    <li><a href="#">Mauris</a></li>--%>
<%--                    <li class="last"><a href="#">Suspendisse</a></li>--%>
<%--                </ul>--%>
            </li>
            <li><a href="/admin?action=listUser">List User</a>

            </li>
            <li><a href="/admin?action=createUser">Add new User</a>
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





<h1>hello ${user.getName()}</h1>





<div class="wrapper col3" >
    <div id="featured_slide">
        <div id="featured_wrap">
            <ul id="featured_tabs">
                <li><a href="#fc1" style="font-family: 'Times New Roman'"> Điền Văn Công<br />
                    <span>GS.TS</span></a></li>
                <li><a href="#fc2"style="font-family: 'Times New Roman'">Đỗ Trọng Hải<br />
                    <span>PGS.TS</span></a></li>
                <li class="last"><a href="#fc4" style="font-family: 'Times New Roman'">Nguyễn Thành Liêm<br />
                    <span>TS</span></a></li>
            </ul>
            <div id="featured_content">
                <div class="featured_box" id="fc1"><img src="../template/images/demo/cong.png" alt="" />
                    <%--                    <div class="floater"><a href="#">Continue Reading &raquo;</a></div>--%>
                </div>
                <div class="featured_box" id="fc2"><img src="../template/images/demo/hai.png" alt="" />
                    <%--                    <div class="floater"><a href="#">Continue Reading &raquo;</a></div>--%>
                </div>


                <div class="featured_box" id="fc4"><img src="../template/images/demo/liem.png" alt="" />
                    <%--                <div class="floater"><a href="#">Continue Reading &raquo;</a></div>--%>
                </div>
            </div>
        </div>
    </div>
</div>



<div class="wrapper col4">
    <div id="container">
        <div id="hpage">
            <ul>
                <li>
                    <h2>JAVA</h2>
                    <div class="imgholder"><a href="#"><img src="images/demo/200x140.gif" alt="" /></a></div>
                    <p>This is a W3C standards compliant free website template from <a href="http://www.os-templates.com/">OS Templates</a>. For more CSS templates visit <a href="http://www.os-templates.com/">Free Website Templates</a>. Etmetus conse cte tuer leo nisl justo sed vest vitae nunc massa scelerit</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </li>
                <li>
                    <h2>PHP</h2>
                    <div class="imgholder"><a href="#"><img src="images/demo/200x140.gif" alt="" /></a></div>
                    <p>This template is distributed using a <a href="http://www.os-templates.com/template-terms">Website Template Licence</a>, which allows you to use and modify the template for both personal and commercial use when you keep the provided credit links in the footer.</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </li>
                <li>
                    <h2>Python</h2>
                    <div class="imgholder"><a href="#"><img src="images/demo/200x140.gif" alt="" /></a></div>
                    <p>Seddui vestibulum vest mi liberos estibulum urna at eget amet sed. Etmetus consectetuer leo nisl justo sed vest vitae nunc massa scelerit. Namaucibulum lor ligula nullam risque et ristie sollis sapien nulla neque.</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </li>
                <li class="last">
                    <h2>Data Analyst</h2>
                    <div class="imgholder"><a href="#"><img src="images/demo/200x140.gif" alt="" /></a></div>
                    <p>Nullamlacus dui ipsum conseque loborttis non euisque morbi pen as dapibulum orna. Urna ultrices quis curabitur phasellentesque congue magnis vestibulum. Orcieleifendimentum risuspenatoque massa nunc.</p>
                    <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
                </li>
            </ul>
            <br class="clear" />
        </div>
    </div>
</div>

<%--           say --%>
<div class="wrapper col5">
    <div id="footer">
        <div id="newsletter">
            <h2>CodeGym</h2>
            <p>Please enter your email to join our mailing list</p>
            <form action="#" method="post">
                <fieldset>
                    <legend>News Letter</legend>
                    <input type="text" value="Enter Email Here&hellip;"  onfocus="this.value=(this.value=='Enter Email Here&hellip;')? '' : this.value ;" />
                    <input type="submit" name="news_go" id="news_go" value="GO" />
                </fieldset>
            </form>
            <p>To unsubscribe please <a href="#">click here &raquo;</a></p>
        </div>

        <div class="footbox">
            <h2>Information </h2>
            <ul>
                <li><a href="#">About us</a></li>
                <%--                <li><a href="#">Praesent et eros</a></li>--%>
                <%--                <li><a href="#">Lorem ipsum dolor</a></li>--%>
                <%--                <li><a href="#">Suspendisse in neque</a></li>--%>
                <li class="last"><a href="#">Terms of use</a></li>
            </ul>
        </div>
        <div class="footbox">
            <h2>Links</h2>
            <ul>
                <li><a href="#">Learning</a></li>
                <li><a href="#">Training</a></li>
                <li><a href="#">Flights</a></li>
                <%--                <li><a href="#">Game</a></li>--%>
                <li class="last"><a href="#">Game</a></li>
            </ul>
        </div>
        <%--        <div class="footbox">--%>
        <%--            <h2>Lacus interdum</h2>--%>
        <%--            <ul>--%>
        <%--                <li><a href="#">Praesent et eros</a></li>--%>
        <%--                <li><a href="#">Praesent et eros</a></li>--%>
        <%--                <li><a href="#">Lorem ipsum dolor</a></li>--%>
        <%--                <li><a href="#">Suspendisse in neque</a></li>--%>
        <%--                <li class="last"><a href="#">Praesent et eros</a></li>--%>
        <%--            </ul>--%>
        <%--        </div>--%>
        <br class="clear" />
    </div>
</div>
</body>
</html>


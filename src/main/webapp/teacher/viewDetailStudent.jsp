<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 6/4/2021
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>

  <h2><a href="teacher/indexTeacher.jsp">Quay lại</a></h2>

  <fielset>
    <legend>Thông tin học sinh</legend>
    <table>
      <tr>
        <td>Họ tên:</td>
        <td>${requestScope["student"].getName()}</td>
      </tr>
      <tr>
        <td>Địa chỉ email:</td>
        <td>${requestScope["student"].getEmail()}</td>
      </tr>
      <tr>
        <td>Phone:</td>
        <td>${requestScope["student"].getPhone()}</td>
      </tr>
      <tr>
        <td>Ngày sinh:</td>
        <td>${requestScope["student"].getDateOfBirth()}</td>
      </tr>
      <tr>
        <td>Địa chỉ:</td>
        <td>${requestScope["student"].getAddress()}</td>
      </tr>
      <tr>
        <td>Giới tính:</td>
        <td>${requestScope["student"].getGender()}</td>
      </tr>
      <tr>
        <td><a href="/teacher?action=writeDiaryStudent&id=${student.getId()}"> Viết nhật kí</a></td>

      </tr>
    </table>
  </fielset>
  </body>
</html>

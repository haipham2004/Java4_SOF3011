<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-08
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<%String baoLoi=request.getAttribute("baoLoi")+"";%>
<p style="color: red"> ${baoLoi}</p>
<form action="/home" method="post">
    <div>
        <lable>Username</lable>
        <input type="text" name="userName" >
    </div>
    <div>
        <lable>Password</lable>
        <input type="password" name="password">
    </div>
    <button type="submit">Login</button>
</form>
</body>
</html>

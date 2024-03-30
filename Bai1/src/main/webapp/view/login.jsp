<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-06
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p>Sayhi: ${userName}</p>
<%String hi=request.getAttribute("userName")+"";%>
<form action="/ket-qua" method="post">
    <div >
        <label name="userName">User namea</label>
        <input type="text" name="userName" value="<%=hi%>">
    </div>
    <div class="mt-3">
        <label name="password">Password</label>
        <input type="password" name="password">
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>

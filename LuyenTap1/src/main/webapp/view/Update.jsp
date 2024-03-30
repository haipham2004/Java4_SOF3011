<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-18
  Time: 08:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div>
    <form action="/san-pham/add" method="post">
        <lable>ID</lable>
        <input type="text" name="id" value="${sp.id}" disabled>

        <lable>Mã</lable>
        <input type="text" name="ma" value="${sp.ma}">

        <lable>Tên</lable>
        <input type="text" name="ten" value="${sp.ten}">

        <lable>Loại</lable>
        <select name="loai" >
            <option value="${sp.loai}" hidden>${sp.loai}</option>
            <option value="Loại 1">Loại 1</option>
            <option value="Loại 2">Loại 2</option>
            <option value="Loại 3">Loại 3</option>
        </select>

        <lable>Giá</lable>
        <input type="text" name="gia" value="${sp.gia}">

        <button type="submit">Update</button>
    </form>
</div>
</body>
</html>

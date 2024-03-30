<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-27
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <table class="table">
        <form action="/giang-vien/search">
            Tên: <input name="tenTim"/>
            <button type="submit">Search</button>
        </form>
        <a href="/giang-vien/giang-vien-nu" class="btn btn-success">Giảng viên nữ</a>
        <br/>
        <a href="/giang-vien/view-add">+Add Student</a>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Giới tính</th>
            <th>Địa chỉ</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGV}" var="item" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${item.id}</td>
                <td>${item.ten}</td>
                <td>${item.tuoi}</td>
                <td>${item.gioiTinh?"Nam":"Nữ"}</td>
                <td>${item.diaChi}</td>
                <td>
                    <a href="/giang-vien/detail?id=${item.id}" class="btn btn-danger">Detail</a>
                    <a href="/giang-vien/view-update?id=${item.id}" class="btn btn-danger">Edit</a>
                    <a href="/giang-vien/remove?id=${item.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

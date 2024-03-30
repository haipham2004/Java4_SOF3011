<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-11
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="card">
    <div class="card-header">
        <form action="/giang-vien/search">
            <lable>Tên</lable>
            <input type="text" class="form-control" name="tenTim">
            <button type="submit" class= "btn btn-secondary mt-3">Serch</button>
        </form>
    </div>
    <table class="table table-hover">
        <div class="d-flex justify-content-start">
            <a href="/giang-vien/view-add" class="btn btn-secondary">Add</a>
            <a href="/giang-vien/giang-vien-nu" class="btn btn-secondary ms-3">Giảng viên nữ</a>
        </div>
        <thead>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Địa chỉ</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${listGV}" var="GV">
            <tr>
                <td>${GV.ID}</td>
                <td>${GV.ma}</td>
                <td>${GV.ten}</td>
                <td>${GV.tuoi}</td>
                <td>${GV.gioiTinh?"Nam":"Nữ"}</td>
                <td>${GV.diaChi}</td>
                <td>
                    <a href="/giang-vien/detail?ID=${GV.ID}" class="btn btn-danger">Detail</a>
                    <a href="#" class="btn btn-danger">Edit</a>
                    <a href="#" class="btn btn-danger">Remove</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>

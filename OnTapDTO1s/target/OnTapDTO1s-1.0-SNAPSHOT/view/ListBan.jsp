<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-09
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ListBan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <div>
        <form action="/Add" method="post">
            <div class="mt-3">
                <lable>Ma</lable>
                <input type="text" class="form-control" name="ma">
            </div>

            <div class="mt-3">
                <lable>ten</lable>
                <input type="text" class="form-control" name="ten">
            </div>

            <div class="mt-3">
                <lable>soThich</lable>
                <input type="text" class="form-control" name="soThich">
            </div>
            <lable>GioiTinh</lable>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="true" checked>
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="false" name="gioiTinh">
                <label class="form-check-label">
                    Nu
                </label>
            </div>

            <lable>Moi quan he</lable>
            <select class="form-select" aria-label="Default select example" name="idMoiQuanHe">
                <c:forEach items="${listMQH}" var="b">
                    <option value="${b.id}">${b.ten}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-success">Add</button>
        </form>
    </div>
    <table class="table">
        <thead>
        <th>ma</th>
        <th>ten</th>
        <th>soThich</th>
        <th>gioiTinh</th>
        <th>maMoiQuanHe</th>
        <th>tenMoiQuanHe</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${listB}" var="a">
            <tr>
                <td>${a.ma}</td>
                <td>${a.ten}</td>
                <td>${a.soThich}</td>
                <td>${a.gioiTinh?"Nam":"Nữ"}</td>
                <td>${a.maMoiQuanHe}</td>
                <td>${a.tenMoiQuanHe}</td>
                <td>
                    <a href="/Delete?id=${a.id}" class="btn btn-success">Delete</a>
                    <a href="/ViewUpdate?id=${a.id}" class="btn btn-success">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>

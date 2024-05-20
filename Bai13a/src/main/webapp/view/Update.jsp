<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-01
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="/Update?id=${ctsp.idCTSP}" method="post">
        <div class="mt-3">
            <lable>SoLuongTon</lable>
            <input type="text" name="soLuongTon" value="${ctsp.soLuongTon}">
        </div>
        <div class="mt-3">
            <lable>donGia</lable>
            <input type="text" name="donGia" value="${ctsp.donGia}">
        </div>
        <div class="mt-3">
            <lable>ghiChu</lable>
            <input type="text" name="ghiChu" value="${ctsp.ghiChu}">
        </div>
        <div class="mt-3">
            <select class="form-select" aria-label="Default select example" name="thuongHieu.idThuongHieu">
                <option value="${ctsp.thuongHieu.idThuongHieu}">${ctsp.thuongHieu.tenThuongHieu}</option>
                <c:forEach items="${listTH}" var="t">
                    <option value="${t.idThuongHieu}">${t.tenThuongHieu}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Update</button>
    </form>
</div>
</body>
</html>

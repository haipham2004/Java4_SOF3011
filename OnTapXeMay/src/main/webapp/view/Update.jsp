<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-14
  Time: 14:07
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
<form action="/Update?id=${xm.id}" method="post">
    <div class="mt-3">
        <lable>Ma</lable>
        <input type="text"  class="form-control" name="ma" value="${xm.ma}">
    </div>

    <div class="mt-3">
        <lable>ten</lable>
        <input type="text"  class="form-control" name="ten" value="${xm.ten}">
    </div>

    <div class="mt-3">
        <lable>moTa</lable>
        <input type="text"  class="form-control" name="moTa" value="${xm.moTa}">
    </div>

    <div class="mt-3">
        <lable>soLuong</lable>
        <input type="text"  class="form-control" name="soLuong" value="${xm.soLuong}">
    </div>

    <div class="mt-3">
        <lable>idloaiXeMay</lable>
        <select class="form-select" aria-label="Default select example" name="idLoaiXeMay">
            <option value="${xm.loaiXeMay.id}">${xm.loaiXeMay.ten}</option>
            <c:forEach items="${listLXM}" var="b">
                <option value="${b.id}">${b.ten}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-success">Update</button>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-31
  Time: 09:39
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
<form action="/sinh-vien/update?id=${sv.id}" method="post">
    <div class="mt-3">
        <lable>Ma</lable>
        <input type="text" class="form-control" name="ma"  value="${sv.ma}">
    </div>

    <div class="mt-3">
        <lable>Ten</lable>
        <input type="text" class="form-control" name="ten"  value="${sv.ten}">
    </div>

    <div class="mt-3">
        <lable>Tuoi</lable>
        <input type="text" class="form-control" name="tuoi"  value="${sv.tuoi}">
    </div>
    <div class="mt-3">
        <lable>DiaChi</lable>
        <input type="text" class="form-control" name="diaChi" value="${sv.diaChi}">
    </div>

    <div class="mt-3">
        <div class="form-check">
            <input class="form-check-input" type="radio" value="true" name="gioiTinh" ${sv.gioiTinh==true?"checked":""}>
            <label class="form-check-label">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="false" name="gioiTinh" ${sv.gioiTinh==false?"checked":""}  checked>
            <label class="form-check-label" >
                Nu
            </label>
        </div>
    </div>

    <div class="mt-3">
        <select class="form-select" aria-label="Default select example" name="lopHoc.id">
            <option value="${sv.lopHoc.id}"> ${sv.lopHoc.ten}</option>
            <c:forEach items="${listLH}" var="lh">
                <option value="${lh.id}"> ${lh.ten}</option>
            </c:forEach>
        </select>
    </div>
    <button class="btn " type="submit">update</button>
</form>
</body>
</html>

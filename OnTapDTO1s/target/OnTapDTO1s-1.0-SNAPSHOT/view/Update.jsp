<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-10
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <form action="/Update?id=${ban.id}" method="post">
        <div class="mt-3">
            <lable>Ma</lable>
            <input type="text" class="form-control" name="ma" value="${ban.ma}">
        </div>

        <div class="mt-3">
            <lable>ten</lable>
            <input type="text" class="form-control" name="ten" value="${ban.ten}">
        </div>

        <div class="mt-3">
            <lable>soThich</lable>
            <input type="text" class="form-control" name="soThich" value="${ban.soThich}">
        </div>
        <lable>GioiTinh</lable>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gioiTinh" value="true"  ${ban.gioiTinh==true?"checked":""} name="gioiTinh">
            <label class="form-check-label">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="false"  ${ban.gioiTinh==false?"checked":""} name="gioiTinh">
            <label class="form-check-label">
                Nu
            </label>
        </div>
<%--        <lable>IdMoiQuanHe</lable>--%>
<%--        <select class="form-select" aria-label="Default select example" name="idMoiQuanHe">--%>
<%--            <option value="${ban.moiQuanHe.id}" hidden selected>${ban.moiQuanHe.ten}</option>--%>
<%--            <c:forEach items="${listMQH}" var="b2" varStatus="i">--%>
<%--                <option value="${b2.id}">${b2.ten}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
        <lable>Moi quan he</lable>
        <select class="form-select" aria-label="Default select example" name="idMoiQuanHe">
            <option value="${ban.moiQuanHe.id}">${ban.moiQuanHe.ten}</option>
            <c:forEach items="${listMQH}" var="b">
                <option value="${b.id}">${b.ten}</option>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-success">Update</button>
    </form>
</div>
</body>
</html>

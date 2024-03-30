<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-12
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="card">
    <form action="">
        <div class="mt-3">
            <lable>Id</lable>
            <input type="text" name="ID" class="form-control" value="${gv.ID}">
        </div>
        <div class="mt-3">
            <lable>Mã</lable>
            <input type="text" name="ma" class="form-control" value="${gv.ma}">
        </div>
        <div class="mt-3">
            <lable>Tên</lable>
            <input type="text" name="ten" class="form-control" value="${gv.ten}">
        </div>
        <div class="mt-3">
            <lable>Tuổi</lable>
            <input type="text" name="tuoi" class="form-control" value="${gv.tuoi}">
        </div>
        <div class="mt-3">
            <lable>Giới tính</lable>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="true" ${gv.gioiTinh==true?"checked":""} id="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioiTinh" value="false" ${gv.gioiTinh==false?"checked":""} id="flexRadioDefault2" >
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>
        </div>
        <div class="mt-3">
            <lable>Địa chỉ</lable>
            <input type="text" name="diaChi" class="form-control" value="${gv.diaChi}">
        </div>
    </form>
</div>
</body>
</html>

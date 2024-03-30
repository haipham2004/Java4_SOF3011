<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-27
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<form action="/giang-vien/update?id=${gv.id}" method="post">
    <div class="mt-3">
        <lable>Tên</lable>
        <input type="text" class="form-control" name="ten" value="${gv.ten}"/>
    </div>
    <div class="mt-3">
        <lable>Tuổi</lable>
        <input type="text" class="form-control" name="tuoi" value="${gv.tuoi}"/>
    </div>
    <div class="mt-3">
        <lable>Giới tính</lable>
        <div class="form-check">
            <input class="form-check-input" value="true" type="radio" ${gv.gioiTinh==true?"checked":""} name="gioiTinh" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input"  value="false" type="radio" ${gv.gioiTinh==false?"checked":""} name="gioiTinh" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Nữ
            </label>
        </div>
    </div>
    <div class="mt-3">
        <lable>Địa chỉ</lable>
        <input type="text" class="form-control" value="${gv.diaChi}" name="diaChi"/>
    </div>

    <button type="submit">Update</button>
</form>
</body>
</html>

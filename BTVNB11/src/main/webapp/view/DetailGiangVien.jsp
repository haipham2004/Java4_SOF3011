<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-28
  Time: 07:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<form action="" >
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
            <input class="form-check-input"  value="false" type="radio" ${gv.gioiTinh==false?"checked":""} name="gioiTinh" id="flexRadioDefault2" >
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

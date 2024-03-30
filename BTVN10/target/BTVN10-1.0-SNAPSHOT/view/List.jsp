<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-15
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Lisst</title>
</head>
<body>
<%
    String maGV = request.getAttribute("maGV") + "";
    maGV = (maGV.equals("null")) ? "" : maGV;
    String ten = request.getAttribute("ten") + "";
    ten = (ten.equals("null")) ? "" : ten;
    String queQuan = request.getAttribute("queQuan") + "";
    queQuan = (queQuan.equals("null")) ? "" : queQuan;
%>

<div class="mt-3">
    <form action="/giang-vien/add" method="post">

        <div class="mt-3">
            <lable>Mã GV</lable>
            <input type="text" name="maSoSinhVien" value="${gv.maSoSinhVien}">
            <p style="color: red">${Errol_maGV}</p>
        </div>
        <div class="mt-3">
            <lable>Họ tên</lable>
            <input type="text" name="ten" value="${gv.ten}">
            <p style="color: red">${Errol_ten}</p>
        </div>


        <div class="mt-3">
            <lable>Tuổi</lable>
            <input type="text" name="tuoi" value="${gv.tuoi}">
            <p style="color: red">${Errol_tuoi}</p>
        </div>
        <div class="mt-3">
            <lable>Quê quán</lable>
            <input type="text" name="queQuan" value="${gv.queQuan}">
            <p style="color: red">${Errol_queQuan}</p>
        </div>
        <div class="mt-3">
            <div class="form-check">
                <input class="form-check-input" type="radio" value="true" ${gv.gioiTinh==true?"checked":""} name="gioiTinh"
                       id="flexRadioDefault1" checked>
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="false" ${gv.gioiTinh==false?"checked":""} name="gioiTinh"
                       id="flexRadioDefault2" >
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>
        </div>
        <div class="mt-3">
            <button type="submit" class="btn btn-success">Add</button>
        </div>
    </form>
</div>


<div class="mt-3">
    <table class="table">
        <thead>
        <th>Mã GV</th>
        <th>Họ tên</th>
        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Quê quán</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${listGV}" var="gv">
            <tr>
                <td>${gv.maSoSinhVien}</td>
                <td>${gv.ten}</td>
                <td>${gv.tuoi}</td>
                <td>${gv.gioiTinh}</td>
                <td>${gv.queQuan}</td>
                <td>
                    <a href="/giang-vien/detail?id=${gv.id}" class="btn btn-danger">Detail</a>
                    <a href="/giang-vien/remove?id=${gv.id}" class="btn btn-danger">Remove</a>
                    <a href="/giang-vien/viewUpdate?id=${gv.id}" class="btn btn-danger">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

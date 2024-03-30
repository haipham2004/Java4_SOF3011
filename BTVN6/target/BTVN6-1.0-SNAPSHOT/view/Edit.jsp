<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-15
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<%
    String maGV=request.getAttribute("maGV")+"";
    maGV=(maGV.equals("null"))?"":maGV;
    String ten=request.getAttribute("ten")+"";
    ten=(ten.equals("null"))?"":ten;
    String queQuan=request.getAttribute("queQuan")+"";
    queQuan=(queQuan.equals("null"))?"":queQuan;
%>
<div class="mt-3">
    <form action="/giang-vien/update" method="post">
        <div class="row">
            <div class="col-6">
                <lable>Mã GV</lable>
                <input type="text" name="maGV" value="${gv1.maGV}">
                <p style="color: red">${Errol_maGV}</p>
            </div>
            <div class="col-6">
                <lable>Họ tên</lable>
                <input type="text" name="ten" value="${gv1.ten}">
                <p style="color: red">${Errol_ten}</p>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <lable>Tuổi</lable>
                <input type="text" name="tuoi" value="${gv1.tuoi}">
                <p>${Errol_tuoi}</p>
            </div>
            <div class="col-6">
                <lable>Quê quán</lable>
                <input type="text" name="queQuan" value="${gv1.queQuan}">
                <p style="color: red">${Errol_queQuan}</p>
            </div>
        </div>
        <div class="mt-3">
            <button type="submit" class="btn btn-success">Update</button>
        </div>
    </form>
</div>
</body>
</html>

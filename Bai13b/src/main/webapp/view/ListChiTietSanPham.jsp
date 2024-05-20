<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-02
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lisst</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>



<div class="container">
    <form action="/Search">
        <p>Tìm min max</p>
        <div class="mt-3">
            <lable>GiaMin</lable>
            <input type="text" name="giaMin">
        </div>
        <div class="mt-3">
            <lable>GiaMax</lable>
            <input type="text" name="giaMax">
        </div>
        <button type="submit">search</button>
    </form>
    <form action="/Add" method="post">
        <div class="mt-3">
            <lable>Ma</lable>
            <input type="text" name="ma" value="${mt.ma}">
        </div>
        <div class="mt-3">
            <lable>Ten</lable>
            <input type="text" name="ten" value="${mt.ten}">
        </div>
        <div class="mt-3">
            <lable>Gia</lable>
            <input type="text" name="gia" value="${mt.gia}">
        </div>
        <div class="mt-3">
            <div class="form-check">
                <input class="form-check-input" type="radio" name="boNho" ${mt.boNho.equals("256GB") ? 'checked' : ''} value="256GB">
                <label class="form-check-label">
                    256GB
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="boNho" ${mt.boNho.equals("512GB") ? 'checked' : ''} value="512GB">
                <label class="form-check-label">
                    512GB
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="boNho" ${mt.boNho.equals("1TB") ? 'checked' : ''} value="1TB">
                <label class="form-check-label">
                    1TB
                </label>
            </div>
        </div>

        <div class="mt-3">
            <select class="form-select" aria-label="Default select example" name="mauSac">
                <option selected hidden value="${mt.mauSac}">${mt.mauSac}</option>
                <option value="Xanh">Xanh</option>
                <option value="Đỏ">Đỏ</option>
                <option value="Vàng">Vàng</option>
                <option value="Bạc">Bạc</option>
            </select>
        </div>
        <button type="submit">Add</button>
    </form>
</div>
<div class="container">
    <table class="table">
        <thead>
        <th>ma</th>
        <th>ten</th>
        <th>gia</th>
        <th>mausac</th>
        <th>Bonho</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${listMT}" var="a">
            <tr>
                <td>${a.ma}</td>
                <td>${a.ten}</td>
                <td>${a.gia}</td>
                <td>${a.mauSac}</td>
                <td>${a.boNho}</td>
                <td>
                    <a href="/Delete?id=${a.id}">Delete</a>
                    <a href="/Detail?id=${a.id}">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

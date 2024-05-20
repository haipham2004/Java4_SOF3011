<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-16
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <form action="/Add">
        <div class="mt-3">
            <lable>Ma</lable>
            <input type="text" name="ma" value="${sv.ma}">
        </div>
        <div class="mt-3">
            <lable>Ten</lable>
            <input type="text" name="ten" value="${sv.ten}">
        </div>
        <div class="mt-3">
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Nam" name="gioiTinh">
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Nu" name="gioiTinh" checked>
                <label class="form-check-label">
                    Nu
                </label>
            </div>
        </div>
        <div class="mt-3">
            <lable>ChucVu</lable>
            <select class="form-select" aria-label="Default select example" name="idChucVu">
               <c:forEach items="${listCV}" var="b">
                   <option value="${b.id}">${b.ten}</option>
               </c:forEach>
            </select>

        </div>
    </form>
</div>
</div>
<div>
    <table class="table">
        <thead>
        <th>ma</th>
        <th>ten</th>
        <th>gioiTinh</th>
        <th>tenChucVu</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${listSV}" var="a">
            <tr>
                <td>${a.ma}</td>
                <td>${a.ten}</td>
                <td>${a.ma}</td>
                <td>${a.gioiTinh}</td>
                <td>${a.tenChucVu}</td>
                <td>
                    <a href="#" class="btn btn-success">Detail</a>
                    <a href="#" class="btn btn-success">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

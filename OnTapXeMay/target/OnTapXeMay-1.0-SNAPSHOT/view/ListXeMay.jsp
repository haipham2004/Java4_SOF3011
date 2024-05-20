<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-13
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<script>
    <%if(request.getAttribute("listRong")!=null){%>
    alert("${listRong}")
    <%}%>

    <%if(request.getAttribute("MaTrung")!=null){%>
    alert("${MaTrung}")
    <%}%>
</script>

<form action="/Add" method="post">
    <div class="mt-3">
        <lable>Ma</lable>
        <input type="text"  class="form-control" name="ma" value="${a.ma}">
    </div>

    <div class="mt-3">
        <lable>ten</lable>
        <input type="text"  class="form-control" name="ten" value="${a.ten}">
    </div>

    <div class="mt-3">
        <lable>moTa</lable>
        <input type="text"  class="form-control" name="moTa" value="${a.moTa}">
    </div>

    <div class="mt-3">
        <lable>soLuong</lable>
        <input type="text"  class="form-control" name="soLuong" value="${a.soLuong}">
    </div>

    <div class="mt-3">
        <lable>idloaiXeMay</lable>
        <select class="form-select" aria-label="Default select example" name="idLoaiXeMay">
            <c:forEach items="${listLXM}" var="b">
                <option value="${b.id}">${b.ten}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-success" onclick="return confirm('Bạn có thêm không ?')">Add</button>
</form>


</div>
<div>
    <table class="table">
        <thead>
        <th>ma</th>
        <th>ten</th>
        <th>moTa</th>
        <th>soLuong</th>
        <th>tenLoaiXeMay</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${listXM}" var="a">
           <tr>
               <td>${a.ma}</td>
               <td>${a.ten}</td>
               <td>${a.moTa}</td>
               <td>${a.soLuong}</td>
               <td>${a.tenLoaiXeMay}</td>
               <td>
                   <a href="/Delete?id=${a.id}" onclick="return confirm('Có xoá không ?')" class="btn btn-success">Delete</a>
                   <a href="/viewUpdate?id=${a.id}" class="btn btn-success" onclick="return confirm('Có update không ?')">Update</a>
               </td>
           </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

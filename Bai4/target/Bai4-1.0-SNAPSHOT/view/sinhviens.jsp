<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>

<table class="table">
    <form action="">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
 <a href="/sinh-vien/view-add">Add Student</a>
    <tr>
        <th>STT</th>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSV}" var="item" varStatus="index">
        <tr>
            <td>${index.count}</td>
            <td>${item.maSoSinhVien}</td>
            <td>${item.ten}</td>
            <td>${item.tuoi}</td>
            <td>${item.diaChi}</td>
            <td>${item.gioiTinh?"Nam":"Nữ"}</td>
            <td>
                <a href="/sinh-vien/detail?ID=${item.maSoSinhVien}" class="btn btn-danger">Detail</a>
                <a href="/sinh-vien/view-update?ID=${item.maSoSinhVien}" class="btn btn-danger">Edit</a>
                <a href="/sinh-vien/remove?ID=${item.maSoSinhVien}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-18
  Time: 07:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<div>
    <form action="/san-pham/tim-kiem" method="get">
        <lable>Tìm kiếm</lable>
        <input type="text" name="timKiem">
        <button type="submit">Search</button>
    </form>
</div>
<div>
    <form action="/san-pham/add" method="post">
        <p>${baoLoi}</p>
        <lable>ID</lable>
        <input type="text" name="id" value="${sp.id}">

        <lable>Mã</lable>
        <input type="text" name="ma" value="${sp.ma}">

        <lable>Tên</lable>
        <input type="text" name="ten" value="${sp.ten}">

        <lable>Loại</lable>
        <select name="loai" >
            <option value="${sp.loai}" hidden>${sp.loai}</option>
            <option value="Loại 1">Loại 1</option>
            <option value="Loại 2">Loại 2</option>
            <option value="Loại 3">Loại 3</option>
        </select>

        <lable>Giá</lable>
        <input type="text" name="gia" value="${sp.gia}">
        <p>${ErrolGia}</p>
        <button type="submit">Add</button>
    </form>
</div>

<div>
    <table border="1px">
        <thead>
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Loại</th>
        <th>Giá</th>
        <th>Action</th>
        </thead>
        <tbody>
          <c:forEach items="${listSP}" var="gv">
              <tr>
                  <td>${gv.id}</td>
                  <td>${gv.ma}</td>
                  <td>${gv.ten}</td>
                  <td>${gv.loai}</td>
                  <td>${gv.gia}</td>
                  <td>
                      <a href="/san-pham/detail?id=${gv.id}">Detail</a>
                      <a href="/san-pham/remove?id=${gv.id}">Remove</a>
                      <a href="/san-pham/view-update?id=${gv.id}">Edit</a>
                  </td>
              </tr>
          </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

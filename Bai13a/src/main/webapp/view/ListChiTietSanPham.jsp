<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-01
  Time: 13:17
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
<div class="container">
    <div>
        <form action="/Search">
            <lable>Tìm thương hiệu</lable>
            <select class="form-select" aria-label="Default select example" name="thuongHieu.idThuongHieu">
                <c:forEach items="${listTH}" var="t">
                    <option selected value="${t.idThuongHieu}">${t.tenThuongHieu}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-success">Search</button>
        </form>
    </div>
    <form action="/Add" method="post">
        <div class="mt-3">
            <lable>SoLuongTon</lable>
            <input type="text" name="soLuongTon" value="${ctsp.soLuongTon}">
            <p>${loiSL}</p>
        </div>
        <div class="mt-3">
            <lable>donGia</lable>
            <input type="text" name="donGia" value="${ctsp.donGia}">
            <p>${loiGia}</p>
        </div>
        <div class="mt-3">
            <lable>ghiChu</lable>
            <input type="text" name="ghiChu" value="${ctsp.ghiChu}">
            <p>${loiGhi}</p>
        </div>
<%--        <div class="mt-3">--%>
<%--            <lable>SanPham</lable>--%>
<%--            <input type="text" name="idSanPham" value="${ctsp.idSanPham}">--%>
<%--&lt;%&ndash;            <p>${loiSL}</p>&ndash;%&gt;--%>
<%--        </div>--%>
        <div class="mt-3">
            <select class="form-select" aria-label="Default select example" name="thuongHieu.idThuongHieu">
                <option value="${ctsp.thuongHieu.idThuongHieu}">${ctsp.thuongHieu.tenThuongHieu}</option>
                <c:forEach items="${listTH}" var="t">
                    <option selected value="${t.idThuongHieu}">${t.tenThuongHieu}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Add</button>
    </form>
</div>
<table class="table">
    <thead>
    <th>ThuongHieu</th>
    <th>SoLuongTon</th>
    <th>DonGia</th>
    <th>GhiChu</th>
<%--    <td>SanPham</td>--%>
    <td>Ten thuong hieu</td>
    <td>tEN tHUONG HIEU 2</td>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach items="${listCTSP}" var="a">
  <tr>
      <td>${a.thuongHieu.tenThuongHieu}</td>
      <td>${a.soLuongTon}</td>
      <td>${a.donGia}</td>
      <td>${a.ghiChu}</td>
<%--      <td>${a.idSanPham}</td>--%>
      <td>${a.thuongHieu.tenThuongHieu}</td>

      <td>
          <c:forEach items="${listTH}" var="b">
              <c:if test="${a.thuongHieu.idThuongHieu eq b.idThuongHieu}">
                  ${b.tenThuongHieu}
              </c:if>
          </c:forEach>
      </td>
      <td>
          <a href="/Delete?id=${a.idCTSP}">Delete</a>
          <a href="/ViewUpdate?id=${a.idCTSP}">Update</a>
      </td>
  </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

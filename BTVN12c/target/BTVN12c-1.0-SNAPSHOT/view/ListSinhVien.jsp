<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-31
  Time: 09:30
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
<div class="container">
    <a href="/sinh-vien/top3">
        <button type="submit">Top3</button>
    </a>
    <form action="/sinh-vien/search">
        <lable>Lowps hoc tim</lable>
        <div class="mt-3">
            <select class="form-select" aria-label="Default select example" name="lopHoc.id">
                <c:forEach items="${listLH}" var="lh">
                    <option value="${lh.id}"> ${lh.ten}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Timf</button>
    </form>
    <form action="/sinh-vien/add" method="post">
        <div class="mt-3">
            <lable>Ma</lable>
            <input type="text" class="form-control" name="ma" value="${sv.ma}">
            <p>${loiMa}</p>
        </div>

        <div class="mt-3">
            <lable>Ten</lable>
            <input type="text" class="form-control" name="ten" value="${sv.ten}">
            <p>${loiTen}</p>
        </div>

        <div class="mt-3">
            <lable>Tuoi</lable>
            <input type="text" class="form-control" name="tuoi" value="${sv.tuoi}">
        </div>
        <div class="mt-3">
            <lable>DiaChi</lable>
            <input type="text" class="form-control" name="diaChi" value="${sv.diaChi}">
        </div>

        <div class="mt-3">
            <div class="form-check">
                <input class="form-check-input" type="radio" value="true"
                       name="gioiTinh" ${sv.gioiTinh==true?"checked":""}>
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="false"
                       name="gioiTinh" ${sv.gioiTinh==false?"checked":""} >
                <label class="form-check-label">
                    Nu
                </label>
            </div>
        </div>

        <div class="mt-3">
            <select class="form-select" aria-label="Default select example" name="lopHoc.id">
<%--                <option hidden selected>Open this select menu</option>--%>
                <option value="${sv.lopHoc.id}"> ${sv.lopHoc.ten}</option>
                <c:forEach items="${listLH}" var="lh">
                    <option selected value="${lh.id}"> ${lh.ten}</option>
                </c:forEach>
            </select>
        </div>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Add
        </button>

        <!-- Modal -->
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Chao cac ban nhe
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <div class="mt-6">
        <table class="table">
            <thead>
            <th>ma</th>
            <th>ten</th>
            <th>tuoi</th>
            <th>diachi</th>
            <th>gioiTinh</th>
            <th>Lophoc</th>
            <th>Actione</th>
            </thead>

            <tbody>
            <c:forEach items="${listSV}" var="sv">
               <tr>
                   <td>${sv.ma}</td>
                   <td>${sv.ten}</td>
                   <td>${sv.tuoi}</td>
                   <td>${sv.diaChi}</td>
                   <td>${sv.gioiTinh}</td>
                   <td>${sv.lopHoc.ten}</td>
                   <td>
                       <a href="/sinh-vien/view-update?id=${sv.id}" class="btn btn-danger">Update</a>
                       <a href="/sinh-vien/delete?id=${sv.id}" class="btn btn-danger">delete</a>
                       <a href="/sinh-vien/detail?id=${sv.id}" class="btn btn-danger">Detail</a>
                   </td>
               </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

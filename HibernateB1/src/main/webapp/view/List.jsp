<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-25
  Time: 07:58
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
    <a href="/view-add" class="btn btn-success">Add</a>
    <table class="table">
        <thead>
        <th>ID</th>
        <th>CAte</th>
        <th>Name</th>
        <th>Name</th>
        <th>Code</th>
        <th>Mtam</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${listP}" var="p">
           <tr>
               <td>${p.id}</td>
               <td>${p.productCode}</td>
               <td>${p.productName}</td>
               <td>${p.price}</td>
               <td>${p.description}</td>
               <td>${p.category.categoryName}</td>
               <td>
                   <a href="#" class="btn btn-danger">Detail</a>
                   <a href="#" class="btn btn-danger">Remove</a>
                   <a href="/category/view-update?id=${p.id}" class="btn btn-danger">Update</a>
               </td>
           </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

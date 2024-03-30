<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-03-27
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddProduct</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<form action="/category/add" method="post">
    <div class="mt-3">
        <lable>code</lable>
        <input type="text" class="form-control" name="productCode"/>
    </div>
    <div class="mt-3">
        <lable>name</lable>
        <input type="text" class="form-control" name="productName"/>
    </div>

    <div class="mt-3">
        <lable>price</lable>
        <input type="text" class="form-control"  name="price"/>
    </div>

    <div class="mt-3">
        <lable>description</lable>
        <input type="text" class="form-control"  name="description"/>
    </div>

    <div class="mt-3">
        <lable>category</lable>
        <input type="text" class="form-control" name="category.id"/>
    </div>
   <button type="submit">Add</button>
</form>
</body>
</html>

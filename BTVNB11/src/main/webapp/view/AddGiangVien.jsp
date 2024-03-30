<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

<form action="/giang-vien/add" method="post">
    <div class="mt-3">
        <lable>Tên</lable>
        <input type="text" class="form-control" name="ten" value="${gv.ten}"/>
    </div>
    <div class="mt-3">
        <lable>Tuổi</lable>
        <input type="text" class="form-control" name="tuoi" value="${gv.tuoi}"/>
    </div>
    <div class="mt-3">
        <lable>Giới tính</lable>
        <div class="form-check">
            <input class="form-check-input" value="true" type="radio" ${gv.gioiTinh==true?"checked":""} name="gioiTinh" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input"  value="false" type="radio" ${gv.gioiTinh==false?"checked":""} name="gioiTinh" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
               Nữ
            </label>
        </div>
    </div>
    <div class="mt-3">
        <lable>Địa chỉ</lable>
        <input type="text" class="form-control" value="${gv.diaChi}" name="diaChi"/>
    </div>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Add
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Bạn có muốn thêm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    okok
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit">Add</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>

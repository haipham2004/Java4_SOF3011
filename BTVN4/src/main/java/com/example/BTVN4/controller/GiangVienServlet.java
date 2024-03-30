package com.example.BTVN4.controller;

import com.example.BTVN4.entity.GiangVien;
import com.example.BTVN4.service.GiangVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi",
        "/giang-vien/search",
        "/giang-vien/giang-vien-nu",
        "/giang-vien/remove",
        "/giang-vien/detail",
        "/giang-vien/view-update",
        "/giang-vien/update",
        "/giang-vien/view-add",
        "/giang-vien/add"
})
public class GiangVienServlet extends HttpServlet {

    private GiangVienService giangVienService = new GiangVienService();

    private List<GiangVien> listGV = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.getAll(request, response);
        } else if (uri.contains("search")) {
            System.out.println("HHAHA");
            this.search(request, response);
        } else if (uri.contains("giang-vien-nu")) {
            this.giangVienNu(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else {
            System.out.println("Hi");
            this.getAll(request, response);
        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ID = request.getParameter("ID");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        int tuoi=0;
        try {
             tuoi = Integer.parseInt(request.getParameter("tuoi"));
        } catch (NumberFormatException e) {
            request.setAttribute("baoLoiTuoi", "Tuổi không hợp lệ");
        }
        boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
        String diaChi = request.getParameter("diaChi");
        request.setAttribute("ID", ID);
        request.setAttribute("ma", ma);
        request.setAttribute("ten", ten);
        request.setAttribute("tuoi", tuoi);
        request.setAttribute("gioiTinh", gioiTinh);
        request.setAttribute("diaChi", diaChi);

        boolean checkError = false;
        if (ID.equals("")) {
            checkError = true;
            request.setAttribute("baoLoiID", "Vui lòng nhập ID");
        }
        if (ma.equals("")) {
            checkError = true;
            request.setAttribute("baoLoiMa", "Vui lòng nhập ma");
        }
        if (ten.equals("")) {
            checkError = true;
            request.setAttribute("baoLoiTen", "Vui lòng nhập ten");
        }
        if (tuoi <= 0) {
            checkError = true;
            request.setAttribute("baoLoiTuoi", "Vui lòng nhập tuoi");
        }
        if (diaChi.equals("")) {
            checkError = true;
            request.setAttribute("baoLoiDiaChi", "Vui lòng nhập dia chi");
        }
        if (checkError) {
            request.getRequestDispatcher("/view/Add.jsp").forward(request, response);
        } else {
            GiangVien gv = GiangVien.builder().ID(ID).ma(ma).ten(ten).tuoi(tuoi).gioiTinh(gioiTinh).diaChi(diaChi).build();
            giangVienService.addGiangVien(gv);
            response.sendRedirect("/giang-vien/hien-thi");
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGV = giangVienService.getAll();
        request.setAttribute("listGV", listGV);
        request.getRequestDispatcher("/view/ListGiangVien.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("ID");
        GiangVien gv = giangVienService.getOne(id);
        request.setAttribute("gv", gv);
        request.getRequestDispatcher("/view/Detail.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/Add.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
    }

    private void giangVienNu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenTim = request.getParameter("tenTim");
        List<GiangVien> listGVNu = giangVienService.searchGiangVienNu();
        request.setAttribute("listGV", listGVNu);
        request.getRequestDispatcher("/view/ListGiangVien.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenTim = request.getParameter("tenTim");
        List<GiangVien> listTenGv = giangVienService.search(tenTim);
        request.setAttribute("listGV", listTenGv);
        request.getRequestDispatcher("/view/ListGiangVien.jsp").forward(request, response);
    }
}

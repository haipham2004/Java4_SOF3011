package com.example.controller;

import com.example.entity.GiangVien;
import com.example.repository.GiangVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GiangVienService", value = {
        "/giang-vien/hien-thi-tat-ca",
        "/giang-vien/detail",
        "/giang-vien/remove",
        "/giang-vien/add",
        "/giang-vien/update",
        "/giang-vien/tim-kiem",
        "/giang-vien/viewUpdate"
})
public class GiangVienServlet extends HttpServlet {

    private List<GiangVien> listGV = new ArrayList<>();

    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("viewUpdate")) {
            this.viewUpdate(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }


    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGV = giangVienRepository.getAll();
        request.setAttribute("listGV", listGV);
        request.getRequestDispatcher("/view/List.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        GiangVien gv = giangVienRepository.getOne(id);
        giangVienRepository.deleteGiangVien(gv);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        System.out.println("detail");
        GiangVien gv = giangVienRepository.getOne(id);
        request.setAttribute("gv", gv);
        listGV = giangVienRepository.getAll();
        request.setAttribute("listGV", listGV);
        request.getRequestDispatcher("/view/List.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String maGV = request.getParameter("maSoSinhVien");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String queQuan = request.getParameter("queQuan");
        String gioiTinh = request.getParameter("gioiTinh");
        request.setAttribute("maGV", maGV);
        request.setAttribute("ten", ten);
        request.setAttribute("queQuan", queQuan);
        request.setAttribute("tuoi", tuoi);

        boolean check = false;
        if (maGV.isEmpty()) {
            check = true;
            request.setAttribute("Errol_maGV", "Mã trống");
        }
        if (ten.isEmpty()) {
            check = true;
            request.setAttribute("Errol_ten", "tên trống");
        }
        int tuois = 0;
        try {
            tuois = Integer.parseInt(tuoi);
        } catch (Exception e) {
            check = true;
            request.setAttribute("Errol_tuoi", "tuoi trong");
        }
        if (queQuan.isEmpty()) {
            check = true;
            request.setAttribute("Errol_queQuan", "quê trống");
        }
        if (check) {
            hienThi(request, response);
        } else {
            GiangVien gv = GiangVien.builder().maSoSinhVien(maGV).gioiTinh(Boolean.parseBoolean(gioiTinh)).ten(ten).tuoi(Integer.parseInt(tuoi)).queQuan(queQuan).build();
            giangVienRepository.addGiangVien(gv);
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        }
    }


    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        GiangVien gv = giangVienRepository.getOne(id);
        request.setAttribute("gv", gv);
        request.getRequestDispatcher("/view/Edit.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        String maGV = request.getParameter("maSoSinhVien");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String queQuan = request.getParameter("queQuan");
        boolean check = false;
        if (maGV.isEmpty()) {
            check = true;
            request.setAttribute("Errol_maGV", "Mã trống");
        }
        if (ten.isEmpty()) {
            check = true;
            request.setAttribute("Errol_ten", "tên trống");
        }
        int tuois = 0;
        try {
            tuois = Integer.parseInt(tuoi);
        } catch (Exception e) {
            check = true;
            request.setAttribute("Errol_tuoi", "tuoi trong");
        }
        if (queQuan.isEmpty()) {
            check = true;
            request.setAttribute("Errol_queQuan", "quê trống");
        }
        if (check) {
            request.getRequestDispatcher("/view/Edit.jsp").forward(request, response);
        } else {
            GiangVien gv = GiangVien.builder().id(id).maSoSinhVien(maGV).ten(ten).tuoi(Integer.parseInt(tuoi)).queQuan(queQuan).build();
            giangVienRepository.updateGiangVien(gv);
            System.out.println("Update2");
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");
        }


    }

}

package com.example.Bai4.controller;

import com.example.Bai4.entity.SinhVien;
import com.example.Bai4.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/search",
        "/sinh-vien/remove",
        "/sinh-vien/detail",
        "/sinh-vien/view-update",
        "/sinh-vien/update",
        "/sinh-vien/view-add",
        "/sinh-vien/add"
})
public class SinhVienServlet extends HttpServlet {
    private SinhVienService sinhVienService = new SinhVienService();
    private List<SinhVien> listSV = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.getAll(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else {
            this.getAll(request, response);
        }

    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.add(request, response);
        }
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSV=sinhVienService.getAll();
        request.setAttribute("listSV",listSV);
        request.getRequestDispatcher("/view/sinhviens.jsp").forward(request,response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID=request.getParameter("ID");
        sinhVienService.deleteSinhVien(ID);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mssv=request.getParameter("ID");
        SinhVien sv=sinhVienService.getOne(mssv);
        request.setAttribute("sv",sv);
        request.getRequestDispatcher("/view/detail-sinh-vien.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Haha");
        String mssv=request.getParameter("ID");
        SinhVien sv=sinhVienService.getOne(mssv);
        request.setAttribute("sv",sv);
        request.getRequestDispatcher("/view/update-sinh-vien.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/add-sinh-vien.jsp").forward(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
//        String mssv=request.getParameter("mssv");
//        String ten=request.getParameter("ten");
//        int tuoi=Integer.parseInt(request.getParameter("tuoi"));
//        String diaChi=request.getParameter("diaChi");
//        boolean gioiTinh=Boolean.parseBoolean(request.getParameter("gioiTinh"));
//        request.setAttribute("mssv",mssv);
//        request.setAttribute("ten",ten);
//        request.setAttribute("tuoi",tuoi);
//        request.setAttribute("diaChi",diaChi);
//        request.setAttribute("gioiTinh",gioiTinh);
//        SinhVien sv=new SinhVien(mssv,ten,tuoi,diaChi,gioiTinh);//nhanh
//        sinhVienService.addSinhVien(sv);
//        getAll(request,response);
//        response.sendRedirect("/sinh-vien/hien-thi");
        SinhVien sv=new SinhVien();
        BeanUtils.populate(sv,request.getParameterMap());
        sinhVienService.addSinhVien(sv);
        response.sendRedirect("/sinh-vien/hien-thi");

    }

}

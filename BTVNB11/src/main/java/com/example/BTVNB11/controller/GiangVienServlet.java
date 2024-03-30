package com.example.BTVNB11.controller;

import com.example.BTVNB11.entity.GiangVien;
import com.example.BTVNB11.repository.GiangVienRepository;
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
        "/giang-vien/view-add",
        "/giang-vien/add",
        "/giang-vien/update"
})
public class GiangVienServlet extends HttpServlet {
    GiangVienRepository repo=new GiangVienRepository();
    List<GiangVien> listGV=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.HienThi(request,response);
        }else if(uri.contains("search")){
            this.Search(request,response);
        }else if(uri.contains("giang-vien-nu")){
            this.GiangVienNu(request,response);
        }else if(uri.contains("remove")){
            this.Remove(request,response);
        }else if(uri.contains("detail")){
            this.Detail(request,response);
        }else if(uri.contains("view-update")){
            this.viewUpdate(request,response);
        }else if(uri.contains("view-add")){
            this.viewAdd(request,response);
        }
    }

 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("add")){
            this.add(request,response);
        }else if(uri.contains("update")){
            this.update(request,response);
        }
    }


    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGV=repo.getAll();
        request.setAttribute("listGV",listGV);
        request.getRequestDispatcher("/view/ListGiangVien.jsp").forward(request,response);
    }
    private void Detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        GiangVien gv=repo.getOne(id);
        request.setAttribute("gv",gv);
        request.getRequestDispatcher("/view/DetailGiangVien.jsp").forward(request,response);
    }
    private void Search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenTim=request.getParameter("tenTim");
        listGV=repo.listTen(tenTim);
        request.setAttribute("listGV",listGV);
        request.getRequestDispatcher("/view/ListGiangVien.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/AddGiangVien.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        GiangVien gv=repo.getOne(id);
        request.setAttribute("gv",gv);
        request.getRequestDispatcher("/view/UpdateGiangVien.jsp").forward(request,response);
    }

    private void Remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        GiangVien gv=repo.getOne(id);
        repo.deleteGiangVien(gv);
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void GiangVienNu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGV=repo.listGiangVienNu(false);
        request.setAttribute("listGV",listGV);
        request.getRequestDispatcher("/view/ListGiangVien.jsp").forward(request,response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String ten=request.getParameter("ten");
        String diaChi=request.getParameter("diaChi");
        String gioiTinh=request.getParameter("gioiTinh");
        String tuoi=request.getParameter("tuoi");
        GiangVien gv=GiangVien.builder().id(id).ten(ten).diaChi(diaChi).tuoi(Integer.parseInt(tuoi)).gioiTinh(Boolean.parseBoolean(gioiTinh)).build();
        repo.updateGiangVien(gv);
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ten=request.getParameter("ten");
        String diaChi=request.getParameter("diaChi");
        String gioiTinh=request.getParameter("gioiTinh");
        String tuoi=request.getParameter("tuoi");
        GiangVien gv=GiangVien.builder().ten(ten).diaChi(diaChi).tuoi(Integer.parseInt(tuoi)).gioiTinh(Boolean.parseBoolean(gioiTinh)).build();
        repo.addGiangVien(gv);
        response.sendRedirect("/giang-vien/hien-thi");
    }
}

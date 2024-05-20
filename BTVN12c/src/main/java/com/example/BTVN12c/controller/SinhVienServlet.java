package com.example.BTVN12c.controller;

import com.example.BTVN12c.entity.LopHoc;
import com.example.BTVN12c.entity.SinhVien;
import com.example.BTVN12c.repository.LopHocRepository;
import com.example.BTVN12c.service.SinhVienServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/detail",
        "/sinh-vien/view-update",
        "/sinh-vien/add",
        "/sinh-vien/update",
        "/sinh-vien/search",
        "/sinh-vien/top3",
        "/sinh-vien/delete"
})
public class SinhVienServlet extends HttpServlet {
    List<SinhVien> listSV = new ArrayList<>();
    List<LopHoc> listLH = new ArrayList<>();
    SinhVienServiceImp serviceImp = new SinhVienServiceImp();
    LopHocRepository repo = new LopHocRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.HienThi(request, response);
        } else if (uri.contains("detail")) {
            this.Detail(request, response);
        } else if (uri.contains("delete")) {
            this.Delete(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (uri.contains("top3")) {
            this.Top3(request, response);
        } else if (uri.contains("search")) {
            this.Search(request, response);
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

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listLH = repo.getAll();
        request.setAttribute("listLH", listLH);
        listSV = serviceImp.getAll();
        request.setAttribute("listSV", listSV);
        request.getRequestDispatcher("/view/ListSinhVien.jsp").forward(request, response);
    }

    private void Search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int lopHoc = Integer.parseInt(request.getParameter("lopHoc.id"));
        LopHoc lh = new LopHoc();
        lh.setId(lopHoc);
        request.setAttribute("listLH", listLH);
        listSV = serviceImp.listTimKiem(lh);
        request.setAttribute("listSV", listSV);
        request.getRequestDispatcher("/view/ListSinhVien.jsp").forward(request, response);

    }

    private void Top3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int idLop=Integer.parseInt(request.getParameter("lopHoc.id"));
//        LopHoc lh=new LopHoc();
//        lh.setId(lh);
        listSV = serviceImp.listTimKiemTop3();
        request.setAttribute("listSV", listSV);
        request.getRequestDispatcher("/view/ListSinhVien.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SinhVien sv = serviceImp.getOne(id);
        request.setAttribute("sv", sv);
        listLH = repo.getAll();
        request.setAttribute("listLH", listLH);
//        listSV=serviceImp.getAll();
//        request.setAttribute("listSV",listSV);
        request.getRequestDispatcher("/view/Update.jsp").forward(request, response);
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SinhVien sv = serviceImp.getOne(id);
        serviceImp.delete(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void Detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SinhVien sv = serviceImp.getOne(id);
        request.setAttribute("sv", sv);
        listLH = repo.getAll();
        request.setAttribute("listLH", listLH);
        listSV = serviceImp.getAll();
        request.setAttribute("listSV", listSV);
        request.getRequestDispatcher("/view/ListSinhVien.jsp").forward(request, response);
    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        int id = Integer.parseInt(request.getParameter("id"));
        int idLop = Integer.parseInt(request.getParameter("lopHoc.id"));
        LopHoc lh = new LopHoc();
        lh.setId(idLop);
        SinhVien sv = SinhVien.builder().id(id).ma(ma).ten(ten).lopHoc(lh).tuoi(Integer.parseInt(tuoi)).diaChi(diaChi).gioiTinh(Boolean.parseBoolean(gioiTinh)).build();
        serviceImp.update(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        boolean check=true;
        if(ma.isEmpty()){
            request.setAttribute("loiMa","Trống mã");
            check=false;
        } if(ten.isEmpty()){
            request.setAttribute("loiTen","Trống ten");
            check=false;
        }
        if(check){
            int idLop = Integer.parseInt(request.getParameter("lopHoc.id"));
            LopHoc lh = new LopHoc();
            lh.setId(idLop);
            SinhVien sv = SinhVien.builder().ma(ma).ten(ten).tuoi(Integer.parseInt(tuoi)).lopHoc(lh).diaChi(diaChi).gioiTinh(Boolean.parseBoolean(gioiTinh)).build();
            serviceImp.add(sv);
            listLH = repo.getAll();
            request.setAttribute("listLH", listLH);
            listSV = serviceImp.getAll();
            request.setAttribute("listSV", listSV);
            request.getRequestDispatcher("/view/ListSinhVien.jsp").forward(request, response);
        }else{
            listLH = repo.getAll();
            request.setAttribute("listLH", listLH);
            listSV = serviceImp.getAll();
            request.setAttribute("listSV", listSV);
            request.getRequestDispatcher("/view/ListSinhVien.jsp").forward(request, response);
        }

    }
}

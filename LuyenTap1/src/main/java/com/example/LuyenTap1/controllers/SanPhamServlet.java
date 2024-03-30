package com.example.LuyenTap1.controllers;

import com.example.LuyenTap1.entity.SanPham;

import com.example.LuyenTap1.service.SanPhamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/detail",
        "/san-pham/remove",
        "/san-pham/view-update",
        "/san-pham/update",
        "/san-pham/tim-kiem",
        "/san-pham/add",
        "/san-pham/view-all"
})
public class SanPhamServlet extends HttpServlet {
    private List<SanPham> listSP = new ArrayList<>();
    SanPhamService sanPhamService=new SanPhamService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.viewAll(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        }
        else if (uri.contains("remove")) {
            this.remove(request, response);
        }
        else if (uri.contains("view-update")) {
            this.viewupdate(request, response);
        }
        else if (uri.contains("/san-pham/tim-kiem")) {
            this.timKiem(request, response);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.update(request, response);
        } else if (uri.contains("add")) {
            this.add(request, response);
        }
    }

    private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSP=sanPhamService.getAll();
        request.setAttribute("listSP",listSP);
        request.getRequestDispatcher("/view/List.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String loai=request.getParameter("loai");
        String gia=request.getParameter("gia");
        int giaFake=0;
        boolean check=false;
        try {
              giaFake=Integer.parseInt(request.getParameter("gia"));
            if(giaFake<=150){
                check=true;
                request.setAttribute("ErrolGia","Giá phải lớn hơn 150");
            }
        }catch (Exception e){
            check=true;
            request.setAttribute("ErrolGia","Giá phải là số");
        }

        if(check){
            viewAll(request,response);
        }else{
            String ids=request.getParameter("id");
            SanPham sps=sanPhamService.getOne(Integer.parseInt(ids));
            System.out.println("GV của tao: "+sps);
            listSP=sanPhamService.getAll();
            if(listSP.contains(sps)){
                request.setAttribute("baoLoi","Sản phẩm đã tồn tại");
                viewAll(request,response);
            }else {
                SanPham sp = SanPham.builder().id(id).ma(ma).ten(ten).loai(loai).gia(Integer.parseInt(gia)).build();
                sanPhamService.themSP(sp);
                viewAll(request, response);
            }
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String loai=request.getParameter("loai");
        int gia=Integer.parseInt(request.getParameter("gia"));
        SanPham sp=SanPham.builder().id(id).ma(ma).ten(ten).loai(loai).gia(gia).build();
        sanPhamService.suaSP(sp);
        response.sendRedirect("/san-pham/view-all");
    }
    private void viewupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        SanPham sp=sanPhamService.getOne(id);
        request.setAttribute("sp",sp);
        request.getRequestDispatcher("/view/Update.jsp").forward(request,response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        sanPhamService.xoaSP(id);
        System.out.println("Xoá 2: "+id);
        viewAll(request,response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        SanPham sp=sanPhamService.getOne(id);
        request.setAttribute("sp",sp);
        viewAll(request,response);
    }

    private void timKiem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten=request.getParameter("timKiem");
        listSP=sanPhamService.listTim(ten);
        request.setAttribute("listSP",listSP);
        System.out.println("Hi");
        if(!ten.isEmpty()){
            request.getRequestDispatcher("/view/List.jsp").forward(request,response);
        }
    }


}

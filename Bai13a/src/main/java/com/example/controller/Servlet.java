package com.example.controller;

import com.example.entity.ChiTietSanPham;
import com.example.entity.ThuongHieu;
import com.example.repository.ChiTietSanPhamRepository;
import com.example.repository.ThuongHieuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = {
        "/HienThi",
        "/ViewUpdate",
        "/Delete",
        "/Add",
        "/Update",
        "/Search"
})
public class Servlet extends HttpServlet {
    ChiTietSanPhamRepository repo=new ChiTietSanPhamRepository();
    ThuongHieuRepository repo2=new ThuongHieuRepository();
    List<ChiTietSanPham> listCTSP=new ArrayList<>();
    List<ThuongHieu> listTH=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThi")) {
            HienThi(request, response);
        }else if (uri.contains("Delete")) {
            Delete(request, response);
        }else if (uri.contains("ViewUpdate")) {
            ViewUpdate(request, response);
        }else if (uri.contains("Search")) {
            Search(request, response);
        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("Add")) {
            Add(request, response);
        } else if (uri.contains("Update")) {
            Update(request, response);
        }
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        ChiTietSanPham ctsp=repo.getOne(id);
        repo.delete(ctsp);
        response.sendRedirect("/HienThi");
    }

    private void ViewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        ChiTietSanPham ctsp=repo.getOne(id);
        request.setAttribute("ctsp",ctsp);
        listTH=repo2.getAll();
        request.setAttribute("listTH",listTH);
        request.getRequestDispatcher("/view/Update.jsp").forward(request,response);
    }

    private void Search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iDTH=Integer.parseInt(request.getParameter("thuongHieu.idThuongHieu"));
        ThuongHieu th=new ThuongHieu();
        th.setIdThuongHieu(iDTH);
        listTH=repo2.getAll();
        request.setAttribute("listTH",listTH);
        listCTSP=repo.listTenThuongHieu(iDTH);
        request.setAttribute("listCTSP",listCTSP);
        request.getRequestDispatcher("/view/ListChiTietSanPham.jsp").forward(request,response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCTSP=repo.getAll();
        request.setAttribute("listCTSP",listCTSP);
        listTH=repo2.getAll();
        request.setAttribute("listTH",listTH);
        request.getRequestDispatcher("/view/ListChiTietSanPham.jsp").forward(request,response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String soLuongTon=request.getParameter("soLuongTon");
        String donGia=request.getParameter("donGia");
        String ghiChu=request.getParameter("ghiChu");
        int idTH=Integer.parseInt(request.getParameter("thuongHieu.idThuongHieu"));
        int id=Integer.parseInt(request.getParameter("id"));
        ThuongHieu th=new ThuongHieu();
        th.setIdThuongHieu(idTH);
        ChiTietSanPham ctsp=ChiTietSanPham.builder().idCTSP(id).soLuongTon(Integer.parseInt(soLuongTon)).donGia(Double.parseDouble(donGia)).thuongHieu(th).ghiChu(ghiChu).build();
        repo.update(ctsp);
        response.sendRedirect("/HienThi");
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String soLuongTon=request.getParameter("soLuongTon");
        String donGia=request.getParameter("donGia");
        String ghiChu=request.getParameter("ghiChu");
        boolean check=true;
       if(soLuongTon.isEmpty()){
           request.setAttribute("loiSL","Bạn chưa nhập số lượng");
           check=false;
       }
        if(donGia.isEmpty()){
            request.setAttribute("loiGia","Bạn chưa nhập donGia");
            check=false;
        }
        if(ghiChu.isEmpty()){
            request.setAttribute("loiGhi","Bạn chưa nhập ghiChu");
            check=false;
        }
        if(check){
            int idTH=Integer.parseInt(request.getParameter("thuongHieu.idThuongHieu"));
            ThuongHieu th=new ThuongHieu();
            th.setIdThuongHieu(idTH);
//            String sanPham=request.getParameter("idSanPham");
            ChiTietSanPham ctsp=ChiTietSanPham.builder().soLuongTon(Integer.parseInt(soLuongTon)).donGia(Double.parseDouble(donGia)).ghiChu(ghiChu).thuongHieu(th).build();
            repo.add(ctsp);
            listCTSP=repo.getAll();
            request.setAttribute("listCTSP",listCTSP);
            listTH=repo2.getAll();
            request.setAttribute("listTH",listTH);
            request.getRequestDispatcher("/view/ListChiTietSanPham.jsp").forward(request,response);
        }else{
            listCTSP=repo.getAll();
            request.setAttribute("listCTSP",listCTSP);
            listTH=repo2.getAll();
            request.setAttribute("listTH",listTH);
            request.getRequestDispatcher("/view/ListChiTietSanPham.jsp").forward(request,response);
        }
    }
}

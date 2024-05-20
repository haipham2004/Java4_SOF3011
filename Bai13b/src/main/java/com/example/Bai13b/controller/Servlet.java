package com.example.Bai13b.controller;

import com.example.Bai13b.entity.MayTinh;
import com.example.Bai13b.repository.MayTinhRepository;
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
        "/Detail",
        "/Search"
})
public class Servlet extends HttpServlet {
    List<MayTinh> listMT=new ArrayList<>();
    MayTinhRepository repo=new MayTinhRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThi")) {
            HienThi(request, response);
        } else if (uri.contains("ViewUpdate")) {
            ViewUpdate(request, response);
        } else if (uri.contains("Delete")) {
            Delete(request, response);
        }else if (uri.contains("Detail")) {
            Detail(request, response);
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
        MayTinh mt=repo.getOne(id);
        repo.delete(mt);
        response.sendRedirect("/HienThi");
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listMT=repo.getAll();
        request.setAttribute("listMT",listMT);
        request.getRequestDispatcher("/view/ListChiTietSanPham.jsp").forward(request,response);
    }
    private void Detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        MayTinh mt=repo.getOne(id);
        request.setAttribute("mt",mt);
        listMT=repo.getAll();
        request.setAttribute("listMT",listMT);
        request.getRequestDispatcher("/view/ListChiTietSanPham.jsp").forward(request,response);
    }
    private void ViewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) {
    }
    private void Search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double min=Double.parseDouble(request.getParameter("giaMin"));
        double max=Double.parseDouble(request.getParameter("giaMax"));
        listMT=repo.timKiem(min,max);
        request.setAttribute("listMT",listMT);
        request.getRequestDispatcher("/view/ListChiTietSanPham.jsp").forward(request,response);
    }
    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma=request.getParameter("ma");
        String ten=request.getParameter("ten");
        String mauSac=request.getParameter("mauSac");
        String boNho=request.getParameter("boNho");
        String gia=request.getParameter("gia");
        MayTinh mt=MayTinh.builder().mauSac(mauSac).ten(ten).ma(ma).boNho(boNho).gia(Double.parseDouble(gia)).build();
        repo.add(mt);
        response.sendRedirect("/HienThi");
    }
}

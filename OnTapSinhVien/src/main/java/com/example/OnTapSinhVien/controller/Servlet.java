package com.example.OnTapSinhVien.controller;

import com.example.OnTapSinhVien.entity.ChucVu;
import com.example.OnTapSinhVien.repository.ChucVuRepository;
import com.example.OnTapSinhVien.response.NhanVienResponse;
import com.example.OnTapSinhVien.service.Imp.NhanVienServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = {
        "/HienThi",
        "/Detail",
        "/Update",
        "/Add"
})
public class Servlet extends HttpServlet {
    List<ChucVu> listCV=new ArrayList<>();
    List<NhanVienResponse> listSV=new ArrayList<>();
    NhanVienServiceImp service=new NhanVienServiceImp();
    ChucVuRepository service2=new ChucVuRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThi")) {
            HienThi(request, response);
        } else if (uri.contains("Detail")) {
            Detail(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("Update")) {
            Update(request, response);
        } else if (uri.contains("Add")) {
            Add(request, response);
        }
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCV=service2.getAll();
        request.setAttribute("listCV",listCV);
        listSV=service.getAll();
        request.setAttribute("listSV",listSV);
        request.getRequestDispatcher("/view/ListSinhVien.jsp").forward(request,response);
    }

    private void Detail(HttpServletRequest request, HttpServletResponse response) {
    }


    private void Update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) {
    }
}

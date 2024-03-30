package com.example.BTVNB11.controller;

import com.example.BTVNB11.entity.GiangVien;
import com.example.BTVNB11.entity.TaiKhoan;
import com.example.BTVNB11.repository.GiangVienRepository;
import com.example.BTVNB11.repository.TaiKhoanRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TaiKhoanServlet", value = {
        "/Login",
        "/viewLogin"

})
public class TaiKhoanServlet extends HttpServlet {
    TaiKhoanRepository repo=new TaiKhoanRepository();
    GiangVienRepository repo2=new GiangVienRepository();
    List<GiangVien> listGV=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("viewLogin")){
            this.ViewLogin(request,response);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String uri=request.getRequestURI();
       if(uri.contains("Login")){
           this.Login(request,response);
       }
    }
    private void ViewLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
    }
    private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user=request.getParameter("userName");
        String pass=request.getParameter("password");
        request.setAttribute("user",user);
        request.setAttribute("pass",pass);
        TaiKhoan tk=repo.login(user,pass);
        boolean check=false;
        if(user.isEmpty()){
            check=true;
            request.setAttribute("baoLoiUser","Nhập user đi");
        }
        if(pass.isEmpty()){
            check=true;
            request.setAttribute("baoLoiPassword","Nhập password đi");

        }
       if(check==true){
           request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
       }else{
           if(tk!=null){
               listGV=repo2.getAll();
               request.setAttribute("listGV",listGV);
               request.getRequestDispatcher("/view/ListGiangVien.jsp").forward(request,response);
           }else{
               request.setAttribute("baoLoiTaiKhoan","Tài khoản không tồn tại");
               request.getRequestDispatcher("/view/viewLogin.jsp").forward(request,response);
           }
       }
    }
}

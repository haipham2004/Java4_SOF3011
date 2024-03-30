package com.example.BTVN6.controller;

import com.example.BTVN6.entity.GiangVien;
import com.example.BTVN6.service.GiangVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

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

    private GiangVienService giangVienService = new GiangVienService();

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
        else {
          this.search(request,response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
           this.update(request,response);
        }
    }



    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGV = giangVienService.getAll();
        request.setAttribute("listGV", listGV);
        request.getRequestDispatcher("/view/List.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String maGV=request.getParameter("maGV");
        giangVienService.deleteGiangVien(maGV);
        hienThi(request,response);
//        request.getRequestDispatcher("/view/List.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maGV=request.getParameter("maGV");
        GiangVien gv=giangVienService.getOne(maGV);
        request.setAttribute("gv",gv);
        hienThi(request,response);
//        request.getRequestDispatcher("/view/List.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String maGV = request.getParameter("maGV");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String queQuan = request.getParameter("queQuan");
        request.setAttribute("maGV",maGV);
        request.setAttribute("ten",ten);
        request.setAttribute("queQuan",queQuan);
        request.setAttribute("tuoi",tuoi);

        boolean check=false;
        if(maGV.isEmpty()){
            check=true;
            request.setAttribute("Errol_maGV","Mã trống");
        }
        if(ten.isEmpty()){
            check=true;
            request.setAttribute("Errol_ten","tên trống");
        }
        int tuois=0;
        try{
            tuois = Integer.parseInt(tuoi);
        }catch (Exception e){
            check = true;
            request.setAttribute("Errol_tuoi", "tuoi trong");
        }
        if(queQuan.isEmpty()){
            check=true;
            request.setAttribute("Errol_queQuan","quê trống");
        }
        if(check){
            hienThi(request,response);
        }else{
            GiangVien gv = GiangVien.builder().maGV(maGV).ten(ten).tuoi(tuois).queQuan(queQuan).build();
            giangVienService.addGiangVien(gv);
            hienThi(request,response);
        }

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maGV=request.getParameter("maGV");
        GiangVien gv=giangVienService.getOne(maGV);
        request.setAttribute("gv1",gv);
        request.getRequestDispatcher("/view/Edit.jsp").forward(request,response);
    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Update");
        String maGV=request.getParameter("maGV");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String queQuan = request.getParameter("queQuan");
        boolean check=false;
        if(maGV.isEmpty()){
            check=true;
            request.setAttribute("Errol_maGV","Mã trống");
        }
        if(ten.isEmpty()){
            check=true;
            request.setAttribute("Errol_ten","tên trống");
        }
        int tuois=0;
        try{
            tuois = Integer.parseInt(tuoi);
        }catch (Exception e){
            check = true;
            request.setAttribute("Errol_tuoi", "tuoi trong");
        }
        if(queQuan.isEmpty()){
            check=true;
            request.setAttribute("Errol_queQuan","quê trống");
        }
        if(check){
            request.getRequestDispatcher("/view/Edit.jsp").forward(request,response);
        }else{
            GiangVien gvUpdate=new GiangVien(maGV,ten,Integer.parseInt(tuoi),queQuan);
            GiangVien gv=giangVienService.updateGiangVien(gvUpdate);
            System.out.println("Tao là 2: "+gv);
            hienThi(request,response);
        }


    }


    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Haha");
        String ten=request.getParameter("tenTim");
        String tuoiMinString = request.getParameter("tuoiMin");
        String tuoiMaxString = request.getParameter("tuoiMax");
        request.setAttribute("tenTim",ten);
        request.setAttribute("tuoiMaxString",tuoiMaxString);
        request.setAttribute("tuoiMinString",tuoiMinString);
//        int tuoiMin=Integer.parseInt(request.getParameter("tuoiMin"));
//        int tuoiMax=Integer.parseInt(request.getParameter("tuoiMax"));
        if(!ten.trim().equals("") && tuoiMaxString.trim().isEmpty() && tuoiMinString.trim().isEmpty()){
            listGV=giangVienService.timKiem(ten,1,1000000);
            request.setAttribute("listGV",listGV);
            request.getRequestDispatcher("/view/List.jsp").forward(request,response);
        }
        if(ten.trim().equals("") && !tuoiMaxString.trim().isEmpty() && !tuoiMinString.trim().isEmpty()){
            System.out.println("hi2");
            listGV=giangVienService.timKiem(ten,Integer.parseInt(tuoiMinString),Integer.parseInt(tuoiMaxString));
            System.out.println("hi3: "+tuoiMaxString+tuoiMaxString);
            request.setAttribute("listGV",listGV);
            request.getRequestDispatcher("/view/List.jsp").forward(request,response);
        }
        if(ten.trim().equals("") && !tuoiMaxString.trim().isEmpty() && tuoiMinString.trim().isEmpty()){
            System.out.println("max");
            listGV=giangVienService.timKiem(ten,1,Integer.parseInt(tuoiMaxString));
            request.setAttribute("listGV",listGV);
            request.getRequestDispatcher("/view/List.jsp").forward(request,response);
        }
        if(ten.trim().equals("") && tuoiMaxString.trim().isEmpty() && !tuoiMinString.trim().isEmpty()){
            System.out.println("min");
            listGV=giangVienService.timKiem(ten,Integer.parseInt(tuoiMinString),1000000);
            request.setAttribute("listGV",listGV);
            request.getRequestDispatcher("/view/List.jsp").forward(request,response);
        }
        if(!ten.trim().equals("") && !tuoiMaxString.trim().isEmpty() && !tuoiMinString.trim().isEmpty()){
            System.out.println("min");
            listGV=giangVienService.timKiem(ten,Integer.parseInt(tuoiMinString),Integer.parseInt(tuoiMaxString));
            request.setAttribute("listGV",listGV);
            request.getRequestDispatcher("/view/List.jsp").forward(request,response);
        }


    }
}

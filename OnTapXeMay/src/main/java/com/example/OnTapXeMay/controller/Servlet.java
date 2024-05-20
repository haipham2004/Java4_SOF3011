package com.example.OnTapXeMay.controller;

import com.example.OnTapXeMay.config.HibernateConfig;
import com.example.OnTapXeMay.entity.LoaiXeMay;
import com.example.OnTapXeMay.entity.XeMay;
import com.example.OnTapXeMay.repository.LoaiXeMayRepository;
import com.example.OnTapXeMay.request.XeMayRequest;
import com.example.OnTapXeMay.response.XeMayResponse;
import com.example.OnTapXeMay.service.XeMayServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = {
        "/HienThi",
        "/Delete",
        "/Add",
        "/viewUpdate",
        "/Update"
})
public class Servlet extends HttpServlet {
    List<XeMayResponse> listXM = new ArrayList<>();
    XeMayServiceImp service = new XeMayServiceImp();
    List<LoaiXeMay> listLXM = new ArrayList<>();
    LoaiXeMayRepository service2 = new LoaiXeMayRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThi")) {
            HienThi(request, response);
        } else if (uri.contains("Delete")) {
            Delete(request, response);
        } else if (uri.contains("viewUpdate")) {
            viewUpdate(request, response);
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

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id=Integer.parseInt(request.getParameter("id"));
//       XeMay xm=service.getOne(id);
//       request.setAttribute("xm",xm);
//       request.getRequestDispatcher("/view/Update.jsp").forward(request,response);
        try(Session session= HibernateConfig.getFACTORY().openSession()) {
            XeMay xm=session.get(XeMay.class,id);
            List<LoaiXeMay> listLXM=service2.getAll();
            request.setAttribute("xm",xm);
            request.setAttribute("listLXM",listLXM);
                   request.getRequestDispatcher("/view/Update.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        XeMay xm = service.getOne(id);
        service.delete(xm);
        if (service.getAll().size() == 0) {
            request.setAttribute("listRong", "List rỗng");
            request.getRequestDispatcher("/view/ListXeMay.jsp").forward(request, response);
        }
        response.sendRedirect("/HienThi");
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listXM = service.getAll();
        request.setAttribute("listXM", listXM);
        listLXM = service2.getAll();
        request.setAttribute("listLXM", listLXM);
        request.getRequestDispatcher("/view/ListXeMay.jsp").forward(request, response);
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String moTa = request.getParameter("moTa");
        String soLuong = request.getParameter("soLuong");
        String idLoaiXeMay = request.getParameter("idLoaiXeMay");
        XeMayRequest xeMayRequest = XeMayRequest.builder().id(Integer.parseInt(id)).ma(ma).ten(ten).moTa(moTa).
                soLuong(Integer.parseInt(soLuong)).idLoaiXeMay(Integer.parseInt(idLoaiXeMay)).build();
        boolean isDuplicate = false;
        for (XeMayResponse xm : service.getAll()) {
            if (xm.getMa().equals(ma)) {
                isDuplicate = true;
                break;
            }
        }
        if (isDuplicate) {
            request.setAttribute("MaTrung", "Mã trùng");
            System.out.println("Mã trùng");
        } else {
            service.updateRequest(xeMayRequest);
        }

        listXM = service.getAll();
        request.setAttribute("listXM", listXM);
        listLXM = service2.getAll();
        request.setAttribute("listLXM", listLXM);
        request.getRequestDispatcher("/view/ListXeMay.jsp").forward(request, response);
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String moTa = request.getParameter("moTa");
        String soLuong = request.getParameter("soLuong");
        String idLoaiXeMay = request.getParameter("idLoaiXeMay");
        XeMayRequest xeMayRequest = XeMayRequest.builder().ma(ma).ten(ten).moTa(moTa).soLuong(Integer.parseInt(soLuong)).idLoaiXeMay(Integer.parseInt(idLoaiXeMay)).build();

        boolean isDuplicate = false;

        for (XeMayResponse xm : service.getAll()) {
            if (xm.getMa().equals(ma)) {
                isDuplicate = true;
                break;
            }
        }
        if (isDuplicate) {
            request.setAttribute("MaTrung", "Mã trùng");
            System.out.println("Mã trùng");
        } else {
            service.addRequest(xeMayRequest);
        }

        listXM = service.getAll();
        request.setAttribute("listXM", listXM);
        listLXM = service2.getAll();
        request.setAttribute("listLXM", listLXM);
        request.getRequestDispatcher("/view/ListXeMay.jsp").forward(request, response);
    }

}

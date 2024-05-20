package com.example.OnTapDTO1s.controller;

import com.example.OnTapDTO1s.config.HibernateConfig;
import com.example.OnTapDTO1s.entiy.Ban;
import com.example.OnTapDTO1s.entiy.MoiQuanHe;
import com.example.OnTapDTO1s.repository.MoiQuanHeRepository;
import com.example.OnTapDTO1s.request.BanRequest;
import com.example.OnTapDTO1s.response.BanResponse;
import com.example.OnTapDTO1s.service.impl.BanServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = {
        "/HienThi",
        "/Delete",
        "/Add",
        "/ViewUpdate",
        "/Update"
})
public class Servlet extends HttpServlet {
    List<BanResponse> listB = new ArrayList<>();
    BanServiceImp service = new BanServiceImp();
    List<MoiQuanHe> listMQH = new ArrayList<>();
    MoiQuanHeRepository service2 = new MoiQuanHeRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("HienThi")) {
            HienThi(request, response);
        } else if (uri.contains("Delete")) {
            Delete(request, response);
        } else if (uri.contains("ViewUpdate")) {
            ViewUpdate(request, response);
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

    private void ViewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id=Integer.parseInt(request.getParameter("id"));
//        Ban ban=service.getOne(id);
//        request.setAttribute("ban",ban);
//        listMQH = service2.getAll();
//        request.setAttribute("listMQH", listMQH);
//        request.getRequestDispatcher("/view/Update.jsp").forward(request,response);
        Transaction transaction=null;
        try( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction= session.beginTransaction();
            int id = Integer.parseInt(request.getParameter("id"));
            Ban ban = session.get(Ban.class, id);
            List<MoiQuanHe> listMQH = session.createQuery("FROM MoiQuanHe", MoiQuanHe.class).getResultList();
            transaction.commit();
            session.close();
            request.setAttribute("ban", ban);
            request.setAttribute("listMQH", listMQH);
            request.getRequestDispatcher("/view/Update.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String soThich = request.getParameter("soThich");
        String gioiTinh = request.getParameter("gioiTinh");
        String idMoiQuanHe = request.getParameter("idMoiQuanHe");
        BanRequest banRequest = BanRequest.builder().ma(ma).ten(ten).soThich(soThich).gioiTinh(Boolean.parseBoolean(gioiTinh)).idMoiQuanHe(Integer.parseInt(idMoiQuanHe)).build();
        service.updateRequest(banRequest);
        response.sendRedirect("/HienThi");
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ban ban = service.getOne(id);
        service.delete(ban);
        response.sendRedirect("/HienThi");
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listB = service.getAll();
        request.setAttribute("listB", listB);
        listMQH = service2.getAll();
        request.setAttribute("listMQH", listMQH);
//        phanTrang(listB,request,response);
        request.getRequestDispatcher("/view/ListBan.jsp").forward(request, response);
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String soThich = request.getParameter("soThich");
        String gioiTinh = request.getParameter("gioiTinh");
        String idMoiQuanHe = request.getParameter("idMoiQuanHe");
        BanRequest banRequest = BanRequest.builder().ma(ma).ten(ten).soThich(soThich).gioiTinh(Boolean.parseBoolean(gioiTinh)).idMoiQuanHe(Integer.parseInt(idMoiQuanHe)).build();
        service.addRequest(banRequest);
        response.sendRedirect("/HienThi");
    }

//    public void phanTrang(List<BanResponse> list,HttpServletRequest req,HttpServletResponse rep){
//        List<BanResponse> listB=list;
//        int trangHienTai=1;
//        int soBanGhiTrang=3;
//        int tongBanGhi=listB.size();
//        int tongSoTrang= (int) Math.ceil((double)tongBanGhi/soBanGhiTrang);
//        String page=req.getParameter("page");
//        if(page!=null && !page.isEmpty()){
//            trangHienTai=Integer.parseInt(page);
//        }
//        if(trangHienTai<1){
//            trangHienTai=1;
//        }else if(trangHienTai>tongSoTrang){
//            trangHienTai=tongSoTrang;
//        }
//        System.out.println("TrangHienTai: "+trangHienTai+" sosoBanGhiTrang"+soBanGhiTrang+" tongBanGhi"+tongBanGhi+" tongSoTrang"+tongSoTrang);
//        int startIndex=(trangHienTai-1)*soBanGhiTrang;
//        int endIndex=Math.min((startIndex+soBanGhiTrang),tongBanGhi);
//        List<BanResponse> listBPT=listB.subList(startIndex,endIndex);
//        req.setAttribute("listBPT",listBPT);
//        req.setAttribute("trangHienTai",trangHienTai);
//        req.setAttribute("tongSoTrang",tongSoTrang);
//    }

}

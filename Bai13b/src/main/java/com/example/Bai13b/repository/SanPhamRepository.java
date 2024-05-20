//package com.example.Bai13b.repository;
//
//import com.example.Bai13b.config.HibernateConfig;
//import org.hibernate.Session;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SanPhamRepository {
//    List<SanPham> listSP=new ArrayList<>();
//    public List<SanPham> getAll(){
//        Session session= HibernateConfig.getFACTORY().openSession();
//        listSP=session.createQuery("From SanPham",SanPham.class).getResultList();
//        return listSP;
//    }
//}

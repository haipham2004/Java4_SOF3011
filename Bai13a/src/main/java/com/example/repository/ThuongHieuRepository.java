package com.example.repository;

import com.example.config.HibernateUtil;
import com.example.entity.ChiTietSanPham;
import com.example.entity.ThuongHieu;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ThuongHieuRepository {
    private List<ThuongHieu> listTH=new ArrayList<>();

    public List<ThuongHieu> getAll(){
        Session session= HibernateUtil.getFACTORY().openSession();
        listTH=session.createQuery("From ThuongHieu ",ThuongHieu.class).getResultList();
        return listTH;
    }

    public static void main(String[] args) {
        ThuongHieuRepository repo=new ThuongHieuRepository();
        System.out.println("Haha: "+repo.getAll());
    }

}

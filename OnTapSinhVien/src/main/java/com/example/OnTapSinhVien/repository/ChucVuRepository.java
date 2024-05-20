package com.example.OnTapSinhVien.repository;

import com.example.OnTapSinhVien.config.HibernateConfig;
import com.example.OnTapSinhVien.entity.ChucVu;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ChucVuRepository {
    List<ChucVu> listCV=new ArrayList<>();

    public List<ChucVu> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listCV=session.createQuery("FROM ChucVu",ChucVu.class).getResultList();
        return listCV;
    }

    public static void main(String[] args) {
        System.out.println("haha: "+new ChucVuRepository().getAll());
    }
}

package com.example.OnTapSinhVien.repository;

import com.example.OnTapSinhVien.config.HibernateConfig;
import com.example.OnTapSinhVien.response.NhanVienResponse;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    List<NhanVienResponse> listNV=new ArrayList<>();

    public List<NhanVienResponse> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listNV=session.createQuery("SELECT new com.example.OnTapSinhVien.response.NhanVienResponse(nv.id,nv.ma,nv.ten,nv.gioiTinh,nv.chucVu.id,nv.chucVu.ten) FROM NhanVien  nv", NhanVienResponse.class).getResultList();
        return listNV;
    }

    public static void main(String[] args) {
        System.out.println("haha: "+new NhanVienRepository().getAll());
    }
}

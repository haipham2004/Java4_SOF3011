package com.example.OnTapXeMay.repository;

import com.example.OnTapXeMay.config.HibernateConfig;
import com.example.OnTapXeMay.entity.LoaiXeMay;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class LoaiXeMayRepository {
    List<LoaiXeMay> listLXM=new ArrayList<>();
    public List<LoaiXeMay> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listLXM=session.createQuery("FROM LoaiXeMay", LoaiXeMay.class).getResultList();
        return listLXM;
    }

    public LoaiXeMay getOne(int id){
        LoaiXeMay loaiXeMay=null;
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            loaiXeMay=session.get(LoaiXeMay.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return loaiXeMay;
    }

    public static void main(String[] args) {
        System.out.println("haha: "+new LoaiXeMayRepository().getOne(2));
    }
}

package com.example.OnTapDTO1s.repository;

import com.example.OnTapDTO1s.config.HibernateConfig;
import com.example.OnTapDTO1s.entiy.Ban;
import com.example.OnTapDTO1s.entiy.MoiQuanHe;
import com.example.OnTapDTO1s.response.BanResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MoiQuanHeRepository {
    List<MoiQuanHe> listMQH=new ArrayList<>();
    public List<MoiQuanHe> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listMQH=session.createQuery("FROM MoiQuanHe",MoiQuanHe.class).getResultList();
        return listMQH;
    }
    public MoiQuanHe getOne(int id){
        MoiQuanHe moiQuanHe=null;
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            moiQuanHe=session.get(MoiQuanHe.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return moiQuanHe;
    }
}

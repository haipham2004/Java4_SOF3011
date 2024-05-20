package com.example.Bai13b.repository;

import com.example.Bai13b.config.HibernateConfig;
import com.example.Bai13b.entity.MayTinh;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MayTinhRepository {
    List<MayTinh> listMT=new ArrayList<>();
    public List<MayTinh> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listMT=session.createQuery("From MayTinh",MayTinh.class).getResultList();
        return listMT;
    }
    public MayTinh getOne(int id){
        Transaction transaction=null;
        MayTinh ctsp=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            ctsp=session.get(MayTinh.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return ctsp;
    }
    public boolean add(MayTinh ctsp){
        Transaction transaction=null;

        try(Session session= HibernateConfig.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.save(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean update(MayTinh ctsp){
        Transaction transaction=null;

        try(Session session= HibernateConfig.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.update(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(MayTinh ctsp){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<MayTinh> timKiem(double giaMin,double giaMax){
        List<MayTinh> listMT2=new ArrayList<>();
        Transaction transaction=null;

        try(Session session= HibernateConfig.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            Query query =session.createQuery("FROM MayTinh mt where mt.gia>=:giaMin and mt.gia<=:giaMax ",MayTinh.class);
            query.setParameter("giaMin",giaMin);
            query.setParameter("giaMax",giaMax);
            listMT2=query.getResultList();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return listMT2;
    }
    
}

package com.example.repository;

import com.example.config.HibernateUtil;
import com.example.entity.GiangVien;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class GiangVienRepository {
    List<GiangVien> listGV=new ArrayList<>();
    public List<GiangVien> getAll(){
        Session session= HibernateUtil.getFACTORY().openSession();
        listGV=session.createQuery("FROM GiangVien").getResultList();
        return listGV;
    }
    public GiangVien getOne(long id){
        Transaction transaction=null;
        GiangVien gv=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            gv=session.get(GiangVien.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return gv;
    }
    public boolean addGiangVien(GiangVien gv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(gv);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean updateGiangVien(GiangVien gv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(gv);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteGiangVien(GiangVien gv){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(gv);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GiangVienRepository repository=new GiangVienRepository();
        List<GiangVien> list=repository.getAll();
        for(GiangVien gv:list){
            System.out.println("Ta là: "+gv);
        }
        long id=2;
        GiangVien gvs=repository.getOne(id);
        System.out.println("ta là hi:"+gvs);
    }
}

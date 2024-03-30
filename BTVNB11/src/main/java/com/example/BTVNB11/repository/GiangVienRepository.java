package com.example.BTVNB11.repository;

import com.example.BTVNB11.config.HibernateUtl;
import com.example.BTVNB11.entity.GiangVien;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class GiangVienRepository {
    List<GiangVien> listGV=new ArrayList<>();
    public List<GiangVien> getAll(){
        Session session= HibernateUtl.getFACTORY().openSession();
        listGV= (List<GiangVien>) session.createQuery("From GiangVien ",GiangVien.class).getResultList();
        return listGV;
    }

    public GiangVien getOne(int id){
        GiangVien gv=null;
        Transaction transaction=null;
        try(Session session=HibernateUtl.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            gv=session.get(GiangVien.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return gv;
    }

    public boolean addGiangVien(GiangVien gv){
        Transaction transaction=null;
        try(Session session=HibernateUtl.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.persist(gv);
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
        try(Session session=HibernateUtl.getFACTORY().openSession()){
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
        try(Session session=HibernateUtl.getFACTORY().openSession()){
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

    public List<GiangVien> listGiangVienNu(boolean gioiTinh){
        List<GiangVien> listGV2=new ArrayList<>();
        Transaction transaction=null;
        try(Session session=HibernateUtl.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("From GiangVien  where gioiTinh=:gioiTinh",GiangVien.class);
            query.setParameter("gioiTinh",gioiTinh);
            listGV2=query.getResultList();
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return listGV2;
    }

    public List<GiangVien> listTen(String name){
        List<GiangVien> listGV3=new ArrayList<>();
        Transaction transaction=null;
        try(Session session=HibernateUtl.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("From GiangVien  where ten=:name",GiangVien.class);
            query.setParameter("name",name);
            listGV3=query.getResultList();
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return listGV3;
    }

    public static void main(String[] args) {
        GiangVienRepository repo=new GiangVienRepository();
        boolean gt=true;
        List<GiangVien> list=repo.getAll();
        for(GiangVien gv:list){
            System.out.println("Lala: "+gv);
        }
    }
}

package com.example.repository;

import com.example.config.HibernateUtil;
import com.example.entity.ChiTietSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamRepository {
    private List<ChiTietSanPham> listCTSP=new ArrayList<>();

    public List<ChiTietSanPham> getAll(){
        Session session= HibernateUtil.getFACTORY().openSession();
        listCTSP=session.createQuery("From ChiTietSanPham ",ChiTietSanPham.class).getResultList();
        return listCTSP;
    }

    public ChiTietSanPham getOne(int id){
        Transaction transaction=null;
        ChiTietSanPham ctsp=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
           transaction=session.beginTransaction();
           ctsp=session.get(ChiTietSanPham.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return ctsp;
    }

    public boolean add(ChiTietSanPham ctsp){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(ChiTietSanPham ctsp){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(ChiTietSanPham ctsp){
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<ChiTietSanPham> listTenThuongHieu(int id){
        List<ChiTietSanPham> listCTSP2=new ArrayList<>();
        Transaction transaction=null;
        try(Session session= HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("From ChiTietSanPham ctsp where ctsp.thuongHieu.idThuongHieu=:id");
            query.setParameter("id",id);
            listCTSP2=query.getResultList();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return listCTSP2;
    }

    public static void main(String[] args) {
           ChiTietSanPhamRepository stsp=new ChiTietSanPhamRepository();
        System.out.println("haha: "+stsp.getAll());
    }
}

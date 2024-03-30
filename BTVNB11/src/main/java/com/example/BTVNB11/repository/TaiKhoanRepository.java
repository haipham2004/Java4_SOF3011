package com.example.BTVNB11.repository;

import com.example.BTVNB11.config.HibernateUtl;
import com.example.BTVNB11.entity.TaiKhoan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TaiKhoanRepository {
    public TaiKhoan login(String usernames,String passwords){
        Transaction transaction=null;
        TaiKhoan taiKhoan=null;
        try(Session session= HibernateUtl.getFACTORY().openSession()){
            transaction= session.beginTransaction();
            Query query=session.createQuery("From TaiKhoan where username=:usernames and password=:passwords",TaiKhoan.class);
           query.setParameter("usernames",usernames);
            query.setParameter("passwords",passwords);
            taiKhoan= (TaiKhoan) query.getSingleResult();
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return taiKhoan;
    }

    public static void main(String[] args) {
        TaiKhoanRepository repository=new TaiKhoanRepository();
        TaiKhoan tk=repository.login("Haipnph","Hoilamgia");
        System.out.println("Ghéc: "+tk);
    }
}

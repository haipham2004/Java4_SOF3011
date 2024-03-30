package com.example.HibernateB1.repository;

import com.example.HibernateB1.config.HibernateUtil;
import com.example.HibernateB1.entity.Category;
import com.example.HibernateB1.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    List<Product> listP=new ArrayList<>();

    public List<Product> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        listP = session.createQuery("From Product").getResultList();
        return listP;
    }
    public boolean addProduct(Product prd){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(prd);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateProduct(Product prd){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(prd);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteProduct(Product prd){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(prd);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Product getOne(int id){
        Product prd=null;
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            prd=session.get(Product.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return prd;
    }


    public static void main(String[] args) {
        ProductRepository repo=new ProductRepository();
        List<Product> listP=repo.getAll();
        for(Product prd:listP){
            System.out.println("Tao laf: "+prd);
        }
        System.out.println("tao là: "+repo.getOne(12));
    }
}

package com.example.HibernateB1.repository;

import com.example.HibernateB1.config.HibernateUtil;
import com.example.HibernateB1.entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    List<Category> listC = new ArrayList<>();

    public List<Category> getAll() {
        Session session = HibernateUtil.getFACTORY().openSession();
        listC = session.createQuery("From Category ").getResultList();
        return listC;
    }

    public Category getOne(long id) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Category c = (Category) session.createQuery("From Category where id=:id").getSingleResult();
        return c;
    }

    public boolean addCategory(Category cate) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(cate);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateCate(Category cate) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(cate);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteCategory(Category cate) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cate);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Category> timKiem(String name) {
        Transaction transaction = null;
        List<Category> listC = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = (Query) session.createQuery("From Category where categoryName=:name ").getResultList();
            query.setParameter("name", name);
            listC = query.getResultList();
            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listC;
    }

    public static void main(String[] args) {
        CategoryRepository repo = new CategoryRepository();
        List<Category> listPa = repo.getAll();
        for (Category prd : listPa) {
            System.out.println("Tao laf: " + prd);
        }
    }
}

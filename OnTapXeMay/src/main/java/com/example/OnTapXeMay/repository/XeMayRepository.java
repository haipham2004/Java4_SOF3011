package com.example.OnTapXeMay.repository;

import com.example.OnTapXeMay.config.HibernateConfig;
import com.example.OnTapXeMay.entity.XeMay;
import com.example.OnTapXeMay.response.XeMayResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class XeMayRepository {
    List<XeMayResponse> listXM = new ArrayList<>();

    public List<XeMayResponse> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        listXM = session.createQuery("SELECT new com.example.OnTapXeMay.response.XeMayResponse(xm.id,xm.ma,xm.ten,xm.moTa,xm.soLuong,xm.loaiXeMay.ten,xm.loaiXeMay.id) FROM XeMay xm", XeMayResponse.class).getResultList();
        return listXM;
    }

    public XeMay getOne(int id) {
        XeMay xm = null;
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            xm = session.get(XeMay.class, id);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return xm;
    }

    public boolean add(XeMay xm) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(xm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(XeMay xm) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(xm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(XeMay xm) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(xm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("haha: " + new XeMayRepository().getOne(2));
    }
}

package com.example.BTVN12c.repository;

import com.example.BTVN12c.config.HibernateUtil;
import com.example.BTVN12c.entity.LopHoc;
import com.example.BTVN12c.entity.SinhVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LopHocRepository {
    private List<LopHoc> listLopHoc = new ArrayList<>();

    public List<LopHoc> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("From LopHoc", LopHoc.class);
            listLopHoc = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listLopHoc;
    }
}

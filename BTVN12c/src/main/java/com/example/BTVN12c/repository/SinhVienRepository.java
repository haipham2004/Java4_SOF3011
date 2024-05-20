package com.example.BTVN12c.repository;

import com.example.BTVN12c.config.HibernateUtil;
import com.example.BTVN12c.entity.LopHoc;
import com.example.BTVN12c.entity.SinhVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class SinhVienRepository {
    private List<SinhVien> listSinhVien = new ArrayList<>();

    public List<SinhVien> getAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("From SinhVien", SinhVien.class);
            listSinhVien = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listSinhVien;
    }

    public boolean add(SinhVien sv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sv);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(SinhVien sv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sv);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(SinhVien sv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sv);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public SinhVien getOne(int id) {
        SinhVien sv = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            sv = session.get(SinhVien.class, id);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return sv;
    }

    public List<SinhVien> listTimKiem(LopHoc lh){
        List<SinhVien> listSinhVien2 = new ArrayList<>();
        Transaction transaction=null;
        try(Session session=HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("From SinhVien where lop_id=:lh", SinhVien.class);
            query.setParameter("lh",lh);
            listSinhVien2 = query.getResultList();
            transaction.commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return listSinhVien2;
    }

    public List<SinhVien> listTimKiemTop3(){
            List<SinhVien> listSinhVien3 = new ArrayList<>();
            Transaction transaction=null;
            try(Session session=HibernateUtil.getFACTORY().openSession()) {
                transaction = session.beginTransaction();
                Query query = session.createQuery("SELECT sv From  SinhVien sv Inner Join sv.lopHoc l WHERE l.ten = 'SD18321' ORDER BY sv.tuoi", SinhVien.class);
                query.setMaxResults(3);
                listSinhVien3 = query.getResultList();
                transaction.commit();
                session.close();

            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
            return listSinhVien3;
    }
}

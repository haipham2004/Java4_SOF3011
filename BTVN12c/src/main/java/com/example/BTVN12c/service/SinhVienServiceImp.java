package com.example.BTVN12c.service;

import com.example.BTVN12c.entity.LopHoc;
import com.example.BTVN12c.entity.SinhVien;
import com.example.BTVN12c.repository.SinhVienRepository;

import java.util.List;

public class SinhVienServiceImp implements SinhVienService{
    SinhVienRepository repo=new SinhVienRepository();
    @Override
    public List<SinhVien> getAll() {
        return repo.getAll();
    }

    @Override
    public boolean add(SinhVien sv) {
        return repo.add(sv);
    }

    @Override
    public boolean update(SinhVien sv) {
        return repo.update(sv);
    }

    @Override
    public boolean delete(SinhVien sv) {
        return repo.delete(sv);
    }

    @Override
    public SinhVien getOne(int ma) {
        return repo.getOne(ma);
    }
    public List<SinhVien> listTimKiem(LopHoc lh){
      return   repo.listTimKiem(lh);
    }
    public List<SinhVien> listTimKiemTop3(){
         return repo.listTimKiemTop3();
    }
}
